/** 
    Adaptation de l'exemple https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern#Java_example
    @history    2018-02-05 17:36:42+01:00 Creation
**/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WikipediaDemo {

    // ======= Client =======
    public static void main(String[] args) {
        
        // create chain of responsability
        PurchasePower manager = new Manager();
        PurchasePower director = new Director();
        PurchasePower vp = new VicePresident();
        PurchasePower president = new President();
        PurchasePower nobody = new Nobody();
        
        manager.setSuccessor(director);                                                
        director.setSuccessor(vp);
        vp.setSuccessor(president);
        president.setSuccessor(nobody);

        System.out.println("Purchase power limits :");
        System.out.println("-----------------------");
        System.out.println(manager.getRole() + " : " + manager.getAllowable());
        System.out.println(director.getRole() + " : " + director.getAllowable());
        System.out.println(vp.getRole() + " : " + vp.getAllowable());
        System.out.println(president.getRole() + " : " + president.getAllowable());
        System.out.println("-----------------------");
        
        System.out.println("\nPress Ctrl+C to end.");
        
        while (true) {
            System.out.println("\nEnter the amount to check who should approve your expenditure.");
            System.out.print("> ");
            try {
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.handleRequest(new PurchaseRequest(d));
            }
            catch (Exception e) {
                System.out.println("Invalid amount.");
            }
        }
    }
}

// ======= Abstract handler =======
abstract class PurchasePower {
    protected static final double BASE = 100;
    protected PurchasePower successor;

    abstract protected double getAllowable();
    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    public void handleRequest(PurchaseRequest request) {
        if (request.getAmount() < this.getAllowable()) {
            System.out.println(this.getRole() + " will approve " + request.getAmount() + " $");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// ======= Concrete handlers =======
class Manager extends PurchasePower {
    protected double getAllowable() { return BASE * 10; }
    protected String getRole() { return "Manager"; }
}

class Director extends PurchasePower {
    protected double getAllowable() { return BASE * 20; }
    protected String getRole() { return "Director"; }
}

class VicePresident extends PurchasePower {
    protected double getAllowable() { return BASE * 40; }
    protected String getRole() { return "Vice President"; }
}

class President extends PurchasePower {                                       
    protected double getAllowable() { return BASE * 60; }
    protected String getRole() { return "President"; }
}

class Nobody extends PurchasePower {
    protected double getAllowable() { return Double.MAX_VALUE; }
    protected String getRole() { return "Nobody"; }
}

// ======= Request object =======
class PurchaseRequest {
    private double amount;
    public PurchaseRequest(double amount) { this.amount = amount; }
    public double getAmount() { return this.amount; }
    public void setAmount(double amount)  { this.amount = amount; }
}
