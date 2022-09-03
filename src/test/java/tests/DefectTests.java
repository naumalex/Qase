package tests;

import adaptors.DefectAdaptor;
import com.google.gson.Gson;
import models.AllEntitiesResult;
import models.ErrorField;
import models.Response;
import models.defect.Defect;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DefectFactory;
import utils.PropertyReader;

import java.util.Arrays;

public class DefectTests {
    private static final String PROJECT_CODE = PropertyReader.getProperty(
        "qase.api.all.project_code");
    private static final Gson GSON = new Gson();
    private static final int LIMIT = 2;
    private static final DefectAdaptor defectAdaptor = new DefectAdaptor();


    @Test
    public void createDefectPositiveTest() {
        Defect defect = Defect.builder()
            .title(PropertyReader.getProperty("qase_api.defect.createDefect.title"))
            .actual_result(PropertyReader.getProperty("qase_api.defect.createDefect.actual_result"))
            .severity(PropertyReader.getProperty("qase_api.defect.createDefect.severity"))
            .build();

        Response<Defect> expectedResponse = Response
            .<Defect>builder()
            .result(Defect.builder()
                .build())
            .build();

        Response<Defect> actualResponse =
            defectAdaptor.createDefect(PROJECT_CODE, GSON.toJson(defect), HttpStatus.SC_OK);
        actualResponse.getResult().setId(null); //don't want to validate returned id

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void createDefectNegativeTest() {
        Defect defect = Defect.builder()
            .title("")
            .actual_result("")
            .severity("")
            .build();

        Response<Defect> expectedResponse = Response
            .<Defect>builder()
            .status(false)
            .errorMessage("Data is invalid.")
            .errorFields(Arrays.asList(
                ErrorField.builder()
                    .field("title")
                    .error("The title field is required.")
                    .build(),
                ErrorField.builder()
                    .field("actual_result")
                    .error("The actual result field is required.")
                    .build(),
                ErrorField.builder()
                    .field("severity")
                    .error("The severity field is required.")
                    .build()))
            .build();

        Response<Defect> actualResponse =
            defectAdaptor.createDefect(PROJECT_CODE, GSON.toJson(defect), HttpStatus.SC_BAD_REQUEST);

        Assert.assertEquals(actualResponse, expectedResponse);
    }


    @Test
    public void getAllDefectsPositiveTest() {
        Response<AllEntitiesResult<Defect>> expectedResponse =
            Response.<AllEntitiesResult<Defect>>builder()
                .result(AllEntitiesResult.<Defect>builder()
                    .total(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.defect.getAllDefects.total"
                    )))
                    .filtered(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.defect.getAllDefects.filtered"
                    )))
                    .count(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.defect.getAllDefects.count"
                    )))
                    .entities(Arrays.asList(
                        DefectFactory.getFirstDefectInfo(),
                        DefectFactory.getSecondDefectInfo()
                        ))
                    .build())
                .build();

        Response<AllEntitiesResult<Defect>> actualResponse =
            defectAdaptor.getAllDefects(PROJECT_CODE, LIMIT, HttpStatus.SC_OK);

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getAllDefectsNegativeTest() {
        Response<AllEntitiesResult<Defect>> expectedResponse = Response
            .<AllEntitiesResult<Defect>>builder()
            .status(false)
            .errorMessage("Project is not found.")
            .build();
        Response<AllEntitiesResult<Defect>> actualResponse =
            defectAdaptor.getAllDefects(
                PropertyReader.getProperty("qase.api.all.code_of_not_existing_project"),
                LIMIT, HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getDefectByProjectCodeAndDefectIdPositiveTest() {
    Response<Defect> expectedResponse = Response.<Defect>builder()
            .result(DefectFactory.getFirstDefectInfo())
            .build();
        Response<Defect> actualResponse = defectAdaptor.getDefectByProjectCodeAndDefectId(
            PROJECT_CODE, Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.all.id_of_existing_defect")), HttpStatus.SC_OK);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getDefectByProjectCodeAndDefectIdNegativeTest() {
        Response<Defect> expectedResponse = Response
            .<Defect>builder()
            .status(false)
            .errorMessage("Defect not found")
            .build();
        Response<Defect> actualResponse = defectAdaptor.getDefectByProjectCodeAndDefectId(
            PROJECT_CODE, Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.all.id_of_not_existing_defect")),
            HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteDefectByProjectCodeAndDefectIdPositiveTest() {
        final int DEFECT_ID = Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.deleteDefect.defectId"));

        Response<Defect> expectedResponse = Response.<Defect>builder()
            .result(Defect.builder()
                .id(DEFECT_ID)
                .build())
            .build();

        Response<Defect> actualResponse = defectAdaptor.deleteDefectByProjectCodeAndDefectId(
            PROJECT_CODE, DEFECT_ID, HttpStatus.SC_OK);

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteDefectByProjectCodeAndDefectIdNegativeTest() {
        Response<Defect> expectedResponse = Response
            .<Defect>builder()
            .status(false)
            .errorMessage("Defect not found")
            .build();

        Response<Defect> actualResponse = defectAdaptor.deleteDefectByProjectCodeAndDefectId(
            PROJECT_CODE, Integer.parseInt(PropertyReader.getProperty(
                "qase.api.defect.all.id_of_not_existing_defect")), HttpStatus.SC_NOT_FOUND);

        Assert.assertEquals(actualResponse, expectedResponse);
    }


    @Test
    public void updateDefectByProjectCodeAndDefectIdPositiveTest() {
        final int DEFECT_ID = Integer.parseInt(PropertyReader.getProperty(
            "qase.api.defect.updateDefect.defectId"));

        Defect requestBody = Defect.builder()
            .title(PropertyReader.getProperty("qase_api.defect.updateDefect.title"))
            .build();

        Response<Defect> expectedResponse = Response.<Defect>builder()
            .result(Defect.builder()
                .id(DEFECT_ID)
                .build())
            .build();

        Response<Defect> actualResponse = defectAdaptor.updateDefectByProjectCodeAndDefectId(
            PROJECT_CODE, DEFECT_ID, GSON.toJson(requestBody), HttpStatus.SC_OK);

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void updateDefectByProjectCodeAndDefectIdNegativeTest() {
        final int DEFECT_ID = Integer.parseInt(PropertyReader.getProperty(
            "qase.api.defect.updateDefect.defectId"));

        Defect requestBody = Defect.builder()
            .title(PropertyReader.getProperty("qase_api.defect.updateDefect.title"))
            .build();

        Response<Defect> expectedResponse = Response.<Defect>builder()
            .result(Defect.builder()
                .id(DEFECT_ID)
                .build())
            .build();

        Response<Defect> actualResponse = defectAdaptor.updateDefectByProjectCodeAndDefectId(
            PROJECT_CODE, DEFECT_ID, GSON.toJson(requestBody), HttpStatus.SC_OK);

        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
