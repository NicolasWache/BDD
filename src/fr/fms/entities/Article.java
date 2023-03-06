package fr.fms.entities;

public class Article {

	public int Id;
	public String Description;
	public String Brand;
	public double Price;
	public String CatName;
	
	public Article (String Description, String Brand, double Price, String CatName) {
		this.Description= Description;
		this.Brand = Brand;
		this.Price = Price;
		this.CatName = CatName;
	}
	public Article (int Id,String Description, String Brand, double Price) {
		this.Id= Id;
		this.Description= Description;
		this.Brand = Brand;
		this.Price = Price;
	}
	public Article (String Description, String Brand, double Price) {
		this.Description= Description;
		this.Brand = Brand;
		this.Price = Price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String Brand) {
		this.Brand = Brand;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		CatName = catName;
	}
}
