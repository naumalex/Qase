package tests;

import adaptors.ProjectAdaptor;
import com.google.gson.Gson;
import models.Project;
import models.ProjectResponse;
import models.Result;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class APITests {
    private final String ACCESS_TOKEN = "c15aad46e5b675eb66afbe909a18f6a415fcbb29";
    private final String EXPECTED_JSON = "{\"status\":true,\"result\":{\"total\":3,\"filtered\":3,\"count\":3,\"entities\":[{\"title\":\"Demo Project\",\"code\":\"DEMO\",\"counts\":{\"cases\":10,\"suites\":3,\"milestones\":2,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}},{\"title\":\"Sharelane\",\"code\":\"SHARELANE\",\"counts\":{\"cases\":10,\"suites\":2,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":10,\"open\":10}}},{\"title\":\"Test\",\"code\":\"TEST\",\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}]}}";
    Gson gson = new Gson();
    private final ProjectAdaptor projectAdaptor = new ProjectAdaptor();
    public void test1() {
        String actualResponseBody = given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .when()
                .get("https://api.qase.io/v1/project")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        Assert.assertEquals(actualResponseBody, EXPECTED_JSON, "not equal");
    }

    @Test
    public void createProjectTest() {
        Project project = Project.builder()
                .title("Test tytle")
                .code("P11")
                .description("description")
                .build();

        ProjectResponse expectedResponse = ProjectResponse.builder()
                .result(Result.builder().code("P11").build())
                .build();

        String actualResponseBody = given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(gson.toJson(project))
                .when()
                .post("https://api.qase.io/v1/project")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        Assert.assertEquals(gson.fromJson(actualResponseBody, ProjectResponse.class),
                expectedResponse, "Message");
    }

    public void getAllProjcts() {

        String responseCode = projectAdaptor.getAllProjects(200);
    }

}
