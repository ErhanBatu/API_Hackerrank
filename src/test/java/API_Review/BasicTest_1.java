package API_Review;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest_1 {

    String BaseURL = "http://54.174.126.24:8000";

    @Test
    public void test1(){

        Response response = RestAssured.get(BaseURL + "/api/spartans");

        System.out.println(response.statusCode());

//        response.prettyPrint();
        System.out.println(response.header("Content-Type"));

        System.out.println(response.body().asString());

    }

    @Test
    public void test2(){

        Response response = RestAssured.get(BaseURL + "/api/spartans");

        Assert.assertTrue(response.body().asString().contains("8877445596"));
        Assert.assertEquals(response.statusCode(),200);


    }

    @Test
    public void test3(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(BaseURL + "/api/spartans");
        Assert.assertEquals(response.contentType(), "application/json");
    }

}
