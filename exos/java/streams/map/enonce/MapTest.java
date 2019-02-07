import java.util.*;
import java.io.*;

class Person{
    
    private String firstname, lastname, birthdate, slug;
    
    public Person(String firstname, String lastname, String birthdate){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        computeSlug();
    }
    
    private void computeSlug(){
        List<String> fields = new LinkedList<>();
        fields.add(firstname);
        fields.add(lastname);
        this.slug = String.join("-", fields).toLowerCase();
    }
    
    public String getSlug(){ return this.slug; }
    
    @Override public String toString(){
        return "[ " + firstname + ", " + lastname + ", " + birthdate + " ]";
    }
}


/** Code client **/
public class MapTest{
    
    public static void main(String[] args){
        /* 
        // Indications : vous pouvez utiliser ce code :
        BufferedReader reader = new BufferedReader(new FileReader("persons.csv"))
        // et utiliser
        reader.readLine()
        */
    }
}


