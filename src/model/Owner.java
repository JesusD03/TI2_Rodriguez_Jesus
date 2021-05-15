package model;

public class Owner{
	private String idNumber;
	private String name;
	private String phone;
	private String address;
	//constructor
	public Owner(String idNumber, String name, String phone, String address){
		this.idNumber = idNumber;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	//set
	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setAddress(String address){
		this.address = address;
	}
	//get
	public String getIdNumber(){
		return idNumber;
	}
	public String getName(){
		return name;
	}
	public String getPhone(){
		return phone;
	}
	public String getAddress(){
		return address;
	}
	//toString
	public String toString(){
		String answer = "";
		return answer = "\n ID: " + idNumber + "\n Name: " + name + "\n Phone: " + phone + 
						"\n Address: " + address;
	}
}