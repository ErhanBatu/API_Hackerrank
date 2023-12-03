package API_Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestsWithPathParameters_2 {

    //I describe my URL globally
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="https://jsonmock.hackerrank.com";
    }

    //Given accept type is Json
    //And Id parameter value is 18
    //When user sends GET request to /api/transactions{id}
    //Then response status code should be 200
    //And response content-type: application/json; charset=utf-8
    //And "Helena" should be in response payload

    @Test
    public void PathTest1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 3)
                .when().get("/api/transactions/{id}");
        ///api/transactions/{id} ->you put this with {} and json understand it is path param

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        assertTrue(response.body().asString().contains("Helena"));

    }

    //Given accept type is Json
    //And Id parameter value is 500
    //When user sends GET request to /api/transactions/{id}
    //Then response status code should be 404
    //And response content-Type: application/json; charset=utf-8
    //And "Spartan Not Found" message should be in response payload

    @Test
    public void negativePathParamTest(){

        //First you put your param and querries and after that you put your endpoint
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/transactions/{id}");

        assertEquals(response.statusCode(),404);
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        assertEquals(response.body().asString(),"{}");
        response.prettyPrint();


    }
}
