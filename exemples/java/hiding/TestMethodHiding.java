
public class TestMethodHiding{
    
    public static void main(String[] args){
        System.out.println(Animal.grogner());
        System.out.println(Chat.grogner());
        System.out.println(Chien.grogner());
    }
}

class Animal{
    public static String grogner(){
        return "grogner() dans Animal";
    }
}
class Chat extends Animal {
    public static String grogner(){
        return "grogner() dans Chat";
    }
}
class Chien extends Animal {
    public static String grogner(){
        return "grogner() dans Chien";
    }
}

