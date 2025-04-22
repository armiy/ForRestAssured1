package APIEndPoints;

import APIPayload.BooksPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EndpointsBooks {
//CRUD Methods
    //create Method for only users b/c you need to use specific post url with the specific endpoint

    public static Response createBooks(BooksPojo payload){
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when().post(Routes_Project2.postBooksUrl);
        return response;
    }

    public static Response getBooks(int id){
        Response response =
                given()
                        .pathParam("id",id)
                        .accept(ContentType.JSON)
                        .when().get(Routes_Project2.getBooksUrl);
        return response;
    }

    public static Response updateBooks(int id, BooksPojo payload){
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("id",id)
                        .body(payload)
                        .when().put(Routes_Project2.putBookssUrl);
        return response;
    }

    public static Response deleteBooks(int id){
        Response response =
                given()
                        .pathParam("id",id)
                        .when().delete(Routes_Project2.deleteBooksUrl);
        return response;
    }


}
