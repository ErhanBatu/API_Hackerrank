package API_Tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithPathMethod {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://jsonmock.hackerrank.com";
    }

    //Given accept type is Json
    //And path param id is 3
    //When user sends a get request to /api/transactions/{id}
    //Then status code is 200
    //And content-type is application/json; charset=utf-8
    //And response payload values match the following:
//    "userName": "Helena Fernandez",
//            "timestamp": 1549530365037,
//            "txnType": "debit",

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 3)
                .when().get("/api/transactions/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8");

        response.prettyPrint();

        //printing values of json keys
        //response.body.path is equal to response.path
//        System.out.println("ip" + response.body().path("ip").toString());
        System.out.println("data" + response.path("data").toString());

    }

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("userName", "Helena Fernandez")
                .when().get("/api/transactions");

        System.out.println(response.path("page").toString());


    }


}
