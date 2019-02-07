package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        // déclarer p1
        // déclarer p2

        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
            // p1.empiler(new PolygoneRegulier(5,100)); // désormais une erreur de
            // compilation
            // ....
            // String s = (String)p1.depiler(); // désormais une erreur de
            // compilation
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}