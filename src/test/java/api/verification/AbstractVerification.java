package api.verification;

import api.endpoints.ApiResponse;

public class AbstractVerification {

    ApiResponse apiResponse;

    public AbstractVerification(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
}
