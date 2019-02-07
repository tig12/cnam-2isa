/** 
    Illustre le comportement de == et equals()
**/
public class Equals1{
    public static void main(String[] args){
        String s1 = "abc", s2 = "def";; // noter initialisations multiples pour des variables de même type
        String s3 = s1 + s2;
        String s4 = "abcdef";
        System.out.println("s3 == s4 : " + (s3 == s4) );
        System.out.println("s3.equals(s4) : " + s3.equals(s4) );
        System.out.println("s4.equals(s3) : " + s4.equals(s3) );
    }
}
