package APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteUser {


    @Test
    void testDeleteUser(ITestContext context){

        String bearerToken = "";
        int id = (int) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearee "+ bearerToken)
                .pathParam("id", id)
                .when()
                .delete("https://reqres.in/api/users/{id}")
                .then()
                .statusCode(204)
                .log().all();


    }
}
