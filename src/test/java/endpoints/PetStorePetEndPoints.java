package endpoints;

import petPayLoad.Category;
import petPayLoad.Pet;
import petPayLoad.Tag;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class PetStorePetEndPoints {

	public static Pet p;
	public static Response CreatePet()
	{
		Pet p =new Pet();
		p.setId(20001);
			Category c = new Category();
			c.setId(20002);
			c.setName("A");
		p.setCategory(c.toString());
		p.setName("tas");
			List<String> ph = new ArrayList<>();
			ph.add("sdfsdfdsf");
		p.setPhotoUrls(ph);
			Tag t = new Tag();
			t.setId(20004);
			t.setName("asd");
			List<Tag> tag = new ArrayList<Tag>();
			tag.add(t);
		p.setTags(tag);
		p.setStatus("avaiable");
		
		Response res = given().contentType(ContentType.JSON).headers("accept","application/json").body(p).when().post(PetRoutes.postNewPetStore);
		
		return res;
	}
	
	
	public static Response UpdatePet()
	{
		p =new Pet();
		p.setId(20001);
			Category c = new Category();
			c.setId(20002);
			c.setName("A");
		p.setCategory(c.toString());
			List<String> ph = new ArrayList<>();
			ph.add("sdfsdfdsf");
		p.setName("Dogiee");
		p.setPhotoUrls(ph);
			Tag t = new Tag();
			t.setId(20004);
			t.setName("asd");
			List<Tag> tag = new ArrayList<Tag>();
			tag.add(t);
		p.setTags(tag);
		p.setStatus("avaiable");
		

		 Response res = given().contentType(ContentType.JSON).header("accept","application/json")
				 		.body(p).when().put(PetRoutes.putUpadtePet);
			
			return res;
	}
	
	
	public static Response findByStatus()
	{

		Response res =  given().contentType(ContentType.JSON).header("accept","application/json")
				.queryParam("status", "sold")
		 		.when().get(PetRoutes.getPet);
				
				return res;
	}
	
	public static Response findByPetID()
	{

		Response res =  given().contentType(ContentType.JSON).header("accept","application/json")
				.pathParam("petId",p.getId())
		 		.when().get(PetRoutes.getPetById);
				
				return res;
	}
	
	
	public static Response updatePetUsingPetId()
	{
		Response res =  given().contentType(ContentType.JSON).header("accept","application/json")
				.pathParam("petId",20001)
				.formParams("name", "amy","status","available")
		 		.when().get(PetRoutes.postFindById);
				
				return res;
		
		
		
		
	}
}
