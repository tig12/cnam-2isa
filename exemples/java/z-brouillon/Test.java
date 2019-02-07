class Test{
    public static void main(String[] args) {
        //testCurrency();
        //testMultipleAffectation();
        //testChar();
        //testHexa();
        //testPortée();
        //testIf();
        //testPrint();
        //testContinue();
        //testPassByValue();
        //testArray();
        //testCopy();
        testEqual();
    }

    public static void testEqual(){
        String s = "hello";
        String letter = "o";
        String t = "hell" + letter;
        System.out.println("avec == \t" + (s == t ? "equal" : "not equal"));
        System.out.println("avec equals \t" + (s.equals(t) ? "equal" : "not equal"));
    }

    public static void testCopy(){
        int a = 42;
        int b = a;
        a = 43;
        System.out.println(a);
        System.out.println(b);
    }

    public static void testArray(){
        int[][] t = new int[10][];
        for(int i = 0; i < t.length; i++){
            t[i] = new int[i];
            for(int j = 0; j < t[i].length; j++){
                //System.out.println("i = " + i + " - j = " + j);
            }
            //System.out.println();
        }
        int[][] products = {
                {0, 0, 0, 0, 0},
                {0, 1, 2, 3, 4},
                {0, 4, 8, 12, 16},
        };

    }
    public static void testPassByValue(){
        int a = 10;
        passByValue(a);
        System.out.println("a = " + a);

    }
    private static void passByValue(int a){
        a = 11;
    }

    public static void testContinue(){
        iloop: for(int i=0; i < 10; i++){
            for(int j=0; j < 10; j++){
                System.out.println("i = " + i + " - j = " + j);
                if(j > 2){
                    continue iloop;
                }
            }
        }
    }

    public static void testPrint(){
        System.out.println("Quotient : " + 7/3.0f);  // Quotient : 2.3333333
        System.out.println("Somme : " + 7 + 3);  // Somme : 73
        System.out.println("Somme : " + (7 + 3));  // Somme : 10
    }

    public static void testCurrency(){
        int $a = 12;
        System.out.println("$a = " + $a);
        int $18 = 13;
        System.out.println("$18 = " + $18);
        int a£b = 14;
        System.out.println("a£b = " + a£b);
    }
    
    public static void testMultipleAffectation(){
        int i = 12, d = 13;
        System.out.println("i = " + i + " - d = " + d);
    }

    public static void testChar(){
        char aleph = '\u0500';
        System.out.println("aleph = " + aleph);
    }

    public static void testHexa(){
        int h1 = 0xff;
        long h2 = 0xffL;
        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);
    }

    public static void testPortée(){
        int i = 0;
        while(i < 10){
            int j = 0;
            i++;
        }
        System.out.println(i); // 10
        //System.out.println(j); // erreur, car j n'est plus définie hors de son bloc de définition
    }

    public static void testIf(){
        int i = 0, j = 1, k = 1;
        if(i == j)
            if(i == k)
                System.out.println("i égal k");
        else
            System.out.println("i différent de j"); // pas bon
    }


}

