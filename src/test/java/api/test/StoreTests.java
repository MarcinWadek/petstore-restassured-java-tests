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
        storePayload.setStatus(OrderStatus.DELIVERED);
        storePayload.setComplete(true);

        Response response = StoreEndpoints.placeOrder(storePayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testGetOrderByStatus(){
        Response response = StoreEndpoints.readInventories();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testGetOrderByIdNo2(){
        Response response = StoreEndpoints.readById(2);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);
    }
    @Test
    public void testGetOrderByIdNo9(){

        Response response = StoreEndpoints.readById(9);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);
    }
    @Test
    public void testGetOrderByIdNo5(){

        Response response = StoreEndpoints.readById(5);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    // valid ids as per documentation are: 2 and 9
    @Test
    public void testDeleteOrderIdNo2(){

        Response response = StoreEndpoints.readById(2);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);
    }
    @Test
    public void testDeleteOrderByIdNo9(){

        Response response = StoreEndpoints.readById(9);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),404);
    }
    @Test
    public void testDeleteOrderByIdNo7(){

        Response response = StoreEndpoints.readById(7);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}