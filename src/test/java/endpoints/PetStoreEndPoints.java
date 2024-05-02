package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petPayLoad.Order;
import petPayLoad.OrderStatus;
import static io.restassured.RestAssured.given;
public class PetStoreEndPoints {
	
	public static Order o;
	public static Response placeOrder()
	{
		o = new Order();
		o.setId(3234);
		o.setPetId(20001);
		o.setQuantity(4);
		o.setShipDate("2024-04-30T07:57:45.176Z");
		o.setStatus(OrderStatus.placed);
		o.setComplete(true);
		
		
		Response res = given().contentType(ContentType.JSON).body(o)
						.when().post(PetRoutes.postOrder);
		
		return res;
	}

	
	public static Response getOrderID()
	{
		int s = o.getId();
		
		Response res = given().contentType(ContentType.JSON)
				.pathParam("orderId",s)
						.when().get(PetRoutes.getOrder);
		
		return res;
		
		
	}
}
