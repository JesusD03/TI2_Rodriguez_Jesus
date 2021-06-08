package model;

public class PetNursery{
	private Habitas[][] habitas;

	public PetNursery(){
		habitas = new Habitas[6][5];
		initCats();
	}

	private void initCats(){
		for (int x = 0; x <= 2; x++) {
			for (int y = 0; y <= 2; y++) {
				habitas[x][y] = new Cats(("C"+x+y), 10, 10, 10, 10);
			}
		}
	}


}