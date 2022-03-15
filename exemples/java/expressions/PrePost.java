/** 
    But : observer le comportement de ++i ou i++
**/
class PrePost{
    
    public static void main(String[] args) {
        int a = 10;
        System.out.println("a++ \t: " + a++); //10
        System.out.println("a++ \t: " + a);  // 11
        System.out.println("++a \t: " + ++a);  // 12
    }
}
