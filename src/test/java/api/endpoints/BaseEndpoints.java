package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class BaseEndpoints {
    public static final String BASE_URI = "https://petstore.swagger.io/v2";
    protected Map<String, Object> headers;

    public BaseEndpoints() {
        this.headers = setHeaders();
    }

    private Map<String, Object> setHeaders() {
        return new HashMap<>() {{
            put("Content-Type", "application/json");
            put("Accept", "application/json");
        }};
    }

    protected ApiResponse sendGet(RequestSpecification requestSpec) {
        return sendRequest(requestSpec, Method.GET);
    }

    protected ApiResponse sendPost(RequestSpecification requestSpec) {
        return sendRequest(requestSpec, Method.POST);
    }

    private ApiResponse sendRequest(RequestSpecification requestSpec, Method method) {
        Response response = requestSpec.request(method);
        response.then().log().all();
        return new ApiResponse(response);
    }

    protected RequestSpecification getRequestBase() {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .headers(headers);
    }
}
