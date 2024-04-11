package api.verification;

import api.endpoints.ApiResponse;
import org.testng.Assert;


public class ResponseVerification extends AbstractVerification{

    public ResponseVerification(ApiResponse apiResponse) {
        super(apiResponse);
    }

    public void verifyResponseStatusCode(int expectedStatusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), expectedStatusCode, "Invalid response status code");
    }
}
