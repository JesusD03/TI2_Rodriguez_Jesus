	package model;

public class Pet{
	private String name;
	private int age;
	private String symptoms;
	private int order;
	private String race;
	//relationships
	private Veterinary veterinary;
	private Specie specie;
	private Priority priority;
	private Owner owner;
	private Status status;
	//construsctor
	public Pet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority, int order){
		this.name = name;
		this.age = age;
		this.specie = specie;
		this.owner = owner;
		this.symptoms = symptoms;
		this.priority = priority;
		this.order = order;
		status = Status.ESPERANDO_SER_ATENDIDO;
	}
	public Pet(String name, int age, Specie specie, Owner owner, String symptoms, Priority priority, int order, String race){
		this.name = name;
		this.age = age;
		this.specie = specie;
		this.owner = owner;
		this.symptoms = symptoms;
		this.priority = priority;
		this.order = order;
		this.race = race;
		status = Status.ESPERANDO_SER_ATENDIDO;
	}
	//set
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setSymptoms(String symptoms){
		this.symptoms = symptoms;
	}
	public void setSpecie(Specie specie){
		this.specie = specie;
	}
	public void setPriority(Priority priority){
		this.priority = priority;
	}
	public void setOwner(Owner owner){
		this.owner = owner;
	}
	public void setStatus(Status status){
		this.status = status;
	}
	public void setRace(String race){
		this.race = race;
	}
	public void setVeterinery(Veterinary veterinary){
		this.veterinary = veterinary;
	}
	//get
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getSymptoms(){
		return symptoms;
	}
	public int getOrder(){
		return order;
	}
	public Specie getSpecie(){
		return specie;
	}
	public Priority getPriority(){
		return priority;
	}
	public Owner getOwner(){
		return owner;
	}
	public Status getStatus(){
		return status;
	}
	public String getRace(){
		return race;
	}
	public Veterinary getVeterinary(){
		return veterinary;
	}
	//toString
	public String toString(){
		String answer = "";
		return answer = "\nName: " + name + "\nAge: " + age + "\nSymptoms: " + symptoms + "\nArrival order: " +
						order + "\nSpecie: " + specie + "\nPriority: " + priority + "\nOwner: " + owner.toString() +
						"\nPet Status: " + status;
	}
}