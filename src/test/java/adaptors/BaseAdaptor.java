package adaptors;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdaptor {

    protected final static String BASE_URL = "https://api.qase.io/v1/";
    private final static String ACCESS_TOKEN = "c15aad46e5b675eb66afbe909a18f6a415fcbb29";


    public String get(String endpoint, int statusCode) {
        return given().header("Token", ACCESS_TOKEN)
                .header("Accept", "application/json")
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
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
    }
}
