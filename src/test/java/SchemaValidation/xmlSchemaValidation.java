package SchemaValidation;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class xmlSchemaValidation {


    @Test
    void testXMLSchemaValidation(){

        given()
                .when()
                .get("https://apitogetsmlresposnse/")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"))
                ;
    }
}
