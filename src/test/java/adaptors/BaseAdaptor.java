package adaptors;

import com.google.gson.Gson;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdaptor {

    protected final static String BASE_URL = System.getenv().getOrDefault(
            "BASE_URL", PropertyReader.getProperty("qase.api.all.base_url"));
    private final static String ACCESS_TOKEN = System.getenv().getOrDefault("ACCESS_TOKEN",
            PropertyReader.getProperty("qase.api.all.access_token"));
    protected final static Gson gson = new Gson();

    public String get(String endpoint, int statusCode) {
        return given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .log().all()
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().body().asString();
    }

    public String post(String endpoint, int statusCode, String requestBody) {
        return given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().body().asString();
    }

    public String delete(String endpoint, int statusCode) {
        return given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
                .when()
                .delete(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().body().asString();
    }

    public String patch(String endpoint, String requestBody, int statusCode) {
        return given().header("Token", ACCESS_TOKEN)
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .patch(BASE_URL + endpoint)
            .then()
            .log().all()
            .statusCode(statusCode)
            .extract().body().asString();
    }
}
