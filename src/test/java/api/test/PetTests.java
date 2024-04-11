package api.test;

import api.endpoints.PetEndpoints;
import api.endpoints.UserEndpoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.PetStatus;
import api.payload.Store;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests {

    Faker faker;
    Pet petPayload;
    Category category;
    PetStatus petStatus;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        petPayload = new Pet();
        category = new Category();

        petPayload.setId(faker.number().numberBetween(1,3));
        petPayload.setName("burek");
        petPayload.setStatus(PetStatus.SOLD);
        category.setName("asd");
        category.setId(2);

    }

    @Test(priority = 1)
    public void testPostPet(){
        Response response =  PetEndpoints.createPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 1)
    public void testUpdatePet(){
        petPayload.setStatus(PetStatus.AVAILABLE);
        Response response =  PetEndpoints.updatePet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 1)
    public void testGetPetByStatus(){
        Response response =  PetEndpoints.getPetByStatus(PetStatus.AVAILABLE);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 1)
    public void testGetPetByID(){
      petPayload.setId(faker.number().numberBetween(1,8));

        Response response =  PetEndpoints.getPetById(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 1)
    public void testPostPetByID(){
        petPayload.setId(faker.number().numberBetween(1,8));

        Response response =  PetEndpoints.postById(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 1)
    public void testPostWithImage(){
        petPayload.setId(faker.number().numberBetween(1,8));

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://avatars0.githubusercontent.com/u/19369327?s=400&v=4");

        Response response =  PetEndpoints.postImage(1,photoUrls);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void testDeletePetByID(){
        petPayload.setId(faker.number().numberBetween(1,8));

        Response response =  PetEndpoints.deletePet(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
