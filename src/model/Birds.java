package model;

public class Birds extends Habitas{
	private String type;
	private int height;
	private int numerOfBirds;

	public Birds(String id, int lengh, int width, String type, int height, int numerOfBirds){
		super(id, lengh, width);
		this.type = type;
		this.height = height;
		this.numerOfBirds = numerOfBirds;
	}
	
}