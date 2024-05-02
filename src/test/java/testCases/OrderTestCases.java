package testCases;

import org.testng.annotations.Test;

import endpoints.PetStoreEndPoints;
import endpoints.PetStorePetEndPoints;
import io.restassured.response.Response;

public class OrderTestCases {

	@Test(priority=0)
	public void TestplaceOrder()
	{
		Response res = PetStoreEndPoints.placeOrder();
						res.then().assertThat().log().all();
				
	}
	
	@Test(priority=1)
	public void TestgetOrder()
	{
		Response res = PetStoreEndPoints.getOrderID();
				res.then().assertThat().log().all();
	}
}
