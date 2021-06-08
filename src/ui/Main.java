package ui; 

import model.PetCenter;
import model.PetNursery;
import model.Use;
import model.Specie;
import model.Status;
import model.Priority;
import model.Owner;
import java.util.Scanner;                         	// javac -cp src src/ui/Main.java -d bin
													// java -cp bin ui.Main
													// javadoc -cp src -subpackages model:ui -d docs/javadoc/
public class Main{
	/**
	* Description: tool provided by java
	*/
	public static Scanner sc;
	/**
	* Description: variable used to control option 8 of the menu
	*/
	public boolean logout = false;
	/**
	* Description: an object of type PetCenter
	*/
	public PetCenter mascotas = new PetCenter();
	public PetNursery guarderia = new PetNursery();
	/**
	* Description: class main method
	* @param args String, I don't know what to write but I put it because when I generated the documentation it told me that it had no parameters, and then I write this so that that message stops appearing xD
	*/
	public static void main (String [] args){
		sc = new Scanner(System.in);
		Main main = new Main();
		main.mainMenu();
	}
	public void mainMenu(){
		int choose;
		do{
		System.out.println("\n-------------------------------------\n"+
			"\nChoose the service you want to enter:\n" +
			"1 Veterinary emergencies\n" +
			"2 Pet nursery\n" +
			"Another number to end the program\n");
			choose = sc.nextInt();
			sc.nextLine();
			switch(choose){
				case 1:
				petCenterMenu();
				break;
				case 2:
				petNurseryMenu();
				break;
				default:
					System.out.println("Bye!");
			}
		}while(choose == 1 || choose == 2);
	}
	/**
	* Description: this method shows the PetCenter's menu
	*/
	public void petCenterMenu(){
		int option;
		do{
		System.out.println ("\n-------------------------------------\n"+
							"Bienvenido al PetCenter\nElija una de las siguientes opciones:\n"+
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
		}while(option != 8 || !logout);
	}
	public void petNurseryMenu(){
		
		System.out.println("Bienvenido a la guarderia de mascotas\nElija una de las siguientes opciones:\n" +
							"1 Para registrar una nueva mascota\n" +
							"2 Para buscar una mascota en la guarderia\n" +
							"3 Para ver el mapa de la guarderia\n" +
							"4 Para ver la informacion de un habitat\n" +
							"5 Para ver las estadisticas\n");
	}
	/**
	* Description: This method makes the calls to the corresponding methods according to the user's choice
	* @param option int, This variable is the one that saves the user's option and the one that is in charge of choosing the corresponding method
	* pre: that the user has made a choice in the menu method
	*/
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
			startConsultation();
			break;
			case 6:
			finishConsultation();
			break;
			case 7:
			petNumber();
			break;
			case 8:
			logout();
			break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	/**
	* Description: This method is responsible for requesting the necessary information, and sending it to the PetCenter to register a veterinarian
	*/
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
		System.out.println(mascotas.addVeterinary(cc, name, lastName, id, status));
	}
	/**
	* Description:This method does the verification of the necessary requirements to eliminate a veterinarian and acts accordingly
	*/
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
			System.out.println(mascotas.deleteVeterinary(id));
		}
	}
	/**
	* Description:  This method is responsible for requesting the necessary information to register a pet and its respective owner and send it to the PetCenter
	*/
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
				System.out.println(mascotas.addPet(petName, age, specie, new Owner(idNumber, ownerName, phone, address),  sintomas,  prioridad, race));
			} else {
				System.out.println(mascotas.addPet(petName, age, specie, new Owner(idNumber, ownerName, phone, address),  sintomas,  prioridad));
			}
		}
	}
	/**
	* Description: this method is in charge of verifying if the combination of pet and owner to be registered already exists or not
	* @param petName String, this variable contains the name of the pet to be registered
	* @param ownerName String, this variable contains the name of the owner that you want to register for a pet
	* @return find Boolean, returns a true result in case the pet and owner combination to be registered already exists
	*/
	public boolean comprobacion(String petName, String ownerName){
		boolean find = false;
		for(int i = 0; i < mascotas.getPets().length && !find; i++){
			if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getName().equalsIgnoreCase(petName)) && (mascotas.getPets()[i].getOwner() != null && mascotas.getPets()[i].getOwner().getName().equalsIgnoreCase(ownerName))) {
				find = true;
			}
		} 
		return find;
	}
	/**
	* Description: This method checks the status of the pet to be removed from the waiting queue, if it meets the conditions, it sends the information to the PetCenter
	*/
	public void removePet(){
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		System.out.println("Ingrese el ID del propietario de la mascota");
		String idNumber = sc.nextLine();
		boolean find = false;
		for(int i = 0; i < mascotas.getPets().length && !find; i++){
			if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getName().equalsIgnoreCase(petName)) && (mascotas.getPets()[i].getOwner() != null && mascotas.getPets()[i].getOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
				if (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO) {
					System.out.println(mascotas.removePet(petName, idNumber));
				}
				find = true;
			}
		}
	}
	/**
	* Description:Assign a veterinarian to a consultation through their CC and their status.
	* pre: requires the vet's Status has been saved as available so that it can be assigned to the consultation
	*/
	public void startConsultation(){
		boolean find = false;
		System.out.println("Ingrese el numero de Documento del veterinario");
		String cc = sc.nextLine();
		for (int i = 0; i < mascotas.getVeterinarians().length && !find; i++) {
			if (mascotas.getVeterinarians()[i]!=null && mascotas.getVeterinarians()[i].getCc().equalsIgnoreCase(cc)) {
				if (mascotas.getVeterinarians()[i].getStatus().equalsIgnoreCase("disponible")) {
					if (nextConsultation() != -1) {
						mascotas.getPets()[nextConsultation()].setStatus(Status.EN_CONSULTA);
						mascotas.getPets()[nextConsultation()].setVeterinery(mascotas.getVeterinarians()[i]);
						int count = mascotas.getVeterinarians()[i].getPetsAttended();
						mascotas.getVeterinarians()[i].setPetsAttended(count++);
					} else {
						System.out.println("Ya no quedan mascotas por atender");
					} find = true;
				} else {
					System.out.println("El veterinario que eligio no se encuentra disponible");
				} find = true; 
			}
		}
		if (find == false) {
			System.out.println("El numero de Documento que ingreso no corresponde al de ningun veterinario");
		}
	}
	/**
	* Description: 
	*/
	public int nextConsultation(){
		boolean find = false;
		int pos = -1;
		for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
			if (mascotas.getPets()[i] != null && (mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_1) && (mascotas.getPets()[i].getOrder() == (i+1)) && (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO)) {
				find = true;
				pos = i;
			} 
		} if (find == false) {
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if (mascotas.getPets()[i] != null && (mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_2) && (mascotas.getPets()[i].getOrder() == (i+1)) && (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO)) {
					find = true;
					pos = i;
				} 
			}
		} if (find == false) {
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if (mascotas.getPets()[i] != null && (mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_3) && (mascotas.getPets()[i].getOrder() == (i+1)) && (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO)) {
					find = true;
					pos = i;
				} 
			}
		} if (find == false) {
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if (mascotas.getPets()[i] != null && (mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_4) && (mascotas.getPets()[i].getOrder() == (i+1)) && (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO)) {
					find = true;
					pos = i;
				} 
			}
		} if (find == false) {
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if (mascotas.getPets()[i] != null && (mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_5) && (mascotas.getPets()[i].getOrder() == (i+1)) && (mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO)) {
					find = true;
					pos = i;
				} 
			}
		}
		return pos;
	}
	public void finishConsultation(){
		System.out.println("Ingrese el numero de Documento del veterinario");
		String cc = sc.nextLine();
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		boolean find1 = false;
		boolean find = false;
		for (int i = 0; i < mascotas.getVeterinarians().length && !find; i++) {
			if (mascotas.getVeterinarians()[i] != null && mascotas.getVeterinarians()[i].getCc().equalsIgnoreCase(cc)){
				for (int j = 0; j < mascotas.getPets().length && !find1; j++) {
					if (mascotas.getPets()[j] != null && mascotas.getPets()[j].getName().equalsIgnoreCase(petName)) {
						if ((mascotas.getPets()[j].getStatus() == Status.EN_CONSULTA) && (mascotas.getPets()[j].getVeterinary() != null && mascotas.getPets()[j].getVeterinary() == mascotas.getVeterinarians()[i])) {
							System.out.println("Eliga una de las siguientes opciones:\n"+
												"(1) Para autorizar la salida de la mascota\n"+
												"(2) Para hospitalizar a la mascota");
							int opcion = sc.nextInt();
							sc.nextLine();
							if (opcion == 1) {
								mascotas.getPets()[j].setStatus(Status.SALIDA_AUTORIZADA);
							} else {
								mascotas.getPets()[j].setStatus(Status.TRASLADO_A_HOSPITALIZACION);
							}
							mascotas.getVeterinarians()[i].setStatus("disponible");
							System.out.println("La consulta finalizo exitosamente");
						} else {
							System.out.println("La mascota no se encuentra en consulta con este veterinario");
						}
					}
				}
			} else {
				System.out.println("El Documento de indentidad que ingreso no corresponde al de ningun veterinario");
			}
		}
	}
	public void petNumber(){
		int total = 0;
		for (int i = 0; i < mascotas.getPets().length; i++) {
			if (mascotas.getPets()[i] != null && mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO) {
				total++;
			}
		}
		System.out.println("El numero de mascotas que faltan por atender son: "+total);
	}
	public void logout(){
		boolean find = false;
		for (int i = 0; i < mascotas.getPets().length && !find; i++) {
			if (mascotas.getPets()[i] != null && mascotas.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO) {
				System.out.println("No se puede realizar el cierre del PetCenter porque aun quedan mascotas por atender");
				find = true;
			}
		} if (find == false) {
			int max = 0;
			int pos = 0;
			for (int i = 0; i < mascotas.getVeterinarians().length ; i++) {
				if (mascotas.getVeterinarians()[i] != null && max < mascotas.getVeterinarians()[i].getPetsAttended()) {
					max = mascotas.getVeterinarians()[i].getPetsAttended();
					pos = i;
				}
			} if (mascotas.getVeterinarians()[pos] != null) {
				System.out.println("El veterinario que tuvo el mayor numero de consultas fue: " + mascotas.getVeterinarians()[pos].getName());
			} 
			int count =0;
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_1) && (mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA || mascotas.getPets()[i].getStatus() == Status.TRASLADO_A_HOSPITALIZACION)) {
					count++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 1 fueron: "+ count); 
			int count1 =0;
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_2) && (mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA || mascotas.getPets()[i].getStatus() == Status.TRASLADO_A_HOSPITALIZACION)) {
					 count1++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 2 fueron: "+ count1);
			int count2 =0;
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_3) && (mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA || mascotas.getPets()[i].getStatus() == Status.TRASLADO_A_HOSPITALIZACION)) {
					 count2++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 3 fueron: "+ count2);
			int count3 =0;
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_4) && (mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA || mascotas.getPets()[i].getStatus() == Status.TRASLADO_A_HOSPITALIZACION)) {
					 count3++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 4 fueron: "+ count3);
			int count4 =0;
			for (int i = 0; i < mascotas.getPets().length && ! find; i++) {
				if ((mascotas.getPets()[i] != null && mascotas.getPets()[i].getPriority() == Priority.PRIORIDAD_5) && (mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA || mascotas.getPets()[i].getStatus() == Status.TRASLADO_A_HOSPITALIZACION)) {
					 count4++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 5 fueron: "+ count4);
			int percentage = 0;
			int without = 0;
			int total = 0;
			for (int i = 0; i < mascotas.getPets().length; i++) {
				if (mascotas.getPets()[i] != null && mascotas.getPets()[i].getStatus() == Status.SALIDA_SIN_ATENCION) {
					without++;
				} total++;
			} 
			percentage = (without * 100)/total;
			System.out.println("El porcentaje de mascotas que se fueron sin ser atendidas es: "+percentage+" %");
			for (int i = 0; i < mascotas.getPets().length; i++) {
				if (mascotas.getPets()[i] != null && mascotas.getPets()[i].getStatus() == Status.SALIDA_AUTORIZADA) {
					mascotas.getPets()[i] = null;
				}
			}
			logout = true;
		}
	}
}