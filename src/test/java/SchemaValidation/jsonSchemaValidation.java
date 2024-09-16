package SchemaValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class jsonSchemaValidation {

    @Test
    void testJsonSchemaValidation(){

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                // add io rest assured json schema validation dependency
                // the method matchesJsonSchemaInClasspath will look for specified file in src/test/resources path
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"))
        ;
    }


}
