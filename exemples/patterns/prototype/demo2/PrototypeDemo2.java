/** 
    Adaptation de https://sourcemaking.com/design_patterns/prototype/java/1
**/

import java.util.Map;
import java.util.HashMap;

// ======== prototype abstrait ========
interface Person {
    Person clone();
}

// ======== prototypes concrets ========
class Tom implements Person {
    @Override public Person clone() { return new Tom(); }
    @Override public String toString() { return "instance de Tom"; }
}

class Dick implements Person {
    @Override public Person clone() { return new Dick(); }
    @Override public String toString() { return "instance de Dick"; }
}

class Harry implements Person {
    @Override public Person clone() { return new Harry(); }
    @Override public String toString() { return "instance de Harry"; }
}

// ======== Registre ========
// permet d'accéder aux instances de prototypes concrets
class Registry {
    private static final Map<String, Person> prototypes = new HashMap<>();
    
    public static Person getPrototype(String type) {
        if(!prototypes.containsKey(type)){
            switch(type){
                case "tom": 
                    prototypes.put("tom", new Tom());
                break;
                case "dick": 
                    prototypes.put("dick", new Dick());
                break;
                case "harry": 
                    prototypes.put("harry", new Harry());
                break;
                default:
                    System.out.println("Le prototype : '" + type + "' n'existe pas");
                    return null;
            }
        }
        return prototypes.get(type).clone();
    }
}

// ======== Client ========
public class PrototypeDemo2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String type : args) {
                Person prototype = Registry.getPrototype(type);
                if (prototype != null) {
                    System.out.println(prototype);
                }
            }
        }
        else {
            System.out.println("usage : java PrototypeDemo1 <proto>");
            System.out.println("avec <proto> = 'tom', 'dick' ou 'harry'");
        }
    }
}