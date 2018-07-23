package com.example.imagelist;

public class ItemClass {
	private int image;
	private String name,yearlevel;
	public ItemClass(int image, String name, String yearlevel) {
		super();
		this.image = image;
		this.name = name;
		this.yearlevel = yearlevel;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearlevel() {
		return yearlevel;
	}
	public void setYearlevel(String yearlevel) {
		this.yearlevel = yearlevel;
	}
	
}
 