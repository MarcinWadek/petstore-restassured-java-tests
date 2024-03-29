package api.endpoints;

import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    public static Response placeOrder(Store payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.store_post_url);
        return response;
    }

    public static Response readInventories(String status){
        Response response = given()
                .when()
                .get(Routes.storeInventory_get_url);
        return response;
    }

    public static Response readById(int id){
        Response response = given()
                .pathParam("id", id)
                .when()
                .get(Routes.storeID_get_url);
        return response;
    }

    public static Response deleteById(int id){
        Response response = given()
                .pathParam("id", id)
                .when()
                .get(Routes.store_delete_url);
        return response;
    }
}
