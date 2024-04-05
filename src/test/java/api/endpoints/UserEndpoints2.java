package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpoints2 {

    static ResourceBundle  getURL(){
        ResourceBundle routes =  ResourceBundle.getBundle("routes");
        return routes;
    }

    public static Response createUser(User payload){

       String post_url= getURL().getString("post_url");

       Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.user_post_url);
       return response;
    }
    public static Response readUser(String username){

        String get_url= getURL().getString("get_url");

        Response response = given()
                 .pathParam("username", username)
                .when()
                .get(Routes.user_get_url);
        return response;
    }
    public static Response updateUser(String username, User payload){

        String update_url= getURL().getString("update_url");

        Response response = given()
                .pathParam("username", username)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .put(Routes.user_update_url);
        return response;
    }
    public static Response deleteUser(String username){

        String delete_url= getURL().getString("delete_url");

        Response response = given()
                .pathParam("username", username)
                .when()
                .delete(Routes.user_delete_url);
        return response;
    }
}
