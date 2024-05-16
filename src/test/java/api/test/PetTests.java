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

import static org.testng.AssertJUnit.assertEquals;

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
        category.setId(3);

    }

    @Test(priority = 1)
    public void testPostPet(){
        Response response =  PetEndpoints.createPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        response =  PetEndpoints.getPetById(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 1)
    public void testUpdatePet(){

        petPayload.setId(faker.number().numberBetween(1,3));
        petPayload.setName("burek");
        petPayload.setStatus(PetStatus.SOLD);
        category.setName("asd");
        category.setId(3);

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
    public void testDeletePetByID(){
        petPayload.setId(faker.number().numberBetween(1,8));

        Response response =  PetEndpoints.deletePet(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
