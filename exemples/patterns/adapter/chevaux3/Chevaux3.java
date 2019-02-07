/** 
    Chevaux 3 : adapter utilisant la composition
**/


public class Chevaux3{
    
    public static void main(String[] args){
        Cheval[] chevaux = {
            new ChevalDeCamargue(),
            new ChevalArabe(),
            new PoneyShetland(),
            new AneAdapter(new Ane()),
        };
        for(Cheval cheval : chevaux){
            cheval.hennir();
        }
    }
    
}


interface Cheval{
    public void hennir();
}

class ChevalDeCamargue implements Cheval{
    public void hennir(){
        System.out.println("hiiiiiiii");
    }
}

class ChevalArabe implements Cheval{
    public void hennir(){
        System.out.println("hiiiii");
    }
}

class PoneyShetland implements Cheval{
    public void hennir(){
        System.out.println("hi");
    }
}

class Ane{
    public void braire(){
        System.out.println("hi han");
    }
}

class AneAdapter implements Cheval{
    
    private Ane ane;
    
    public AneAdapter(Ane ane){
        this.ane = ane;
    }
    
    public void hennir(){
        ane.braire();
    }
}


