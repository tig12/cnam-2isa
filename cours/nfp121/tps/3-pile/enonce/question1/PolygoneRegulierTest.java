package question1;

public class PolygoneRegulierTest extends junit.framework.TestCase {
    private PolygoneRegulier p1;
    private PolygoneRegulier p2;
    private PolygoneRegulier p3;

    public void setUp() {
        p1 = new PolygoneRegulier(4, 100);
        p2 = new PolygoneRegulier(5, 100);
        p3 = new PolygoneRegulier(4, 100);
    }

    /*
     * la règle : Objects that are equal according to the equals method must
     * return the same hashCode value If two objects are not equal according to
     * equals, they are not required to return different hashCode values. voir
     * http://java.sun.com/j2se/1.5/docs/api/java/lang/Object.html#hashCode()
     */

    public void testEquals_hashCode() {
        assertFalse(p1.equals(p2));

        assertTrue(p1.equals(p3));
        assertTrue(p3.equals(p1));
        assertEquals(p1.hashCode(), p3.hashCode());
    }
}
