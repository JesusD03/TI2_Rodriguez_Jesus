package model;

public class PetCenter{
	public int MAX_VETERINARIANS = 7;
	public int MAX_PETS = 120;
	private int order = 1;
	//relationships
	private Pet[] pets;
	private Veterinary[] veterinarians;
	//constructor
	public PetCenter(){
		pets = new Pet[MAX_PETS];
		veterinarians = new Veterinary[MAX_VETERINARIANS];
	}
	public String addPet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority){
		boolean empty = false;
		String answer = "";
		for(int i = 0; i < MAX_PETS && !empty; i++){
			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, owner, symptoms, priority, order);
				empty = true;
				order ++;
				answer = "the pet was added successfully\n";
			}
		} if (empty == false) {
			answer = "No se pudo agregar la mascota porque se llego a la capacidad maxima\n";
		}
		return answer;
	}
	public String addPet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority, String race){
		boolean empty = false;
		String answer = "";
		for(int i = 0; i < MAX_PETS && !empty; i++){
			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, owner, symptoms, priority, order, race);
				empty = true;
				order ++;
				answer = "the pet was added successfully\n";
			}
		} if (empty == false) {
			answer = "No se pudo agregar la mascota porque se llego a la capacidad maxima\n";
		}
		return answer;
	}
	public String removePet(String name, String idNumber){
		boolean find = false;
		String answer = "";
		for(int i = 0; i < MAX_PETS && !find; i++){
			if ((pets[i] != null && pets[i].getName().equalsIgnoreCase(name)) && (pets[i].getOwner() != null && pets[i].getOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
				pets[i].setStatus(Status.SALIDA_SIN_ATENCION);
				find = true;
				answer = "The pet was removed from the tail\n";
			}
		} if (find == false) {
			answer = "The pet could not be removed because it is not waiting to be treated\n";
		}
		return answer;
	}
	public String addVeterinary(String cc, String name, String lastName, String id, String status){
		boolean empty = false;
		String answer = ""; 
		for(int i = 0; i < MAX_VETERINARIANS && !empty; i++){
			if(veterinarians[i] == null){
				veterinarians[i] = new Veterinary(cc, name, lastName, id, status);
				empty = true;
				answer = "The vet was successfully added\n";
			}
		} if (empty == false) {
			answer = "Could not add vet because max was reached\n";
		}
		return answer;
	}
	public String deleteVeterinary(String id){
		boolean find = false;
		String answer = "";
		for(int i = 0; i < MAX_VETERINARIANS && !find; i++){
			if(veterinarians[i] != null && veterinarians[i].getId().equalsIgnoreCase(id)){
				find = true;
				veterinarians[i] = null;
				answer = "The vet was successfully eliminated\n";
			}
		} if (find == false) {
			answer = "El Id que ingreso no coincide con el de ningun veterinario\n";
		}
		return answer;
	}
	//get
	public Pet[] getPets(){
		return pets;
	}
	public Veterinary[] getVeterinarians(){
		return veterinarians;
	}
}