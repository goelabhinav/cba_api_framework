import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GETApiTests {
    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        RestAssured.baseURI =  "https://petstore.swagger.io/v2";
    }

    @Test
    public void getPet200() {

        RequestSpecification request = RestAssured.given();

        Response response = request.get("/pet/3");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals( response.jsonPath().getString("name"), "doggie");
    }
    @Test
    public void getPet400() {
        RequestSpecification request = RestAssured.given();

        Response response = request.get("/pet/3");

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void getPet404() {
        RequestSpecification request = RestAssured.given();

        Response response = request.get("/pet/2990909");

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals("Pet not found", response.jsonPath().getString("message"));
    }

    @Test
    public void findByStatus200() {
        RequestSpecification request = RestAssured.given();

        Response response = request.queryParam("status", "available","pending","sold").get("/pet/findByStatus");

        Assert.assertEquals(response.getStatusCode(), 200);
    }


}