package payload;

import java.util.List;

public class CreateUserResult {

	private String userId;
	private String username;
	private List<BookModel> books;
	
	 public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public List<BookModel> getBooks() {
		return books;
	}
	public void setBooks(List<BookModel> books) {
		this.books = books;
	}
	
	
	
}
