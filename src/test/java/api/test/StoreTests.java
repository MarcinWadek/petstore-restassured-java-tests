package api.test;

import api.endpoints.StoreEndpoints;
import api.endpoints.UserEndpoints;
import api.payload.OrderStatus;
import api.payload.Store;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreTests {


    Faker faker;
    Store storePayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        storePayload = new Store();
    }

    @Test
    public void postOrder(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedShipDate = now.format(formatter);

        storePayload.setShipDate(formattedShipDate);
        storePayload.setId(faker.number().numberBetween(1,11));
        storePayload.setPetId(faker.number().numberBetween(1,100));
        storePayload.setQuantity(faker.number().numberBetween(1,100));
        storePayload.setStatus(OrderStatus.PLACED);
        storePayload.setComplete(false);

        Response response = StoreEndpoints.placeOrder(storePayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testGetPetByStatus(){
        Response response = StoreEndpoints.readInventories(this.storePayload.getStatus());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void testGetPetById(){

        storePayload.setId(faker.number().numberBetween(6,8));

        Response response = StoreEndpoints.readById(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void testDeletePetById(){

        storePayload.setId(faker.number().numberBetween(6,8));

        Response response = StoreEndpoints.readById(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}