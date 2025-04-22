package APITest;

import APIEndPoints.RestUsers;
import APIPayload.UserPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUsers {
    UserPojo payload;
    Faker faker;
    int idg;


    @BeforeClass
    public void generatePayload(){
        payload = new UserPojo();
        faker = new Faker();
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());
        payload.setEmail(faker.internet().safeEmailAddress());
        payload.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority =1)
    public void testCreateUser(){
        Response response = RestUsers.createUser(payload);
        response.then().log().all();
        int idc = response.jsonPath().getInt("id");
        idg = idc;
        Assert.assertEquals(response.getStatusCode(),201);
    }
    @Test(priority = 2)
    public void testGetUser(){
        Response response = RestUsers.getMethoUser(idg);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test(priority = 3)
    public void updateUser(){
        Response response = RestUsers.updateUser(idg,payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 4)
    public void deleteUser(){
        Response response = RestUsers.deleteUser(idg);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
