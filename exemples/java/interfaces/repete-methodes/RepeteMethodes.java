/* 
    Teste si un conflit apparaît lorsque une classe implémente
    deux interfaces déclarant chacune la même méthode
    sans default implementation.
    
    Résultat : pas de problème.
*/

interface Interface1{
    public void methode();
}
interface Interface2{
    public void methode();
}

class RepeteMethodes implements Interface1, Interface2{
    public void methode(){
        System.out.println("RepeteMethodes.methode()");
    }
}
