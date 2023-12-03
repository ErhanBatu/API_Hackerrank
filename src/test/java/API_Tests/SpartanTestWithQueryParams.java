package API_Tests;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SpartanTestWithQueryParams {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="https://jsonmock.hackerrank.com";
    }

    //given accept type is Json
    //And query parameter values are:
    //txnType:debit
    //userName:Helena Fernandez
    //When user sends GET request to /api/transactions
    //Then response status code should be 200
    //And response content-tyepe: application/json; charset=utf-8
    //And debit should be in response body
    //And "Helena" should be in response payload

    @Test
    public void QueryParam1(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("txnType", "debit")
                .and().queryParam("userName", "Helena Fernandez")
                .when().get("/api/transactions");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

        assertTrue(response.body().asString().contains("debit"));

        //Verify huren does not exist in the body
        assertFalse(response.body().asString().contains("huren"));
        assertTrue(response.body().asString().contains("Helena Fernandez"));

        response.prettyPrint();

    }

    @Test
    public void queryParams2(){

        //creating map for query Params
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("txnType","debit");
        paramsMap.put("userName","Helena Fernandez");

        //send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/transactions");

        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("debit"));
        response.prettyPrint();


    }





}
