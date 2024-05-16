package api.endpoints;

import api.payload.OrderStatus;
import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    static ResourceBundle getURL(){
        ResourceBundle routes =  ResourceBundle.getBundle("routes");
        return routes;
    }
    public static Response placeOrder(Store payload){

        String post_url= getURL().getString("store_post_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(post_url);
        return response;
    }

    public static Response readInventories(){

        String get_url= getURL().getString("store_get_url");

        Response response = given()
                .when()
                .get(get_url);
        return response;
    }

    public static Response readById(int id){

        String getID_url= getURL().getString("storeID_get_url");

        Response response = given()
                .pathParam("id", id)
                .when()
                .get(getID_url);
        return response;
    }

    public static Response deleteById(int id){

        String delete_url= getURL().getString("store_delete_url");

        Response response = given()
                .pathParam("id", id)
                .when()
                .delete(delete_url);
        return response;
    }
}
