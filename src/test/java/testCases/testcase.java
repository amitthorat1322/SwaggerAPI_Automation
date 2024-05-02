package testCases;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;

import endpoints.PetRoutes;
import endpoints.PetStoreUserEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petPayLoad.User;

public class testcase {

	public static String url ="https://petstore.swagger.io/v2/user/createWithArray";
	public static void main(String args[])
	{
		
		JSONArray js = new JSONArray();
		User uss = new User();
		uss.setId(10021);
		uss.setUsername("Raj");
		uss.setFirstName("Raj");
		uss.setLastName("Patil");
		uss.setPassword("Amit@1234");
		uss.setPhone("9665194353");
		uss.setUserStatus(0);
	js.put(uss);
		
	Response rs = (Response) given().contentType(ContentType.JSON).body(js)
						.when().post(url).then().assertThat()
						.log().body();
	
	String v = rs.getBody().toString();
	System.out.println(v); 
	
	}
}
