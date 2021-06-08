package model;

public class Rabbits extends Habitas{
	private String plantType;
	private int numberOfPlants;

	public Rabbits(String id, int lengh, int width, String plantType, int numberOfPlants){
		super(id, lengh, width);
		this.plantType = plantType;
		this.numberOfPlants = numberOfPlants;
	}
	
}