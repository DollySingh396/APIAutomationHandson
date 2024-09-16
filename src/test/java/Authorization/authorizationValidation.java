package Authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ProxySpecification.auth;
import static org.hamcrest.Matchers.equalTo;

public class authorizationValidation {


    @Test
    void testBasicAuthorization() {


        // Basic authorization
        given()
                // in prerequisites pass username and password
                .auth().basic("username", "password")
                .when()
                .get()
                .then()
                .statusCode(200)
                // in response body we have one key name authenticated so we are validating key value is true or not
                .body("authenticated", equalTo(true))
                .log().all()
        ;

    }

    @Test
    void testDigestAuthorization() {

        //Digest authorization
        given()
                .auth().digest("username", "password")
                .when()
                .get()
                .then()
                .body("", equalTo(""))
                .log().all()
        ;


    }

    @Test
    void testPreemptiveAuthorization() {

        //Preemptive authorization
        given()
                .auth().preemptive().basic("username", "password")
                .when()
                .then()
                ;
    }


    @Test
    void testBearerTokenAuthorization(){

        // first generate bearer token and use in validation part
        // pass the token generated in below statement
        String bearerToken = "";


        //for bearer token we pass in headers and with word Bearer space and then token string
        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().all()
                ;

    }

    @Test
    void testOAuth1(){

        given()
                .auth().oauth("consumerKey", "consumerSecret", "accessToken", "TokenSecrate")
                .when()
                .then()
                ;
    }


    @Test
    void testOAuth2(){

        given()
                .auth().oauth2("accessToken")
                .when()
                .then()
        ;
    }


    @Test
    void testAPIKey(){

        given()
                .queryParam("key", "value")
                .when()
                .then()
        ;
    }



}
