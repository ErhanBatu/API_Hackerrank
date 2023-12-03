package API_Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SpartanTestWithJsonPath {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://jsonmock.hackerrank.com";
    }


    //Given accept type is Json
    //And path param spartan id is 3
    //When user sends a get request to /api/transactions/{id}
    //Then status code is 200
    //And content type is Json

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 3)
                .when().get("/api/transactions/{id}");

        System.out.println(response.prettyPrint());

        Assert.assertEquals(response.statusCode(),200);

        //how to read value with path() method
        int id=response.path("data.id");
        System.out.println("id =" + id);

        //how to read value with JsonPath
        //you can save your data inside json path and play with it
        JsonPath jsonData = response.jsonPath();
        int id1 = jsonData.getInt("data.id");
        String userName = jsonData.getString("data.userName");
        String type = jsonData.getString("data.txnType");

        Assert.assertEquals(id1,3);
        Assert.assertEquals(userName,"Helena Fernandez");
        Assert.assertEquals(type,"debit");

        System.out.println("type = " + type);
        System.out.println("userName = " + userName);
        System.out.println("id1 = " + id1);



    }
}
