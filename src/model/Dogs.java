package model;

public class Dogs extends Habitas{
	private int toys;

	public Dogs(String id, int lengh, int width, int toys){
		super(id, lengh, width);
		this.toys = toys;
	}
	
}