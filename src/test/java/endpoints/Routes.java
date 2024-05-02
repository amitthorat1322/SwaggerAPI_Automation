package endpoints;

public class Routes {
	
	
	public static String base_url = "https://demoqa.com";
	
	
	/*********************************************
	 Account Model
	 *********************************************/
	
	public static String postAuthorized = base_url+"/Account/v1/Authorized";
	public static String postGenerateToken = base_url+"/Account/v1/GenerateToken";
	public static String postUser = base_url+"/Account/v1/User";
	public static String deleteUser = base_url+"/Account/v1/User/{userID}";
	public static String getUser = base_url+"/Account/v1/User/{userID}";
	
	/*********************************************
	 User Model
	 *********************************************/
	public static String getBooks = base_url+"/BookStore/v1/Books";
	public static String getBook = base_url+"/BookStore/v1/Book";
	public static String postBooks = base_url+"/BookStore/v1/Books";
	public static String deleteBooks = base_url+"/BookStore/v1/Books";
	public static String deleteBook = base_url+"/BookStore/v1/Book";
	public static String putBook = base_url+"/BookStore/v1/Books";

	
	

}
