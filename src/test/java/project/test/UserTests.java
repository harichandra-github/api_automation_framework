package project.test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import project.endpoints.UserEndpoints;
import project.payload.User;

public class UserTests {
	
	Faker faker;
	User userPayLoad;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userPayLoad=new User();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		userPayLoad.setPassword(faker.internet().password(7, 11, true, true));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		//Logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	@Test(priority = 1)
	public void testPostUserAPI()
	{
		logger.info("*****************  Creating the user   *************************");
		Response response=UserEndpoints.createUser(userPayLoad);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		logger.info("*****************  The User is Created   *************************");
	}
	
	
	
	@Test(priority = 2)
	public void testGetUserNameAPI()
	{
		logger.info("*****************  Reading the user info   *************************");
		Response response=UserEndpoints.readUser(this.userPayLoad.getUsername());
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		logger.info("*****************  The User info Displayed successfully   *************************");
		
	}
		
	
	@Test(priority =3)
	public void updateUserByNameAPI()
	{  
		logger.info("*****************  Updating the user   *************************");
		// updating the data 
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		Response response=UserEndpoints.updateUser(this.userPayLoad.getUsername(), userPayLoad);
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);	
		logger.info("*****************  User is updated successfully   *************************");
		
		
		
	}
	@Test(priority = 4)
	public void testDeleteByUserName()
	{
		logger.info("*****************  Deleting the user   *************************");
		Response response=UserEndpoints.deleteUser(this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("*****************  User Deleted successfully   *************************");
	}

//	
//	@Test(priority = 2)
//	public void testLoginUserAPI()
//	{
//		logger.info("*****************  Logging using Username and password   *************************");
//		Response response=UserEndpoints.loginUser("hari","pass");
//		
//		response.then().log().all();
//		assertEquals(response.getStatusCode(), 200);
//		logger.info("*****************  Login successful  *************************");
//		
//	}
	

}
