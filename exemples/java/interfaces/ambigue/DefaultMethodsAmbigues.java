
/** 
    Tests sur les defaults methods :
    Que se passe-t-il si une classe implémente 2 interfaces
    définissant une même default method ?
**/

interface Interface1{
    default void method1(){
        System.out.println("Interface1.method1()");
    }
}
interface Interface2{
    default void method1(){
        System.out.println("Interface2.method1()");
    }
}

/* 
Ne passe pas à la compilation :
DefaultMethods.java:23: error: class C1 inherits unrelated defaults for method1() from types Interface1 and Interface2
*/
class C1 implements Interface1, Interface2{}

/*
   Compilation OK
   L'implémentation résout l'ambiguïté
*/
class C2 implements Interface1, Interface2{
    public void method1(){}
}

