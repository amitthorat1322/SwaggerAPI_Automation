package endpoints;

public class PetRoutes {
		
		public static String baseURI = "https://petstore.swagger.io/v2";
	
		public static String postUserCreateWithList = baseURI+"/user/createWithList";
		public static String getUserByUsername = baseURI+"/user/{username}";
		public static String putUpdateUser = baseURI+"/user/{username}";
		public static String deleteUser = baseURI+"/user/{username}";
		public static String getUserLogin = baseURI+"/user/login";
		public static String getUserLogout = baseURI+"/user/logout";
		public static String postUserCreateWithArray = baseURI+"/user/createWithArray";
		public static String postCreateUser= baseURI+"/user";
		
	
		public static String uploadImage =baseURI+"/pet/{petId}/uploadImage";
		
		public static String postNewPetStore = baseURI+"/pet";
		public static String putUpadtePet = baseURI+"/pet";
		public static String getPet = baseURI+"/pet/findByStatus";
		public static String postFindById = baseURI+"/pet/{petId}";
		public static String getPetById = baseURI+"/pet/{petId}";
		public static String deletePet = baseURI+"/pet/{petId}";
				
	
		public static String postOrder = baseURI+"/store/order";
		public static String getOrder = baseURI+"/store/order/{orderId}";
}		
