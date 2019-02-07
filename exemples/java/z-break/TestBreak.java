class TestBreak{
    public static void main(String[] args) {
        l:for(int i=0; i < 4; i++){
        System.out.println("i = " + i);
            for(int j=0; j < 4; j++){
                System.out.println("  j = " + j);
                switch(j){
                    case 2:
                        System.out.println("    case j = 2");
                        //break l;      // erreur compilation
                        //continue l;   // erreur compilation
                    break l;
                }
            }
            System.out.println("fin boucle j");
        }
        System.out.println("fin boucle i");
    }
}

