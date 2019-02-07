
import junit.framework.Assert;

public class CompteurTest extends junit.framework.TestCase {

    public void test1() {
        Compteur c = new Compteur();
        assertEquals(c.getCompte(), 0);
    }

    public void test2() {
        try{
            Compteur c = new Compteur(2);
            assertEquals(c.getCompte(), 2);
        }
        catch(CustomException e){
        }
    }
    
    public void test3() {
        Compteur c = new Compteur();
        try{
            c.ajoute(4);
        }
        catch(CustomException e){
        }
        assertEquals(c.getCompte(), 4);
    }

    public void test4() {
        Compteur c = new Compteur();
        try{
            c.ajoute(-4);
            Assert.fail();
        }
        catch(CustomException e){
            // test réussi
        }
    }

}