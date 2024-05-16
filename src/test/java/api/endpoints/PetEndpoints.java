package api.endpoints;

import api.payload.Pet;
import api.payload.PetStatus;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class PetEndpoints {


    static ResourceBundle getURL(){
        ResourceBundle routes =  ResourceBundle.getBundle("routes");
        return routes;
    }

    public static Response createPet(Pet payload){

        String pet_post_url= getURL().getString("pet_post_url");

    Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)

            .when()
            .post(pet_post_url);
        return response;
}
    public static Response updatePet(Pet payload){

        String pet_update_url= getURL().getString("pet_update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .put(pet_update_url);
        return response;
    }
    public static Response getPetByStatus(PetStatus petStatus) {
        String pet_getByStatus_url= getURL().getString("pet_getByStatus_url");

        Response response = given()
                .when()
                .get(pet_getByStatus_url);
        return response;
    }

    public static Response getPetById(int id){
        String pet_getById_url= getURL().getString("pet_getById_url");

        Response response = given()
                .pathParam("petId", id)
                .when()
                .get(pet_getById_url);
        return response;
    }

    public static Response postById(int id){
        String pet_postById_url= getURL().getString("pet_postById_url");

        Response response = given()
                .pathParam("petId", id)
                .when()
                .post(pet_postById_url);
        return response;
    }

    public static Response postImage(int id, List<String> photoUrls){
        String pet_postImage_url= getURL().getString("pet_postImage_url");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);
        requestBody.put("photoUrls", photoUrls);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("petId", id)
                .when()
                .post(pet_postImage_url);
        return response;
    }

    public static Response deletePet(int id){
        String pet_delete_url= getURL().getString("pet_delete_url");

        Response response = given()
                .pathParam("petId", id)
                .when()
                .delete(pet_delete_url);
        return response;
    }
}