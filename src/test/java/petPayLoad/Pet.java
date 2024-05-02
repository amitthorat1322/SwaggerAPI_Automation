package petPayLoad;

import java.util.List;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnore;

public class Pet {

	private int id;
	private Category category;
	private String name;
	@JsonIgnore
	private  List<String> photoUrls;
	@JsonIgnore
	private List<Tag> tags;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  List<String> getPhotoUrls() {
		return photoUrls;
	}
	public  void setPhotoUrls(List<String> ph) {
		this.photoUrls = ph;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tag) {
		this.tags = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String status;
	public void setCategory(String string) {
		// TODO Auto-generated method stub
		
	}

}
