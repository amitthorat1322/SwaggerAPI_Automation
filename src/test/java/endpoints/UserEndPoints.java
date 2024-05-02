package endpoints;

import io.restassured.response.Response;


import payload.AddListOfBooks;
import payload.CollectionOfIsbn;
import payload.StringObject;
import testCases.AccountTestCases;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
public class UserEndPoints {

	public static String isbn = "9781449325862";
	
	public static  Response GetBooks()
	{
		Response response = given()
							.contentType(ContentType.JSON)
							.when().get(Routes.getBooks);	
		return response;
	}
	
	public static Response PostBooks() throws JsonProcessingException
	{
		  AddListOfBooks addlist = new AddListOfBooks(); 
		  addlist.setUserId(AccountTestCases.userId);
		  List<Map<String, String>> isbns = new ArrayList<>();
		  
		  Map<String, String> isbn = new HashMap<>(); 
		  isbn.put("isbn","9781449325862");
		  isbns.add(isbn);
		  addlist.setCollectionOfIsbns(isbns);
		  ObjectMapper obj = new ObjectMapper();
		  String g = obj.writeValueAsString(addlist);

		Response response = given()
							.contentType(ContentType.JSON)
							.header("accept", "application/json")
  	                        .header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
							.body(addlist)
							.when().post(Routes.postBooks);
		
		return response;
	}
	
	
	public static Response DeleteBooks()
	{
		String u = AccountTestCases.userId ; 		
		Response response = given()
				.contentType(ContentType.JSON)
				.header("accept", "application/json")
                .header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
                .queryParam("UserId",u)
				.when().delete(Routes.deleteBooks);

		return response;
		
		
		
	}
	public static Response GetBook()
	{
		Response response = given()
							.contentType(ContentType.JSON).
							header("accept", "application/json")
					        .queryParam("ISBN",isbn)
							.when().get(Routes.getBook);
		return response;
	}
	
	public static Response DeleteBook() throws JsonProcessingException
	{
		String u = AccountTestCases.userId ; 
		StringObject sb = new StringObject();
		sb.setIsbn(isbn);
		sb.setUserId(u);
		
		Response response = given()
				.contentType(ContentType.JSON)
				.header("accept", "application/json")
                .header("authorization", "Basic cm9oaXRzc3Rob3JhdDpSb2hpdEAxMjM0")
		        .body(sb)
				.when().delete(Routes.deleteBook);
		
		return response;
	}
	

}
