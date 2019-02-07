/** 
    Adaptation de https://sourcemaking.com/design_patterns/builder/java/2
**/

// =============== Product ===============
class Pizza {
    private String name = "";
    private String pate = "";
    private String sauce = "";
    private String garniture = "";
    
    public Pizza(String name){
        this.name = name;
    }
    public void setPate(String pate) { this.pate = pate; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setGarniture(String garniture) { this.garniture = garniture; }
    
    @Override
    public String toString(){
        return "Pizza " + this.name
            + "\n    pâte : " + this.pate
            + "\n    sauce : " + this.sauce
            + "\n    garniture : " + this.garniture;
    }
}

// =============== Abstract Builder ===============
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct(){}
    public void buildPate(){}
    public void buildSauce(){}
    public void buildGarniture(){}
}


// =============== Concrete Builders ===============
class BlanchePizzaBuilder extends PizzaBuilder {
    public void createNewPizzaProduct() {
        pizza = new Pizza("Blanche");
    }
    public void buildPate() { pizza.setPate("pâte feuilletée"); }
    public void buildSauce() { pizza.setSauce("sauce blanche"); }
    public void buildGarniture() { pizza.setGarniture("poireaux+mozarella+bleu de bresse"); }
}

class SiciliennePizzaBuilder extends PizzaBuilder {
    public void createNewPizzaProduct() {
        pizza = new Pizza("Sicilienne");
    }
    public void buildPate() { pizza.setPate("pâte à pizza"); }
    public void buildSauce() { pizza.setSauce("sauce tomate"); }
    public void buildGarniture() { pizza.setGarniture("mozarella+anchois+olives"); }
}

class MontagnardePizzaBuilder extends PizzaBuilder {
    public void createNewPizzaProduct() {
        pizza = new Pizza("Montagnarde");
    }
    public void buildPate() { pizza.setPate("pâte à pizza"); }
    public void buildSauce() { pizza.setSauce("sauce blanche"); }
    public void buildGarniture() { pizza.setGarniture("sanglier+fromage de chêvre"); }
}

// =============== Director ===============
class PizzaDirector {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildPate();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildGarniture();
    }
}

// =============== Client ===============
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        
        PizzaDirector pizzaDirector = new PizzaDirector();
        
        PizzaBuilder blanchePizzabuilder = new BlanchePizzaBuilder();
        PizzaBuilder siciliennePizzaBuilder = new SiciliennePizzaBuilder();
        PizzaBuilder montagnardePizzaBuilder = new MontagnardePizzaBuilder();

        pizzaDirector.setPizzaBuilder( blanchePizzabuilder );
        pizzaDirector.constructPizza();
        Pizza pizza1 = pizzaDirector.getPizza();
        System.out.println(pizza1);
        
        pizzaDirector.setPizzaBuilder( siciliennePizzaBuilder );
        pizzaDirector.constructPizza();
        Pizza pizza2 = pizzaDirector.getPizza();
        System.out.println(pizza2);
        
        pizzaDirector.setPizzaBuilder( montagnardePizzaBuilder );
        pizzaDirector.constructPizza();
        Pizza pizza3 = pizzaDirector.getPizza();
        System.out.println(pizza3);
    }
}
