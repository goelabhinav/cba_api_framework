import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DELETEApiTests {
    @BeforeTest                                             // annotated method placed in the beginning.
    public void before_test()
    {
        RestAssured.baseURI =  "https://petstore.swagger.io/v2";
    }

    @Test
    public void deletePet200() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("/pet/1");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deletePet400() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("/pet/cba");

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void deletePet404() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("/pet/3");

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
