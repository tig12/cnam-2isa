package project1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Project1Test{

    @Test
    void myFirstTest() {
        Project1 p1 = new Project1();
        assertEquals(p1.return2(), 2);
    }
    
}