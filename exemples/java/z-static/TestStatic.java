
class TestStatic{
    public static void main(String[] args) {
        A a = new A();
        System.out.println("A.h = " + A.h);
        System.out.println("a.h = " + a.h);
        System.out.println("A.test() = " + A.test());
        System.out.println("a.test() = " + a.test());
    }
}

class A{
    public static int h = 137;
    public static String test(){ return "A"; }
}

