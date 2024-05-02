package payload;

import java.util.List;
import java.util.Map;

public class AddListOfBooks {

	private String userId ;
	private List<Map<String, String>> collectionOfIsbns;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Map<String, String>> getCollectionOfIsbns() {
		return collectionOfIsbns;
	}
	public void setCollectionOfIsbns(List<Map<String, String>> isbns) {
		this.collectionOfIsbns = isbns;
	}
}
