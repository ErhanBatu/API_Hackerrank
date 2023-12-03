package API_Review;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWithQueryParam {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="https://jsonmock.hackerrank.com";
    }

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("amount", "$3,102.22")
                .when().get("/api/transactions");

        response.prettyPrint();
    }

}
