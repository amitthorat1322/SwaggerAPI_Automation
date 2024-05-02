package steps;
import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonValidator;
import org.json.JSONObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ls.BookingDTO;
import ls.BookingDetails;
import ls.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;

public class Rest1Implementation {

    private final String baseUrl = "https://restful-booker.herokuapp.com/";
    private final String bookingEndpoint = "booking";

    private RequestSpecification rs;
    private Response response;
    private String createdString;
    private static final Random random = new Random();

    private final ObjectMapper objectMapper = new ObjectMapper();
	BookingPojo bj = new BookingPojo();

    private static String generateRandomName() {
        StringBuilder name = new StringBuilder();
        int length = random.nextInt(5) + 5; // Random length between 5 and 10 characters
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a'); // Random lowercase letter
            name.append(c);
        }
        return name.toString();
    }
    
    private static String generateRandomDate() {
        int year = 2022 + random.nextInt(3); // Random year between 2022 and 2024
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = random.nextInt(28) + 1; // Random day between 1 and 28 (assuming all months have 28 days)
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    @Given("user has access to endpoint")
    public void user_has_access_to_endpoint()  {
    	
    			System.out.println("sAA");
    					
    		
		
		  String createdString = " { \n " + 
		  " \"firstname\": \"api testing\", \n" +
		  " \"lastname\": \"tutorial\",\n" + 
		  " \"totalprice\": 1000, \n" +
		  " \"depositpaid\": true,\n" + 
		  " \"bookingdates\": { \n" +
		  " \"checkin\": \"2018-01-01\",\n"  +
		  " \"checkout\": \"2019-01-01\" \n" +
		  " } \n"+ 
		  "}";
		 
	
    	
		/*
		 * BookingPojo bj = new BookingPojo(); BookingDetails bd = new BookingDetails();
		 * bj.setFirstname("amit"); bj.setLastname("thorat"); bj.setTotalprice(2324);
		 * bj.setDepositpaid(true); bd.setCheckin("2018-01-01");
		 * bd.setCheckout("2018-01-02"); bj.setBookingdates(bd);
		 * bj.setAdditionalneeds("amii"); try { createdString =
		 * objectMapper.writeValueAsString(bj); } catch (JsonProcessingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
  
    }

    @When("user creates a booking")
    public void user_creates_a_booking() throws JsonParseException, JsonMappingException, IOException {
    	Random random = new Random();
		
		int numberOfData = 2;
		
		for(int i=0;i<numberOfData;i++)
		{	
			
			  bj.setFirstname(generateRandomName()); bj.setLastname(generateRandomName());
			  bj.setTotalprice(random.nextInt(1000) + 100); // Random price between 100 and
			  bj.setDepositpaid(random.nextBoolean()); BookingDetails bdd = new
			  BookingDetails(); bdd.setCheckin(generateRandomDate());
			  bdd.setCheckout(generateRandomDate()); bj.setBookingdates(bdd);
			  bj.setAdditionalneeds(generateRandomName());
			 
			
			
	            rs = given()
	                    .baseUri(baseUrl)
	                    .basePath(bookingEndpoint)
	                    .contentType("application/json")
	                    .body(new JSONObject(bj).toString());
	            
	            response = rs.when().post();
	            response.then().assertThat().log().body().extract().response();
	            
	            System.out.println("Name:-"+response.path("booking.firstname"));
	            System.out.println("Name2:-"+response.jsonPath().getString("booking.firstname"));
	            
	            String responseBody = response.getBody().asString();
	            System.out.println("output:-"+responseBody);
	            BookingDTO bdto = objectMapper.readValue(responseBody, BookingDTO.class);  
	            validateData(new JSONObject(responseBody),bdto);
	            
	            
		}
        
    }



 
        private void validateData(JSONObject jsonObject, BookingDTO bdto) {
		
        	assertNotNull(bdto.getBookingid(),"Booking id is Missing");
        	assertEquals(jsonObject.getJSONObject("booking").getString("firstname"),bdto.getBooking().getFirstname(),"First Name did not match");
        
		
	}

		@Then("user should get the response code")
        public void user_should_get_the_response_code() throws JsonParseException, JsonMappingException, IOException {
        	
        	
			/* String name = response.getBody().asString(); */
        			System.out.println("output:-");
            
        			
        	//BookingDTO bdto = objectMapper.readValue(name, BookingDTO.class);
        	
       // 	System.out.println("Name:-"+response.path("booking.firstname"));
        	
			/* Assert.assertEquals(response.path("booking.firstname"),"John"); */
			/*
			 * response.then().assertThat().log().body().extract().response(); String name =
			 * response.getBody().asString(); System.out.println("output:-"+ name );
			 * 
			 */
			/*
			 * BookingDTO bdto = objectMapper.readValue(name, BookingDTO.class);
			 * System.out.println("Sas"+bdto.getBookingid());
			 * System.out.println("Name:-"+response.path("booking.firstname"));
			 */
			  /*
			 * Assert.assertEquals(response.path("booking.firstname"),"api testing");
			 */
        }

		
		  @Then("user validates the response with JSON schema") public void
		  user_validates_the_response_with_json_schema() {
			  	
			  response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("E:\\interview\\TP\\src\\test\\java\\com\\testpro\\TP\\CreateJsonSchema.json"));
		  
		  }
		 
   
    
    
}