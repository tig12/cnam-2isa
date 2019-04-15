
interface Interface0{
    default void methode(){
        System.out.println("methode() dans Interface0");
    }
}

// cas 1
// OK ; C1 utilise l'implémentation de Interface0
interface Interface1 extends Interface0{ }
class C1 implements Interface1{}

// cas 2
// Interface2.methode() "efface" Interface0.methode()
// Donc C2 doit redéfinir methode()
interface Interface2 extends Interface0{
    void methode();
}
// erreur de compilation
// ExtendsDefault.java:19: error: C2 is not abstract and does not override abstract method methode() in Interface2
class C2 implements Interface2{}

// cas 3
// OK ; C3 utilise l'implémentation de Interface3
interface Interface3 extends Interface0{
     default void methode(){
        System.out.println("methode() dans Interface3");
    }
}
class C3 implements Interface3{}
