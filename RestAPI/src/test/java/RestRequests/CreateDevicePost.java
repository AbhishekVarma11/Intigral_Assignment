package RestRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateDevicePost {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
    

    @Test
    public void createNewDeviceUsingCombinedClass() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects";

        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Create New Device Test using Combined Class");

        
        Device deviceData = new Device(2023, 7999.99, "Apple ARM A7", "1 TB");
        Data device = new Data( "Apple Max Pro 1TB", deviceData);
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(device)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

       System.out.println(response.body().asPrettyString());
        String id = response.jsonPath().getString("id");
        String name = response.jsonPath().getString("name");
        String createdAt = response.jsonPath().getString("createdAt");
        int year = response.jsonPath().getInt("data.year");
        double price = response.jsonPath().getDouble("data.price");

     
        try {
            Assert.assertNotNull(id, "ID should not be null");
            Assert.assertNotNull(createdAt, "createdAt should not be null");
            Assert.assertEquals(name, "Apple Max Pro 1TB", "Device name does not match");
            Assert.assertEquals(year, 2023, "Year does not match");
           Assert.assertEquals(price, 7999.99, "Price does not match");

         
            test.pass("All validations passed successfully");
        } catch (AssertionError e) {
            
            test.fail("Test failed due to: " + e.getMessage());
            throw e;  
        }

        extent.flush();
    }
}
