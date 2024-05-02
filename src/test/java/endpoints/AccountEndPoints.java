package endpoints;

import io.restassured.response.Response;
import payload.CreateUserResult;
import payload.LoginViewModel;
import payload.RegisterViewModel;
import static io.restassured.RestAssured.given;
import java.util.Random;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class AccountEndPoints {
	 public static final Random random = new Random();
	  static Faker fk ; 
	  static CreateUserResult cr ;

		static ObjectMapper objectMapper ;
	  	public static String randomCreateData()
	  	{
	  		StringBuilder name = new StringBuilder();
	  		int length = random.nextInt(5)+5;
	  		for(int i=0;i<length;i++)
	  		{
	  			char c = (char)(random.nextInt(26)+'a');
	  			name.append(c);
	  		}
	  		return name.toString();
	  	}
	  	
	  	public static String randomDate()
	  	{
	  		int year = random.nextInt(4);
	  		int month = random.nextInt(12)+1;
	  		int day = random.nextInt(28)+1;
	  		
		  		return String.format("%04d-%02d-%02d",year,month,day);
		  		
	  	}
	  
	  	public static Response AuthorizeUser()
	  	{
	  		LoginViewModel lvm = new LoginViewModel();
	  		lvm.setUserName("rohitsthorat");
	  		lvm.setPassword("Rohit@1234");
	  		
	  			Response res = given()
	  							.contentType(ContentType.JSON)
	  							.header("accept", "application/json")
	  	                        .header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
	  	                        .contentType(ContentType.JSON)
	  	                        .body(lvm)
	  	                        .when().post(Routes.postAuthorized);
	  			
	  			return res;
	  	}
	  	
	  	
	  	public static Response GenerateToken() throws JsonProcessingException
	  	{
	    	    
	  		LoginViewModel lvm = new LoginViewModel();
	  		lvm.setUserName("rohitssthorat");
	  		lvm.setPassword("Rohit@1234");
	  	    ObjectMapper objectMapper = new ObjectMapper();
	  	  	
	  	    String as = objectMapper.writeValueAsString(lvm);
	  		
	  		Response res = given()
						.contentType(ContentType.JSON)
						.header("accept", "application/json")
						.header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
						.contentType(ContentType.JSON)
                      	.body(as)
                      .when().post(Routes.postGenerateToken);
		
		return res;
	  	}
	  	
	  	
		public static Response createUser() throws JsonProcessingException
		{
			fk =  new Faker();
			RegisterViewModel rvm = new RegisterViewModel();
			objectMapper = new ObjectMapper();
			rvm.setUserName("rohitssthorat");
			rvm.setPassword("Rohit@1234");	
			String GeneratedData = objectMapper.writeValueAsString(rvm);		 
						Response res = given()
								.contentType(ContentType.JSON)
								.header("accept", "application/json")
								.header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
								.body(GeneratedData)
								.when().post(Routes.postUser);		
			return res;
			
		}

		 
		public static Response createUserID(String userId) 
		{
			  Response response = given() 
					  .contentType(ContentType.JSON)
					  .header("accept", "application/json")
					  .header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
					  .pathParam("userID", userId) 
					  .when()
					  .get(Routes.getUser); 
			  return response; 
		}
			  
			  
		 public static Response deleteUserID(String userId) 
		 {
			  Response res = given()
			  .contentType(ContentType.JSON) .pathParam("userID", userId)
			  .when().get(Routes.deleteUser);
			  return res; 
		 }
		
		 
		 
	
}
