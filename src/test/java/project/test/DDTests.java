package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import project.endpoints.UserEndpoints;
import project.payload.User;
import project.utilities.DataProviders;

public class DDTests {
	
	@Test(priority = 1,dataProvider = "AllData",dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayLoad=new User();
		
		userPayLoad.setId(Integer.parseInt(userId));
		userPayLoad.setUsername(userName);
		userPayLoad.setFirstName(fname);
		userPayLoad.setLastName(lname);
		userPayLoad.setEmail(useremail);
		userPayLoad.setPassword(pwd);
		userPayLoad.setPhone(ph);
		
		Response response=UserEndpoints.createUser(userPayLoad);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2,dataProvider = "getUserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userNames)
	{
		Response response=UserEndpoints.deleteUser(userNames);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
//	@Test(dataProvider = "Data",dataProviderClass = DataProviders.class)
//	public void testmethod(String userId, String userName,String fname,String lname,String useremail,String pwd,String ph)
//	{
//		System.out.println(userId+userName);
//		
//	}

}
