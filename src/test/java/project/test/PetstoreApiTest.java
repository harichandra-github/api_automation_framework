package project.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetstoreApiTest {

    @Test
    public void testLoginEndpoint() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String userName = "johndoe";
        String password = "Password123";

        // Login request payload
        String requestBody = "{ \"username\": \"" + userName + "\", \"password\": \"" + password + "\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/user/login")
                .then()
                .statusCode(200) // Expected HTTP status code
                .body("code", equalTo(200)) // Expected response body attribute
                .extract().response();

        // Assert additional response attributes if needed
        // For example:
        // String token = response.path("token");
        // assertThat(token, notNullValue());

        // Print the response body
        System.out.println(response.getBody().asString());
    }
}
