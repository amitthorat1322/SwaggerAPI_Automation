package endpoints;
import org.json.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import io.restassured.response.Response;
import petPayLoad.User;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
public class PetStoreUserEndPoints {
	
	public static ObjectMapper objectMapper ;
	static User userPojo = new User(); 
	static String userData ;
	public static Response userCreateUser() throws JsonProcessingException
	{
		//JSONObject jsonObject = new JSONObject();
		objectMapper = new ObjectMapper();
		userPojo.setId(10001);
		userPojo.setUsername("Amu");
		userPojo.setFirstName("Amit");
		userPojo.setLastName("Thorat");
		userPojo.setEmail("Amit@gmail.com");
		userPojo.setPassword("Amit@1234");
		userPojo.setPhone("8605521792");
		userPojo.setUserStatus(0);
		userData = objectMapper.writeValueAsString(userPojo);
		Response response = given()
							.contentType(ContentType.JSON)
							.body(userData)
							.when().post(PetRoutes.postCreateUser);	
		return response;
	}
	
	public static Response userLogin()
	{
	
		User us = new User();
		us.setUsername("Amu");
		us.setPassword("Amit@1234");
		
		Response response = given().contentType(ContentType.JSON).body(us).when().get(PetRoutes.getUserLogin);
		return response;
	}

	public static Response userLogout()
	{
		Response response = given().contentType(ContentType.JSON).when().get(PetRoutes.getUserLogout);	
		return response;
	}
	
	public static Response getUser()
	{
		String uname = userPojo.getUsername();
		Response response = given().contentType(ContentType.JSON).pathParam("username", uname).when().get(PetRoutes.getUserByUsername);
		return response;
	}

	
	public static Response updateUser()
	{
		String uname = userPojo.getUsername();
		User u = new User();
		u.setId(10001);
		u.setUsername("Amu");
		u.setFirstName("Ajay");
		u.setLastName("Patil");
		u.setEmail("Amit@gmail.com");
		u.setPassword("Amit@1234");
		u.setPhone("9975852913");
		u.setUserStatus(0);
		Response response = given().contentType(ContentType.JSON).pathParam("username",uname).body(u).when().put(PetRoutes.putUpdateUser);
				return response;
	}
	
	public static Response createWithArray() throws JsonProcessingException
	{
		
		User usa = new User();
		usa.setId(10026);
		usa.setUsername("Rajud");
		usa.setFirstName("Rajud");
		usa.setLastName("Patild");
		usa.setEmail("Amit@123d4");
		usa.setPassword("Raj@1d23");
		usa.setPhone("966519453");
		usa.setUserStatus(0);
		List<User> listOfUsers = new ArrayList<User>();
		listOfUsers.add(usa);
		ObjectMapper objmappers = new ObjectMapper();
		 String jsonArrayPay = objmappers.writeValueAsString(listOfUsers);
		
		Response response = given().contentType(ContentType.JSON).header("accept", "application/json").body(jsonArrayPay)
							.when().post(PetRoutes.postUserCreateWithArray);
		return response;
	}
	
	public static Response createWithList() throws JsonProcessingException
	{
		User uss = new User();
		uss.setId(10026);
		uss.setUsername("Raju");
		uss.setFirstName("Raju");
		uss.setLastName("Patil");
		uss.setEmail("Amit@1234");
		uss.setPassword("Raj@123");
		uss.setPhone("9665194353");
		uss.setUserStatus(0);
		
		List<User> listOfUser = new ArrayList<User>();
		listOfUser.add(uss);
		
		ObjectMapper objmapper = new ObjectMapper();
		 String jsonArrayPayload = objmapper.writeValueAsString(listOfUser);
		
		Response response = given().contentType(ContentType.JSON)
							.header("accept", "application/json").body(jsonArrayPayload)
							.when().post(PetRoutes.postUserCreateWithList);
		return response;
	}
	
}
