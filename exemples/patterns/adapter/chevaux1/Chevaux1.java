/** 
    Chevaux 1 : sans adapter
**/


public class Chevaux1{
    
    public static void main(String[] args){
        Cheval[] chevaux = {
            new ChevalDeCamargue(),
            new ChevalArabe(),
            new PoneyShetland(),
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

