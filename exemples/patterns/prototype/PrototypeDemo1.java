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

    static {
        prototypes.put("tom", new Tom());
        prototypes.put("dick", new Dick());
        prototypes.put("harry", new Harry());
    }

    public static Person getPrototype(String type) {
        try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Le prototype : '" + type + "' n'existe pas");
            return null;
        }
    }
}

// ======== Client ========
public class PrototypeDemo1 {
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