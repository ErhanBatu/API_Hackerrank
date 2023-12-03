package API_Tests;
import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SpartanPostRequest_9 {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://jsonmock.hackerrank.com";
    }

    @Test
    public void PostWithString(){

        //sending json body as string //it is not recommended
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("        {\n" +
                        "            \"id\": 122,\n" +
                        "            \"userId\": 2,\n" +
                        "            \"userName\": \"Bob Martin\",\n" +
                        "            \"timestamp\": 1549260902604,\n" +
                        "            \"txnType\": \"debit\",\n" +
                        "            \"amount\": \"$3,574.95\",\n" +
                        "            \"location\": {\n" +
                        "                \"id\": 8,\n" +
                        "                \"address\": \"389, Everest, Barwell Terrace\",\n" +
                        "                \"city\": \"Murillo\",\n" +
                        "                \"zipCode\": 66061\n" +
                        "            },\n" +
                        "            \"ip\": \"212.215.115.165\"\n" +
                        "        }")
                .when().post("/api/transactions");

        response.prettyPrint();

    }

    @Test
    public void PostWithMap(){

        Map<String,Object> MapJson = new HashMap<>();
        MapJson.put("id",44);
        MapJson.put("userName", "Erhan");
        MapJson.put("timestamp", 123445);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(MapJson)
                .when().post("/api/transactions");

        response.prettyPrint();


    }

    @Test
    public void PostWithPOJO(){
        //create Spartan object and used as abody for post request
        //serilization Java - JSON
        Spartan_7_POJO_Blueprint spartan = new Spartan_7_POJO_Blueprint();
        spartan.setPage(11);
        spartan.setPer_page(123);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(spartan)
                .when().post("/api/transactions");

        //===============GET REQUEST================
        //Deserilization Json - Java

        Response response2 = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/transaction");

        Spartan_7_POJO_Blueprint sp = response2.body().as(Spartan_7_POJO_Blueprint.class);


    }
}
