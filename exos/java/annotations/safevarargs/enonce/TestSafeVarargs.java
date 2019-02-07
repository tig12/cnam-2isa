

class TestSafeVarargs{
    
    public static void main(String[] args){
        System.out.println(max(12, 3, 8, 210));
    }

    // pas besoin ici de SafeVararg car pas de type générique
    public static int max(int premier, int... lesAutres) {
        int max = premier;
        for(int i : lesAutres) {
            if (i > max) max = i;
        }
        return max;
    }
}