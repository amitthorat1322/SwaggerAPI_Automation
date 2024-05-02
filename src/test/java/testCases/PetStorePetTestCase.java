package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.PetStorePetEndPoints;
import endpoints.PetStoreUserEndPoints;
import io.restassured.response.Response;

public class PetStorePetTestCase {
	
	
	
	@Test(priority = 0)
	public void TestNewPet()
	{
			Response res = PetStorePetEndPoints.CreatePet();
			
			res.then().assertThat().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority = 1)
	public void TestUpdatePet()
	{
		Response res = PetStorePetEndPoints.UpdatePet();
		
		res.then().assertThat().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2)
	public void TestGetStatus()
	{
		
		Response res =PetStorePetEndPoints.findByStatus();
		res.then().assertThat().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
		@Test(priority = 3)
	public void testFindByPetID()
	{
		
		Response res =PetStorePetEndPoints.findByPetID();
		res.then().assertThat().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
		
	@Test(priority = 4)
	public void testupdatePetUsingPetId()
	{
		Response res =PetStorePetEndPoints.updatePetUsingPetId();
		res.then().assertThat().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
