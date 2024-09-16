package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUser {


    @Test
    void testGetUser(ITestContext context){

        int id = (int) context.getAttribute("user_id");

        String bearerToken = "";

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .pathParam("id", id)
                .when()
                .get("https://reqres.in/api/users/{id}")
                .then()
                .statusCode(200)
                .log().all();


    }


}
