package API_Tests;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SpartanTestWithHancrest_6 {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://jsonmock.hackerrank.com";
    }

    /*
    given accept type is Json
    and path param id is 15
    when user sends a get request to /api/transactions/{id}
    then status code is 200
    and content type is Json
    And json data has following
     */

    @Test
    public void test1(){

        //request part
        given().accept(ContentType.JSON)
                .pathParam("id",3)
                .when().get("/api/transactions/{id}")
                //normally you stop your code here but we contunie
                //this is my response part
                .then().statusCode(200)
                .assertThat().contentType("application/json; charset=utf-8");

    }

    @Test
    public void test2(){

        given().accept(ContentType.JSON)
                .pathParam("id",3)
                .when().get("/api/transactions/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json; charset=utf-8")
                .and().assertThat().body("data.id", equalTo(3),"data.userName",equalTo("Helena Fernandez"),
                "data.txnType", equalTo("debit"));


        /*
        READING JSON BODY
        -String contains ("value") --> boolean verification
        -Path()
        -JsonPath
        -Hamcrest Matchers(chaining)
        -JSON response --> JAVA
         */



    }
}
