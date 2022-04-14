/** 
    Pour voir si le compilateur affiche un warning en cas d'oubli de @Override.
    Réponse : non
**/


interface I1{
    void method1(); // implicitement public
}

class TestOverride implements I1 {
    public void method1(){}
}