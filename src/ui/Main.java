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
		int option;
		do{
		System.out.println ("-------------------------------------\n"+
							"Bienvenido al PetCenter\nEliga una de las siguientes opciones:\n"+
							"(1) Para registrar un nuevo veterinario\n"+
							"(2) Para eliminar un veterinario\n"+
							"(3) Para registrar una mascota\n"+
							"(4) Para retirar una mascota\n"+
							"(5) Para iniciar una consulta\n"+
							"(6) Para finalizar una consulta\n"+
							"(7) Para mostrar el numero de mascotas sin atender\n"+
							"(8) Para cerrar el centro\n");
		option = sc.nextInt();
		menu(option);
		}while(option != 8);
	}
	public void menu(int option){
		switch(option){
			case 1:
			break;
			case 2:
			break;
			case 3:
			break;
			case 4:
			break;
			case 5:
			break;
			case 6:
			break;
			case 7:
			break;
			case 8:
			break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	public void newVet(){
		System.out.println("Ingrese el nombre del veterinario");
		String name = sc.nextLine();
		
	}
}