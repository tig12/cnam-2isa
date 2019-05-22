public class Main {
    
	public static void main(String[] args) {
  
		CaffeineBeverageWithHook tea = new TeaWithHook();
		CaffeineBeverageWithHook coffee = new CoffeeWithHook();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
	}
}
