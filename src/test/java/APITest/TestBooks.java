package APITest;

import APIEndPoints.EndpointsBooks;
import APIPayload.BooksPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBooks {
    BooksPojo payload;
    Faker faker;
    int idg;

    @BeforeClass
    public void setPojoPayload(){
        payload = new BooksPojo();
        faker = new Faker();

        payload.setTitle(faker.name().title());
        payload.setAutor(faker.name().lastName());
    }
    @Test(priority = 1)

    public void testCreateBooks(){
        Response response = EndpointsBooks.createBooks(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
        int idc = response.jsonPath().getInt("id");
        idg = idc;
    }
    @Test(priority=2)
    public void testGetBooks(){
        Response response = EndpointsBooks.getBooks(idg);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testUpdateBooks(){

        payload.setAutor(faker.name().lastName());

        Response response = EndpointsBooks.updateBooks(idg,payload);
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test(priority = 4)
    public void testDeleteBooks(){
        Response response = EndpointsBooks.deleteBooks(idg);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
