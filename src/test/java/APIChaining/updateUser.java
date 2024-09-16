package APIChaining;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class updateUser {


    @Test
    void testUpdateUser(ITestContext context){

        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("email", faker.internet().emailAddress());

        String BearerToken = "";

        int id = (int) context.getAttribute("user_id");

        given()
                .headers("Authorization", "Bearer "+BearerToken)
                .contentType("application/json")
                .body(data.toString())
                .pathParam("id", id)
                .when()
                        .put("https://reqres.in/api/users/{id}")
                .then()
                .statusCode(200)
                ;

    }
}
