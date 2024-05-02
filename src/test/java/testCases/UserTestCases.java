package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import utilities.MyRetryAnalyzer;
public class UserTestCases {
		
	public static String isbn_id;
	

	@Test(priority = 0,enabled=false)
	public void TestUserBooks()
	{	
		Response res = UserEndPoints.GetBooks();	
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 1)
	public static void TestPostBooks() throws JsonProcessingException
	{
		Response res = UserEndPoints.PostBooks();
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(), 201);
		
	}
	
	@Test(priority = 2,enabled=false)
	public static void TestDeleteBooks() throws JsonProcessingException
	{
		Response res = UserEndPoints.DeleteBooks();
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(), 204);
		
	}
	
	@Test(priority = 3,invocationCount =2)
	public static void TestGetUserBook()
	{
		Response res = UserEndPoints.GetBook();	
		res.then().assertThat().log().body();
		isbn_id = res.jsonPath().getString("isbn");
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority = 4,dependsOnMethods="TestPostBooks")
	public static void TestDeleteBook() throws JsonProcessingException
	{
		Response res = UserEndPoints.DeleteBook();	
		res.then().assertThat().log().body();
		Assert.assertEquals(res.getStatusCode(), 204);
	}
}
