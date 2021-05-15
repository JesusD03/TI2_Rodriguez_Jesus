package model;

public class Veterinary{
	
	private String cc;
	private String name;
	private String lastName;
	private String id;
	private String status;
	private int petsAttended;

	//constructor
	public Veterinary(String cc, String name, String lastName, String id, String status){
		this.cc = cc;
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.status = status;
		this.petsAttended = 0;
	}
	//set
	public void setCc(String cc){
		this.cc = cc;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setStatus(String status){
		this.status = status;
	}
	//get
	public String getCc(){
		return cc;
	}
	public String getName(){
		return name;
	}
	public String getlastName(){
		return lastName;
	}
	public String getId(){
		return id;
	}
	public String getStatus(){
		return status;
	}
	public int getPetsAttended(){
		return petsAttended;
	}
	//toString
	public String toString(){
		String answer = "";
		return answer = "\n CC: " + cc + "\n Name: " + name + "\n Lastname: " + lastName + "\n ID: " + id + 
						"\n Status: " + status + "\n Pets he cared for:" + petsAttended;
	}

}