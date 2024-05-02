package payload;

public class GetUserResult {
	private String userId ;
	private String username;
	private BookModel books;
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
	public BookModel getBooks() {
		return books;
	}
	public void setBooks(BookModel books) {
		this.books = books;
	}
	

}
