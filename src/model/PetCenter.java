package model;

public class PetCenter{
	public int MAX_VETERINARIANS = 7;
	public int MAX_PETS = 120;
	//relationships
	private Pet[] pets = new Pet[MAX_PETS];
	private Veterinary[] veterinarians = new Veterinary[MAX_VETERINARIANS];
	//constructor
	public PetCenter(){
		
	}
	public void addPet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority, int order){
		boolean empty = false;
		for(int i = 0; i < MAX_PETS && !empty; i++){
			if(Pet[i] == null){
				Pet[i] = new Pet(name, age, specie, owner, symptoms, priority, order);
				empty = true;
				System.out.print("the pet was added successfully");
			}
		}
		if(empty == false){

		}
	}
	public void addVeterinary(String cc, String name, String lastName, String id, String status){
		boolean empty = false;
		for(int i = 0; i < MAX_VETERINARIANS && !empty; i++){
			if(Veterinary[i] == null){
				Veterinary[i] = new Veterinary(cc, name, lastName, id, status);
				empty = true;
				System.out.print("The vet was successfully added");
			}
		}
		if(empty == false){

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