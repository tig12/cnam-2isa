
/** 
    Illustre la possibilité de l'héritage multiple pour les interfaces
**/

interface I1 {
    void m1();
}
interface I2 {
    void m2();
}
interface I3 extends I1, I2 {
}

class C implements I3 {
    public void m1() { System.out.println("m1");}
    public void m2() { System.out.println("m2");}
}

class Main {
    public static void main(String[] args){
        var c = new C();
        c.m1();
        c.m2();
    }
}
