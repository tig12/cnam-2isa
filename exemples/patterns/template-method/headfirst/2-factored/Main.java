public class Main {
    
	public static void main(String[] args) {
 
		CaffeineBeverage tea = new Tea();
		CaffeineBeverage coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
	}
}
