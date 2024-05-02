package testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.AccountEndPoints;
import io.restassured.response.Response;
import payload.CreateUserResult;

public class AccountTestCases {
	public static String userId ="8bb7f13f-434c-44ca-94d7-68f6feea18d4";  // after new creating new user 
	public static String username ;
	public static String pass ;
	CreateUserResult cur ;

	/* 1f8ba76c-9111-4102-903b-e6187e00aec9 */
	@Test(priority = 0)
	public void validateAuthorizeUser()
	{
		Response res = AccountEndPoints.AuthorizeUser();
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test(priority = 1)
	public void validateGenerateToken() throws JsonProcessingException
	{
		Response res = AccountEndPoints.GenerateToken();	
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	
	@Test(priority = 0,enabled=false)
	public void validateCreatedUser() throws IOException
	{
		Response res = AccountEndPoints.createUser();
		res.then().assertThat().log().body();
		userId = res.path("userID"); 
		Assert.assertEquals(res.getStatusCode(), 406);
		
	}

	@Test(priority = 2) 
	public void validateCreatedUserID() throws JsonProcessingException 
	{
		Response response = AccountEndPoints.createUserID(userId);
		response.then().assertThat().log().body(); 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	  
	@Test(priority = 3,enabled = false) 
	public void validateDeleteUserId() 
	{ 
		Response response = AccountEndPoints.deleteUserID(userId);
		response.then().assertThat().log().body(); 
		Assert.assertEquals(response.getStatusCode(),401);
	}	  
	 
}
