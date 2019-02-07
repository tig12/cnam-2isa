public class Factorial {
    
    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        double result = factorial(input);
        System.out.println(result);
    }

    public static double factorial(int n) {
        if(n < 0) {
            return 0.0;
        }
        double fact = 1.0; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i; // fact = fact * i
        }
        return fact;
    }
}
