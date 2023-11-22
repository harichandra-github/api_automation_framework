package project.endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import project.payload.User;


public class UserEndpoints {
	
	
	public static  String  base_URL="https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_URL=base_URL+"/user";
	public static String get_URL=base_URL+"/user/{username}";
	public static String update_URL=base_URL+"/user/{username}";
	public static String delete_URL=base_URL+"/user/{username}";
	public static String login_URL=base_URL+"/user/login";
	
	public static Response createUser(User payload)
	{
		Response response=given()
		       .contentType(ContentType.JSON)
		       .accept(ContentType.JSON)
		       .body(payload)
		
		
		.when()
		      .post(post_URL);
		return response;
		
	}
	public static Response readUser(String userName)
	{
		Response response=given()
				               .pathParam("username", userName)
				               
				               .when()
				                     .get(get_URL);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		Response response=given()
			                   .contentType(ContentType.JSON)
			                   .accept(ContentType.JSON)
			                   .pathParam("username", userName)
			                   .body(payload)
			               .when()
			                     .put(update_URL);
			  
        return response;
			
	}
	
	public static Response deleteUser(String userName)
	{
		Response response=given()
	               .pathParam("username", userName)
	               
	               .when()
	                     .delete(delete_URL);
       return response;
	}
	
	
	public static Response loginUser(String userName,String pass)
	{
		Response response=given().contentType(ContentType.JSON).
				queryParams("username",userName).
				
				queryParams("password", pass)
	               
	               
	               .when()
	                     .delete(login_URL);
       return response;
	}
	

}
