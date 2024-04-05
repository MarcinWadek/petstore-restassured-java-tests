package api.test;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {

    Faker faker;
    User userPayload;
    UserEndpoints2 userEndpoints2;

    @BeforeClass
    public void setupData(){
    faker = new Faker();
    userPayload = new User();

    userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(7,12));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
       Response response =  UserEndpoints2.createUser(userPayload);
       response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        Response response = UserEndpoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 1)
    public void testUpdateUserByFirstName(){

        userPayload.setFirstName(faker.name().firstName());

        Response response =  UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().all();
//        response.then().log().body().statusCode(200); --> tak tez mozna robic asercje
        Assert.assertEquals(response.getStatusCode(), 200);

        Response responseAfterUpdate =  UserEndpoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        Response response = UserEndpoints2.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
