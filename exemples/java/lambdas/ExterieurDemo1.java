
class ExterieurDemo1 {
    public static void main(String args[]) {
        String str = "Hello World!";
        // Utilise str, déclarée hors de la lambda
        Runnable r = () -> System.out.println(str);
        r.run();
    }
}
