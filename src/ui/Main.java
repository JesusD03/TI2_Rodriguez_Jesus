package ui; 

import model.PetCenter;
import model.Specie;
import model.Status;
import model.Priority;
import model.Owner;
import java.util.Scanner;                         	// javac -cp src src/ui/Main.java -d bin
													// java -cp bin ui.Main
													// javadoc -cp src -subpackages model:ui -d docs/javadoc/
public class Main{
	public static Scanner sc;
	public PetCenter mascotas;

	public static void main (String [] args){
		sc = new Scanner(System.in);
		Main main = new Main();
		main.showMenu();
	}
	public void showMenu(){

	}
}