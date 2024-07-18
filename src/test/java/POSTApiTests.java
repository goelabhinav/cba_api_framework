import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class POSTApiTests {

    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        RestAssured.baseURI =  "https://petstore.swagger.io/v2";
    }

    @Test
    public void updatePet200() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/POSTPetId.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.post("/pet/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void updatePet405() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/POSTUpdatePet405.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.post("/pet/1");
        Assert.assertEquals(response.getStatusCode(), 405);
    }

    @Test
    public void addPet200() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/POSTAddPet200.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.post("/pet");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void addPet405() {
        RequestSpecification request = RestAssured.given();
        File jsonPayload = new File("src/main/java/payloads/POSTAddPet405.json");
        request.header("Content-Type", "application/json");
        request.body(jsonPayload);

        Response response = request.post("/pet");

        Assert.assertEquals(response.getStatusCode(), 405);
    }

    @Test
    public void uploadImage200() {
        RequestSpecification request = RestAssured.given();
        File sampImg = new File("src/main/resources/img-50.jpg");
        request.header("Content-Type", "multipart/form-data");
        request.multiPart("file", sampImg );

        Response response = request.post("/pet/1/uploadImage");

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
