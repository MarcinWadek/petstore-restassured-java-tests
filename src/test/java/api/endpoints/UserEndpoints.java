package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    static ResourceBundle getURL(){
        ResourceBundle routes =  ResourceBundle.getBundle("routes");
        return routes;
    }

    public static Response createUser(User payload){

        String post_url= getURL().getString("user_post_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(post_url);
        return response;
    }
    public static Response readUser(String username){

        String get_url= getURL().getString("user_get_url");

        Response response = given()
                .pathParam("username", username)
                .when()
                .get(get_url);
        return response;
    }
    public static Response updateUser(String username, User payload){

        String update_url= getURL().getString("user_update_url");

        Response response = given()
                .pathParam("username", username)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .put(update_url);
        return response;
    }
    public static Response deleteUser(String username){

        String delete_url= getURL().getString("user_delete_url");

        Response response = given()
                .pathParam("username", username)
                .when()
                .delete(delete_url);
        return response;
    }
    public static Response login(String username, String password) {

        String login_url= getURL().getString("user_login_url");

        Response response = given()
                .params(Map.of("username", username, "password", password))
                .when()
                .get(login_url);
        return response;
    }

    public static Response logout() {

        String logout_url= getURL().getString("user_logout_url");

        Response response = given()
                .when()
                .get(logout_url);
        return response;
    }
    public static Response createUserWithList(User... userList){

        String user_postWithList_url= getURL().getString("user_postWithList_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Arrays.asList(userList))

                .when()
                .post(user_postWithList_url);
        return response;
    }
    public static Response createUserWithArray(User[] userArray){

        String user_postWithArray_url= getURL().getString("user_postWithArray_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userArray)

                .when()
                .post(user_postWithArray_url);
        return response;
    }

}