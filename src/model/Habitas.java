package model;

public abstract class Habitas{
	private String id;
	private int lengh;
	private int width;
	private Use use;

	public Habitas(String id, int lengh, int width){
		this.id = id;
		this.lengh = lengh;
		this.width = width;
		use = Use.VACIO;
	}

	public String toString(){
		String answer ="\nID: " + id + "\nlengh: " + lengh + "\nwidth: " + width + "\nUse: " + use;

		return answer;
	}
}