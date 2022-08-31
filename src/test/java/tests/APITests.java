package tests;

import adaptors.ProjectAdaptor;
import com.google.gson.Gson;
import lombok.Builder;
import models.*;
import models.project.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import java.util.Arrays;

public class APITests {
    private final ProjectAdaptor projectAdaptor = new ProjectAdaptor();
    Gson gson = new Gson();

    @Test
    public void getAllProjectsPositiveTest() {
        Response<AllEntitiesResult<Project>> expectedResponse =
            Response.<AllEntitiesResult<Project>>builder()
                .result(AllEntitiesResult.<Project>builder()
                    .total(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getAllProjects.total"
                    )))
                    .filtered(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getAllProjects.filtered"
                    )))
                    .count(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getAllProjects.count"
                    )))
                    .entities(Arrays.asList(
                        Project.builder()
                            .code(PropertyReader.getProperty(
                                "qase.api.getAllProjects.first_project.project_code"))
                            .title(PropertyReader.getProperty(
                                "qase.api.getAllProjects.first_project.project_title"))
                            .counts(Counts.builder()
                                .cases(Integer.parseInt(PropertyReader.getProperty(
                                    "qase.api.getAllProjects.first_project.project_counts_cases")))
                                .suites(Integer.parseInt(PropertyReader.getProperty(
                                    "qase.api.getAllProjects.first_project.project_counts_suits")))
                                .milestones(Integer.parseInt(PropertyReader.getProperty(
                                    "qase.api.getAllProjects.first_project.project_counts_milestones")))
                                .runs(Runs.builder().build())
                                .defects(Defects.builder().build())
                                .build())
                            .build(),
                        Project.builder()
                            .code(PropertyReader.getProperty(
                                "qase.api.getAllProjects.second_project.project_code"
                            ))
                            .title(PropertyReader.getProperty(
                                "qase.api.getAllProjects.second_project.project_title"))

                            .counts(Counts.builder()
                                .cases(Integer.parseInt(PropertyReader.getProperty(
                                    "qase.api.getAllProjects.second_project.project_counts_cases")))
                                .suites(Integer.parseInt(PropertyReader.getProperty(
                                    "qase.api.getAllProjects.second_project.project_counts_suits")))
                                .runs(Runs.builder().build())
                                .defects(Defects.builder()
                                    .total(Integer.parseInt(PropertyReader.getProperty(
                                        "qase.api.getAllProjects.second_project.project_counts_defects_total")))
                                    .open(Integer.parseInt(PropertyReader.getProperty(
                                        "qase.api.getAllProjects.second_project.project_counts_defects_open")))
                                    .build())
                                .build())
                            .build()))
                    .build())
                .build();
        Response<AllEntitiesResult<Project>> actualResponse =
            projectAdaptor.getAllProjects(200, 2);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getAllProjectsNegativeTest() {
        Response<Project> expectedResponse = Response
            .<Project>builder()
            .status(false)
            .errorMessage("Data is invalid.")
            .errorFields(Arrays.asList(
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
            "qase.api.project.createProject_deleteProject.project_code");

        Project project = Project.builder()
                .title(PropertyReader.getProperty(
                    "qase.api.project.createProject.project_title"))
                .code(projectCode)
                .description(PropertyReader.getProperty(
                    "qase.api.project.createProject.project_description"))
                .build();

        Response<Project> expectedResponse = Response
                .<Project>builder()
                .result(Project.builder()
                        .code(projectCode)
                .build())
            .build();

        Response<Project> actualResponse =
                projectAdaptor.createProject(200, gson.toJson(project));
        Assert.assertEquals(actualResponse, expectedResponse);
    }


    @Test
    public void createProjectNegativeTest() {
        Project project = Project.builder()
            .title("")
            .code("")
            .build();

        Response expectedResponse = Response
            .builder()
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
        Response response = projectAdaptor.createProject(
            400, gson.toJson(project));
        Assert.assertEquals(response, expectedResponse);
    }

    @Test
    public void getProjectByCodePositiveTest() {
        Response<Project> expectedResponse = Response.<Project>builder()
            .result(Project.builder()
                .code(PropertyReader.getProperty(
                    "qase.api.getProjectByCode.project_code"))
                .title(PropertyReader.getProperty(
                    "qase.api.getProjectByCode.project_title"))
                .counts(Counts.builder()
                    .cases(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getProjectByCode.project_counts_cases"
                    )))
                    .suites(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getProjectByCode.project_counts_suits"
                    )))
                    .milestones(Integer.parseInt(PropertyReader.getProperty(
                        "qase.api.getProjectByCode.project_counts_milestones"
                    )))
                    .runs(Runs.builder().build())
                    .defects(Defects.builder()
                        .total(Integer.parseInt(PropertyReader.getProperty(
                            "qase.api.getProjectByCode.project_counts_defects_total"
                        )))
                        .open(Integer.parseInt(PropertyReader.getProperty(
                            "qase.api.getProjectByCode.project_counts_defects_open"
                        )))
                        .build())
                    .build())
                .build())
            .build();
        Response<Project> actualResponse = projectAdaptor.getProjectByCode(
            200, PropertyReader.getProperty(
                "qase.api.getProjectByCode.project_code"));
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteProjectByCodePositiveTest() {
        Response<Project> actualResponse = projectAdaptor.deleteProjectByCode(
            200, PropertyReader.getProperty(
                "qase.api.project.createProject_deleteProject.project_code"));
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
                "qase.api.project.deleteProject.no_existing_project_code"));
        Assert.assertEquals(actualResponse, expectedResponse);
    }

}
