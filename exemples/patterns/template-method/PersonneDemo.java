
import static java.lang.System.out;

// ========== Classe abstraite ==========
abstract class Personne{

    // structure commune à toutes les personnes
    public void passeUneJournee(){
        out.println("\n === journee " + this.getClass().getName() + " ===");
        reveil();
        petitDej();
        passeLaMatinee();
        dejeuner();
        passeLaprem();
        diner();
        relax();
        dort();
    }
    
    protected void reveil(){ out.println("reveil"); } // partie invariante
    protected abstract void petitDej();
    protected abstract void passeLaMatinee();
    protected abstract void dejeuner();
    protected abstract void passeLaprem();
    protected abstract void diner();
    protected abstract void relax();
    protected void dort(){ out.println("dort"); } // partie invariante
}

// ========== Classes concrète ==========
class Enfant extends Personne{
    protected void petitDej(){ out.println("petit dej enfant"); }
    protected void passeLaMatinee(){ out.println("matinee enfant"); }
    protected void dejeuner(){ out.println("dejeuner enfant"); }
    protected void passeLaprem(){ out.println("aprem enfant"); }
    protected void diner(){ out.println("diner enfant"); }
    protected void relax(){ out.println("relax enfant"); }
}

abstract class Travaileur extends Personne{
    protected void petitDej(){ out.println("petit dej travailleur"); }
    protected void dejeuner(){ out.println("dejeuner travailleur"); }
    protected void diner(){ out.println("diner travailleur"); }
    protected void relax(){ out.println("relax travailleur"); }
}

class TravaileurADomicile extends Travaileur{
    protected void passeLaMatinee(){ out.println("matinee travailleur à domicile"); }
    protected void passeLaprem(){ out.println("aprem travailleur à domicile"); }
}

class TravaileurAuBureau extends Travaileur{
    protected void passeLaMatinee(){ out.println("matinee travailleur au bureau"); }
    protected void passeLaprem(){ out.println("aprem travailleur au bureau"); }
    protected void relax(){ out.println("relax travailleur au bureau"); }
}

// ========== Client ==========
public class PersonneDemo{

    public static void main(String[] args){
        Personne p1 = new Enfant();
        p1.passeUneJournee();
        Personne p2 = new TravaileurAuBureau();
        p2.passeUneJournee();
        Personne p3 = new TravaileurADomicile();
        p3.passeUneJournee();
    }

}
