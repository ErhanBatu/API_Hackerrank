package API_Review;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestWithParameters {

    String BaseURL = "http://54.174.126.24:8000";

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 104)
                .when().get(BaseURL + "/api/spartans/{id}");

        response.prettyPrint();

    }


}
