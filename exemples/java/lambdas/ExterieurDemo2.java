
class ExterieurDemo2 {
    public static void main(String args[]) {
        String str = "Hello World!";
        str = "Salut"; // Ici on modifie str, qui n'est plus "effectively final"
        Runnable r = () -> System.out.println(str);
        r.run();
    }
}
