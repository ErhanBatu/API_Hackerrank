package API_Tests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SpartanTestsPOJODeserization_8 {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://jsonmock.hackerrank.com";
    }
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/transactions");

        //how to convert json response to our spartan class
        Spartan_7_POJO_Blueprint spartan = response.body().as(Spartan_7_POJO_Blueprint.class);
        System.out.println(spartan.toString());


    }

    @Test
    public void gsonExample(){

        Gson gson = new Gson();

        String myJsonBody = "{page: 15,\n+per_page:30}";

        //using gson method to do deserialize our json body
        //deserilization JSON - Java
        Spartan_7_POJO_Blueprint spartan = gson.fromJson(myJsonBody,Spartan_7_POJO_Blueprint.class);
        System.out.println(spartan.toString());

        //serilization Java-->Json
        Spartan_7_POJO_Blueprint spartan1 = new Spartan_7_POJO_Blueprint(22,44);

        //converting to json
        String jsonBody = gson.toJson(spartan1);
        System.out.println(jsonBody);

    }

    @Test
    public void gsonExamplebymyself(){

        Gson gson = new Gson();

        String myBody = "{page: 15,\n+per_page:30}";

        Spartan_7_POJO_Blueprint spartn = gson.fromJson(myBody,Spartan_7_POJO_Blueprint.class);
        System.out.println(spartn.toString());


        //---------------------------------

        Spartan_7_POJO_Blueprint sp = new Spartan_7_POJO_Blueprint(22,44);

        String myJsonBody = gson.toJson(sp);
        System.out.println(myJsonBody);





    }




}
