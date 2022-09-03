package tests;

import adaptors.ProjectAdaptor;
import com.google.gson.Gson;
import models.*;
import models.project.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectFactory;
import utils.PropertyReader;

import java.util.Arrays;
import java.util.List;

public class ProjectTests {
    private final ProjectAdaptor projectAdaptor = new ProjectAdaptor();
    private static final Gson GSON = new Gson();
    private static final int LIMIT = 2;
    @Test
    public void getAllProjectsPositiveTest() {
        Response<AllEntitiesResult<Project>> expectedResponse =
            Response.<AllEntitiesResult<Project>>builder()
                .result(AllEntitiesResult.<Project>builder()
                    .total(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.total"
                    )))
                    .filtered(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.filtered"
                    )))
                    .count(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getAllProjects.count"
                    )))
                    .entities(Arrays.asList(
                        ProjectFactory.getFirstProjectInfo(),
                        ProjectFactory.getSecondProjectInfo()))
                    .build())
                .build();
        Response<AllEntitiesResult<Project>> actualResponse =
            projectAdaptor.getAllProjects(HttpStatus.SC_OK, LIMIT);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getAllProjectsNegativeTest() {
        Response<AllEntitiesResult<Project>> expectedResponse = Response
            .<AllEntitiesResult<Project>>builder()
            .status(false)
            .errorMessage("Data is invalid.")
            .errorFields(List.of(
                ErrorField.builder()
                    .field("limit")
                    .error("The limit must be at least 1.")
                    .build()))
            .build();
        Response<AllEntitiesResult<Project>> actualResponse =
            projectAdaptor.getAllProjects(400, 0);
        Assert.assertEquals(actualResponse, expectedResponse);
    }
    @Test
    public void createProjectPositiveTest() {
        String projectCode = PropertyReader.getProperty(
            "qase.api.project.createProject_deleteProject.code");

        Project project = Project.builder()
                .title(PropertyReader.getProperty(
                    "qase.api.project.createProject.title"))
                .code(projectCode)
                .description(PropertyReader.getProperty(
                    "qase.api.project.createProject.description"))
                .build();

        Response<Project> expectedResponse = Response
                .<Project>builder()
                .result(Project.builder()
                        .code(projectCode)
                .build())
            .build();

        Response<Project> actualResponse =
                projectAdaptor.createProject(200, GSON.toJson(project));
        Assert.assertEquals(actualResponse, expectedResponse);
    }


    @Test
    public void createProjectNegativeTest() {
        Project project = Project.builder()
            .title("")
            .code("")
            .build();

        Response<Project> expectedResponse = Response
            .<Project>builder()
            .status(false)
            .errorMessage("Data is invalid.")
            .errorFields(Arrays.asList(
                ErrorField.builder()
                    .field("title")
                    .error("Title is required.")
                    .build(),
                ErrorField.builder()
                    .field("code")
                    .error("Project code is required.")
                    .build()))
            .build();
        Response<Project> response = projectAdaptor.createProject(
            HttpStatus.SC_BAD_REQUEST, GSON.toJson(project));
        Assert.assertEquals(response, expectedResponse);
    }

    @Test
    public void getProjectByCodePositiveTest() {
        Response<Project> expectedResponse = Response.<Project>builder()
            .result(Project.builder()
                .code(PropertyReader.getProperty(
                    "qase.api.project.getProjectByCode.code"))
                .title(PropertyReader.getProperty(
                    "qase.api.project.getProjectByCode.title"))
                .counts(Counts.builder()
                    .cases(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getProjectByCode.counts_cases"
                    )))
                    .suites(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getProjectByCode.counts_suits"
                    )))
                    .milestones(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.project.getProjectByCode.counts_milestones"
                    )))
                    .runs(Runs.builder().build())
                    .defects(Defects.builder()
                        .total(Integer.parseInt(PropertyReader.getProperty(
                            "qase.api.project.getProjectByCode.counts_defects_total"
                        )))
                        .open(Integer.parseInt(PropertyReader.getProperty(
                            "qase.api.project.getProjectByCode.counts_defects_open"
                        )))
                        .build())
                    .build())
                .build())
            .build();
        Response<Project> actualResponse = projectAdaptor.getProjectByCode(
            200, PropertyReader.getProperty(
                "qase.api.project.getProjectByCode.code"));
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getProjectByCodeNegativeTest() {
        Response<Project> expectedResponse = Response
            .<Project>builder()
            .status(false)
            .errorMessage("Project is not found.")
            .build();

        Response<Project> actualResponse = projectAdaptor.getProjectByCode(
            HttpStatus.SC_NOT_FOUND, PropertyReader.getProperty(
                "qase.api.all.code_of_not_existing_project"));

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteProjectByCodePositiveTest() {
        Response<Project> actualResponse = projectAdaptor.deleteProjectByCode(
            200, PropertyReader.getProperty(
                "qase.api.project.createProject_deleteProject.code"));
        Response<Project> expectedResponse = Response.<Project>builder().build();

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteProjectByCodeNegativeTest() {
        Response<Project> expectedResponse = Response
            .<Project>builder()
            .status(false)
            .errorMessage("Project is not found.")
            .build();
        Response<Project> actualResponse = projectAdaptor.deleteProjectByCode(
            404, PropertyReader.getProperty(
                "qase.api.all.code_of_not_existing_project"));
        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
