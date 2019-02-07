    

public class Main {
    
    /** 
        Doit être appelée avec un paramètre, qui peut valoir "count" ou "normal"
    **/
	public static void main(String[] args) {
	    String usage = "Utilisation : java Main <paramètre>\n<paramètre> peut prendre comme valeur \"normal\" ou \"count\"\n";
	    // parameter checking
	    if(args.length != 1){
	        System.out.println(usage);
	        System.exit(0);
	    }
	    if(!args[0].equals("normal") && !args[0].equals("count")){
	        System.out.println(usage);
	        System.out.println("Mauvaise valeur du paramètre : " + args[0]);
	        System.exit(0);
	    }
	    
	    DuckSimulator simulator = new DuckSimulator();
	    AbstractQuackableFactory factory;
	    
	    if(args[0].equals("normal")){
	        factory = new NormalQuackableFactory();
	    }
	    else{
	        factory = new CountingQuackableFactory();
	    }
	    
	    simulator.simulate(factory);
	}
	
}
