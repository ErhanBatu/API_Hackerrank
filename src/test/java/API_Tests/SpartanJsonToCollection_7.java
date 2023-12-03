package API_Tests;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class SpartanJsonToCollection_7 {

    @BeforeClass
    public void setUpClass() {
        baseURI = "https://jsonmock.hackerrank.com";
    }

    /*
    Given accept type is Json
    and path param id 3
    when user sends a get request /api/transactions/{id}
    Then status code is 200
    And content type is Json
    And id = 3
    userName = Helena Fernandez
    txnType = debit
     */

    @Test
    public void test1() {
        //you have to create a response object to convert to Java
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 3)
                .when().get("/api/transactions/{id}");

        //convert Json response to Java Collection(Map) -desriliazation

        Map<String, Object> spartanMap = response.body().as(Map.class);
        System.out.println(spartanMap.get("data"));

    }

    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/transactions");

        //convert full json body to list of Map
        Map<String, Object> listOfSpartans = response.body().as(Map.class);
        System.out.println(listOfSpartans);
        System.out.println(listOfSpartans.get("data"));

        //Data nin icersinde birden fazla map formatinda class oldugu icin list of map yaptim
        //yukaridakinde sadece bir map var o nedenle list of map yapmadim
        List<Map<String, Object>> sp1 = (List<Map<String, Object>>) listOfSpartans.get("data");
        System.out.println(sp1.get(2));
        System.out.println(sp1.get(2).get("userName"));

    }

    @Test
    public void testPath(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/transactions");

        Map<String,Object> sp = response.path("data[0].location");
        System.out.println(sp);
        
        List<String> username = response.path("data.userName");

        boolean flag=false;
        for (String users : username) {
            if(users.contains("Helena")){
                flag=true;
            }
        }

        System.out.println(flag);

    }
}