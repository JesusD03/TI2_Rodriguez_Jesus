package model;

public class Cats extends Habitas{
	private int height;
	private int weight;

	public Cats(String id, int lengh, int width, int height, int weight){
		super(id, lengh, width);
		this.height = height;
		this.weight = weight;
	}
	
}