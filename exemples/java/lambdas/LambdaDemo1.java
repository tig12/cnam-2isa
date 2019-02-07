

public class LambdaDemo1{

    public static void main(String args[]) {
    
        MathOperation addition = (a, b) -> a + b; // syntaxe la plus concise
        MathOperation soustraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        MathOperation division = (int a, int b) -> a / b;
        
        // la ligne suivante ne passe pas à la compilation
        // int test = addition(3, 4);
        
        System.out.println("3 + 4 = " + addition.operation(3, 4));
        System.out.println("3 - 4 = " + soustraction.operation(3, 4));
        System.out.println("3 * 4 = " + multiplication.operation(3, 4));
        System.out.println("3 / 4 = " + division.operation(3, 4)); // attention, division entière
    }

    // on définit l'interface fonctionnelle comme une classe interne,
    // mais on aurait pu la définir à l'extérieur
    @FunctionalInterface
    private interface MathOperation {
        int operation(int a, int b);
    }
}
