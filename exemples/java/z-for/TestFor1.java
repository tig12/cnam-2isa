class TestFor1{

    /** Aucune différence constatée entre i++ et ++i */
    public static void main(String[] args) {

        System.out.println("Boucle i++");
        for(int i = 0; i < 3; i++){
            System.out.println("  début i = " + i);
            System.out.println("    fait des choses");
            System.out.println("  fin i = " + i);
        }

        System.out.println("Boucle ++i");
        for(int i = 0; i < 3; ++i){
            System.out.println("  début i = " + i);
            System.out.println("    fait des choses");
            System.out.println("  fin i = " + i);
        }
    }
}

