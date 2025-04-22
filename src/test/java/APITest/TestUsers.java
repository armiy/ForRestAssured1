package APITest;

import APIPayload.UserPojo;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;

public class TestUsers {
    UserPojo payload;
    Faker faker;
    @BeforeClass
    public void generatePayload(){
        payload = new UserPojo();
        faker = new Faker();
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());
        payload.setEmail(faker.internet().safeEmailAddress());
        payload.setPhone(faker.phoneNumber().cellPhone());
    }
}
