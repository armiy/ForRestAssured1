package APIEndPoints;

public class Routes_Project2 {
    //basic url for all
    public static String baseUrl = "http://localhost:3000/";

    //url for "posts" page/resource
    public static String postBooksUrl = baseUrl+"books";
    public static String getBooksUrl = baseUrl+"books/{id}";
    public static String putBookssUrl = baseUrl+"books/{id}";
    public static String deleteBooksUrl = baseUrl+"books/{id}";

    //url for "comments" page/resource

    public static String postUserssUrl = baseUrl+"user";
    public static String getUsersUrl = baseUrl+"user/{id}";
    public static String putUserssUrl = baseUrl+"user/{id}";
    public static String deleteUserssUrl = baseUrl+"user/{id}";

}
