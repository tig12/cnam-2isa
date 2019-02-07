
import java.util.List;
import java.util.ArrayList;

// ===== the Caretaker =====
class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
 
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        savedStates.add(originator.saveToMemento());
        originator.setState("State3");
        // We can request multiple mementos, and choose which one to roll back to.
        savedStates.add(originator.saveToMemento());
        originator.setState("State4");
 
        originator.restoreFromMemento(savedStates.get(1));  
    }
}

