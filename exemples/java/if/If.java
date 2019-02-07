
public class If{

    public static void main(String[] args){
        int i = 2, j = 2, k = 3;
        if(i == j)
            if(i == k)
                System.out.println("i égal k");
        else
            System.out.println("i différent de j"); // PAS BON
    }

}

