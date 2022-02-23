package zadatak15;

public class Employee {
    
    String name;
    String last_name;
    String workplace;
    String oib;
    public String lastname;

    public Employee(){

    }
    
    public Employee(String name, String last_name, String workplace, String oib) {
        this.name = name;
        this.last_name = last_name;
        this.workplace = workplace;
        this.oib = oib;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getWorkplace() {
        return workplace;
    }


    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }


    public String getOib() {
        return oib;
    }


    public void setOib(String oib) {
        this.oib = oib;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
