package API_Tests;

import com.google.gson.annotations.JsonAdapter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTests_1 {

    String BaseURL = "https://jsonmock.hackerrank.com";

    @Test
    public void viewSpartanTest1(){

        Response response = RestAssured.get(BaseURL + "/api/transactions");

        System.out.println("response.statusCode() = " + response.statusCode());

        //print body
        //asString string formatinda getiriyor butun body
        System.out.println(response.body().asString());

        //print with prettyprint
        //prettyPrint JSON formatinda getiriyor

        System.out.println(response.body().prettyPrint());


    }

    //When user send GET request to /api/transactions end point
    //Then status code must be 200
    //And body should contains Helena

    @Test
    public void viewSpartanTest2(){

        Response response = RestAssured.get(BaseURL + "/api/transactions");

        Assert.assertEquals(response.statusCode(),200);

        //Verify body contains Allen
        Assert.assertTrue(response.body().asString().contains("Helena"));

    }

//    Given accept type is Json
//    When user sends a get request to URL
//            Then response status code 200
//    And response body should be json format

    @Test
    public void viewSpartanTest3(){

        //RestAssured.given().accept(ContentType.JSON) -> it means otomatik method it is ready,
        //it accepts JSON type automatically
        //given implement your header, path parameters, query parameters
        //this given is from request body not response body, kinda you put query param
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(BaseURL + "/api/transactions");

        Assert.assertEquals(response.statusCode(),200);

        //verify response body json
        //response.contentType() is coming from response body not request body
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");


    }


}
