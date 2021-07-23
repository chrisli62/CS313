import java.io.*;

public class Member{
    
    String ID;
    String firstName;
    String lastName;

    public Member(String ID, String firstName, String lastName){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getID(){ 
        return ID; 
    } 

    public String getName(){ 
        String fullName = firstName + " " + lastName;
        return fullName; 
    } 

    public void setID(String ID){ 
        this.ID = ID; 
    } 

    public void setfirstName(String firstName){ 
        this.firstName = firstName; 
    } 

    public void setlastName(String lastName){ 
        this.lastName = lastName; 
    } 

}