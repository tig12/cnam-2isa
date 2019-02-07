
public class TestOverriding{
    
    public static void main(String[] args){
        Animal[] animaux = {
            new Chien(),
            new Chat()
        };
        for(Animal a : animaux){
            System.out.println(a.grogner());
        }
    }
}

class Animal{
    public String grogner(){
        return "grogner() dans Animal";
    }
}
class Chat extends Animal {
    @Override
    public String grogner(){
        return "grogner() dans Chat";
    }
}
class Chien extends Animal {
    @Override
    public String grogner(){
        return "grogner() dans Chien";
    }
}

