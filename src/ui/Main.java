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
	public PetCenter mascotas = new PetCenter();

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
		sc.nextLine();
		menu(option);
		}while(option != 8);
	}
	public void menu(int option){
		switch(option){
			case 1:
			newVet();
			break;
			case 2:
			deleteVet();
			break;
			case 3:
			newPet();
			break;
			case 4:
			removePet();
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
		System.out.println("Ingrese el Documento de indentidad del veterinario");
		String cc = sc.nextLine();
		System.out.println("Ingrese el nombre del veterinario");
		String name = sc.nextLine();
		System.out.println("Ingrese el apellido del veterinario");
		String lastName = sc.nextLine();
		System.out.println("Ingrese el ID del veterinario");
		String id = sc.nextLine();
		System.out.println("Ingrese el estado del veterinario");
		String status = sc.nextLine();
		mascotas.addVeterinary(cc, name, lastName, id, status);
	}
	public void deleteVet(){
		boolean find = false;
		for (int i = 0; i < mascotas.getPets().length && !find ; i++) {
			if (mascotas.getPets()[i] != null) {
			System.out.println("No se puede eliminar un veterinario porque aun quedan mascotas por atender");
			find = true;
			}
		} if(find == false){
			System.out.println("Ingrese el ID del veterinario que desea eliminar");
			String id = sc.nextLine();
			mascotas.deleteVeterinary(id);
		}
	}
	public void newPet(){
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		System.out.println("Ingrese la edad de la mascota");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Selecciona el numero que corresponde a la especie de la mascota\n"+
							"(1) PERRO\n" + "(2) GATO\n" + "(3) CONEJO\n" + "(4) REPTIL\n" + "(5) PAJARO");
		int chose = sc.nextInt();
		sc.nextLine();
		String race = "";
		Specie specie = Specie.PERRO;
		if (chose == 1) {
			 specie = Specie.PERRO;
			System.out.println("Ingrese la raza de la mascota");
			 race = sc.nextLine();
		} else if (chose == 2) {
			 specie = Specie.GATO;
			System.out.println("Ingrese la raza de la mascota");
			 race = sc.nextLine();
		} else if (chose == 3) {
			 specie = Specie.CONEJO;
		} else if (chose == 4) {
			 specie = Specie.REPTIL;
		} else {
			 specie = Specie.PAJARO;
		}
		System.out.println("Ingrese Documento de indentidad del propietario de la mascota");
		String idNumber = sc.nextLine();							
		System.out.println("Ingrese el nombre del propietario de la mascota");
		String ownerName = sc.nextLine();
		System.out.println("Ingrese el telefono del propietario de la mascota");
		String phone = sc.nextLine();
		System.out.println("Ingrese la direccion del propietario de la mascota");
		String address = sc.nextLine();
		System.out.println("Ingrese los sintomas de la mascota");
		String sintomas = sc.nextLine();
		System.out.println("Selecciona el numero que corresponde a la prioridad para la mascota\n"+
							"(1) Prioridad 1\n" + "(2) Prioridad 2\n" + "(3) Prioridad 3\n" + "(4) Prioridad 4\n" +
							"(5) Prioridad 5");
		int chose1 = sc.nextInt();
		sc.nextLine();
		Priority prioridad = Priority.PRIORIDAD_1;
		if (chose1 == 1) {
			 prioridad = Priority.PRIORIDAD_1;
		} else if (chose1 == 2) {
			 prioridad = Priority.PRIORIDAD_2;
		} else if (chose1 == 3) {
			 prioridad = Priority.PRIORIDAD_3;
		} else if (chose1 == 4) {
			 prioridad = Priority.PRIORIDAD_4;
		} else {
			 prioridad = Priority.PRIORIDAD_5;
		}
		if (comprobacion(petName, ownerName)) {
			System.out.println("Esta combinacion de nombre de la mascota y del propietario ya existe");
		} else {
			if (chose == 1 || chose == 2) {
				mascotas.addPet(petName, age, specie, new Owner(idNumber, ownerName, phone, address),  sintomas,  prioridad, race);
			} else {
				mascotas.addPet(petName, age, specie, new Owner(idNumber, ownerName, phone, address),  sintomas,  prioridad);
			}
		}
	}
	public boolean comprobacion(String petName, String ownerName){
		boolean find = false;
		for(int i = 0; i < mascotas.getPets().length && !find; i++){
			if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getName().equalsIgnoreCase(petName)) && (mascotas.getPets()[i].getOwner() != null && mascotas.getPets()[i].getOwner().getName().equalsIgnoreCase(ownerName))) {
				find = true;
			}
		} 
		return find;
	}
	public void removePet(){
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		System.out.println("Ingrese el ID del propietario de la mascota");
		String idNumber = sc.nextLine();
		boolean find = false;
		for(int i = 0; i < mascotas.getPets().length && !find; i++){
			if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getName().equalsIgnoreCase(petName)) && (mascotas.getPets()[i].getOwner() != null && mascotas.getPets()[i].getOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
				if (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO) {
					mascotas.removePet(petName, idNumber);
				}
				find = true;
			}
		}
	}
	
}