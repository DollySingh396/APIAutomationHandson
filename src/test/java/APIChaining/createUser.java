package APIChaining;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class createUser {


    @Test
    void testCreateUser(ITestContext context){


        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("email", faker.internet().emailAddress());

        String bearerToken = "";

        int id = given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

        System.out.println("Generated Id is: "+id);
        context.setAttribute("user_id", id);


    }
}
