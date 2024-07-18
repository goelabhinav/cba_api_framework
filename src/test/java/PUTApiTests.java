import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class PUTApiTests {

    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        RestAssured.baseURI =  "https://petstore.swagger.io/v2";
    }


    @Test
    public void putPet200() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/PUTPet200.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.put("/pet");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void putPet400() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/PUTPet400.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.put("/pet");

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void putPet404() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/PUTPet404.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.put("/pet");

        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void putPet405() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/PUTPet405.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.put("/pet");

        Assert.assertEquals(response.getStatusCode(), 405);
    }
}
