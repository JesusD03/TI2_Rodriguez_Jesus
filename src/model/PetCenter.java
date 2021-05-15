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
			if(Pet[i] == null){
				Pet[i] = new Pet(name, age, specie, owner, symptoms, priority, order);
				empty = true;
				order ++;
				System.out.print("the pet was added successfully");
			}
		}
	}
	public void removePet(String name, String idNumber){
		boolean find = false;
		for(int i = 0; i < MAX_PETS && !find; i++){
			if ((pets[i] != null && pets[i].getName().equalsIgnoreCase(name)) && (pets[i].getOwner() != null && pets[i].getOwner().getIdNumber())) {
				pets[i].getStatus() = Status.SALIDA_SIN_ATENCION;
				find = true;
				System.out.println("La mascota fue removida de la cola");
			}
		} if (find == false) {
			System.out.println("La mascota no pudo ser retirada porque no se encuentra en espera de ser atendida");
		}
	}
	public void addVeterinary(String cc, String name, String lastName, String id, String status){
		boolean empty = false;
		for(int i = 0; i < MAX_VETERINARIANS && !empty; i++){
			if(Veterinary[i] == null){
				Veterinary[i] = new Veterinary(cc, name, lastName, id, status);
				empty = true;
				System.out.println("The vet was successfully added");
			}
		} if (empty == false) {
			System.out.println("No se puedo agregar el veterinario porque se llego al maximo");
		}
	}
	public void deleteVeterinary(String id){
		boolean find = false;
		for(int i = 0; i < MAX_VETERINARIANS && !find; i++){
			if(veterinary[i] != null && veterinary[i].getId().equalsIgnoreCase(id)){
				find = true;
				veterinary[i] = null;
				System.out.println("El veterinario fue eliminado con exito");
			}
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