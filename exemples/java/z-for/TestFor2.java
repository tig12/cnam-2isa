class TestFor2{

    /**
     * a = i++ et a = ++i se comportent comme attendu
    */
    public static void main(String[] args) {

        int a;
        
        System.out.println("Boucle i++");
        a = 0;
        for(int i = 0; i < 4; a = i++){
            System.out.println("  i = " + i + " ; a = " + a);
        }
        
        System.out.println("\nBoucle ++i");
        a = 0;
        for(int i = 0; i < 4; a = ++i){
            System.out.println("  i = " + i + " ; a = " + a);
        }
    }
}

