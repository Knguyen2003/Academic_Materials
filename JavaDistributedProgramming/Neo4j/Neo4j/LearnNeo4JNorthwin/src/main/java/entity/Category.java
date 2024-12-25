package entity;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Category implements Serializable{
	@SerializedName("categoryID")
	private int id;
	@SerializedName("categoryName")
	private String name;
	@SerializedName("description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category(int id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public Category(int id) {
		this.id = id;
	}

}
