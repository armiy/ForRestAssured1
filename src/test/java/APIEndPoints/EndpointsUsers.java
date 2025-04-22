package APIEndPoints;

import APIPayload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EndpointsUsers {

    public Response createUser(UserPojo payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post(Routes_Project2.postUserssUrl);
        return response;
    }
    public Response getUser(int id){
        Response response =
                given()
                        .pathParam("id",id)
                        .when().get(Routes_Project2.getUsersUrl);
        return response;
    }
    public Response updateUser(int id, UserPojo paylood){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when().put(Routes_Project2.putUserssUrl);
        return response;
    }
    public Response deleteUser(int id){
        Response response = given()
                .pathParam("id",id)
                .when().delete(Routes_Project2.deleteUserssUrl);
        return response;
    }
}
