package hr.atos.praksa.mihaelspanovic.zadatak15;


import java.io.Serializable;

@SuppressWarnings("serial")
class Employee implements Serializable{

	String name;
	String lastname;
	String workplace;
	int oib;
	
	public Employee(String name, String lastname, String workplace,int oib)
	{
		this.name = name;
		this.lastname = lastname;
		this.workplace = workplace;
		this.oib = oib;
	}
	
	public String toString()
	{
		return "\nEmployee Details :" + "\nName: " + this.name + "\nLast Name: " + 
				this.lastname + "\nWorkplace: " + this.workplace + "\nOIB: " + this.oib;
	}
	
}

