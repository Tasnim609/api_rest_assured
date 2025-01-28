package dataTableObject;
// if this product class do not  depend on another class, that's make a POZO Class 
//So this class is POZO Class and Plain Java Object
public class Product { //This is POZO class
//we are creating Format from blue print of Object/class 
	private int id;
	private String title;
	private int price;
	private String description;
	private String[] images;
	private String creationAt;
	private String updatedAt;
	private Category category;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String getCreationAt() {
		return creationAt;
	}

	public void setCreationAt(String creationAt) {
		this.creationAt = creationAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
