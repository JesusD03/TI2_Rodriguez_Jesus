package model;

public class PetCenter{
	public int MAX_VETERINARIANS = 7;
	public int MAX_PETS = 120;
	private int order = 1;
	//relationships
	private Pet[] pets = new Pet[MAX_PETS];
	private Veterinary[] veterinarians = new Veterinary[MAX_VETERINARIANS];
	//constructor
	public PetCenter(){
		
	}
	public void addPet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority){
		boolean empty = false;
		for(int i = 0; i < MAX_PETS && !empty; i++){
			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, owner, symptoms, priority, order);
				empty = true;
				order ++;
				System.out.print("the pet was added successfully\n");
			}
		} if (empty == false) {
			System.out.println("No se pudo agregar la mascota porque se llego a la capacidad maxima\n");
		}
	}
	public void addPet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority, String race){
		boolean empty = false;
		for(int i = 0; i < MAX_PETS && !empty; i++){
			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, owner, symptoms, priority, order, race);
				empty = true;
				order ++;
				System.out.print("the pet was added successfully\n");
			}
		} if (empty == false) {
			System.out.println("No se pudo agregar la mascota porque se llego a la capacidad maxima\n");
		}
	}
	public void removePet(String name, String idNumber){
		boolean find = false;
		for(int i = 0; i < MAX_PETS && !find; i++){
			if ((pets[i] != null && pets[i].getName().equalsIgnoreCase(name)) && (pets[i].getOwner() != null && pets[i].getOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
				pets[i].setStatus(Status.SALIDA_SIN_ATENCION);
				find = true;
				System.out.println("The pet was removed from the tail");
			}
		} if (find == false) {
			System.out.println("The pet could not be removed because it is not waiting to be treated");
		}
	}
	public void addVeterinary(String cc, String name, String lastName, String id, String status){
		boolean empty = false;
		for(int i = 0; i < MAX_VETERINARIANS && !empty; i++){
			if(veterinarians[i] == null){
				veterinarians[i] = new Veterinary(cc, name, lastName, id, status);
				empty = true;
				System.out.println("The vet was successfully added");
			}
		} if (empty == false) {
			System.out.println("Could not add vet because max was reached");
		}
	}
	public void deleteVeterinary(String id){
		boolean find = false;
		for(int i = 0; i < MAX_VETERINARIANS && !find; i++){
			if(veterinarians[i] != null && veterinarians[i].getId().equalsIgnoreCase(id)){
				find = true;
				veterinarians[i] = null;
				System.out.println("The vet was successfully eliminated");
			}
		} if (find = false) {
			System.out.println("El Id que ingreso no coincide con el de ningun veterinario");
		}
	}
	//get
	public Pet[] getPets(){
		return pets;
	}
	public Veterinary[] getVeterinarians(){
		return veterinarians;
	}
}