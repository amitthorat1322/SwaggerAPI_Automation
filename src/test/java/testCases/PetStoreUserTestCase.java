package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import endpoints.PetStoreUserEndPoints;
import io.restassured.response.Response;

public class PetStoreUserTestCase {
	
	@Test
	public void testCreateUser() throws JsonProcessingException
	{
		Response res = PetStoreUserEndPoints.userCreateUser();
						res.then().assertThat().log().all();
						Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test
	public void testGetUser()
	{
		Response res = PetStoreUserEndPoints.userLogin();
						res.then().assertThat().log().all();
						Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test
	public void testGetUserName()
	{
		Response res = PetStoreUserEndPoints.getUser();
						res.then().assertThat().log().all();
						Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test
	public void testupdateUser()
	{
		Response res = PetStoreUserEndPoints.updateUser();
						res.then().assertThat().log().all();
						Assert.assertEquals(res.getStatusCode(), 200);
						
		Response ress = PetStoreUserEndPoints.getUser();
						ress.then().assertThat().log().all();
						Assert.assertEquals(ress.getStatusCode(), 200);
	}

	@Test
	public void testCreateWithArray() throws JsonProcessingException
	{
		Response res = PetStoreUserEndPoints.createWithArray();
		res.then().assertThat().log().body();
		/* Assert.assertEquals(res.getStatusCode(), 200); */
	}
	
	@Test
	public void testCreateWithList() throws JsonProcessingException
	{
		Response res = PetStoreUserEndPoints.createWithList();
		res.then().assertThat().log().body().extract().response();
		/* Assert.assertEquals(res.getStatusCode(), 200); */
	}
	
}
