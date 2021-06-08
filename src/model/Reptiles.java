package model;

public class Reptiles extends Habitas{
	private String material;
	private String type;

	public Reptiles(String id, int lengh, int width, String material, String type){
		super(id, lengh, width);
		this.material = material;
		this.type = type;
	}
	
}