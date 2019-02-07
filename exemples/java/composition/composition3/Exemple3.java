class X1{
    public int doSomething(){
        return 3;
    }    
}

class Y1{
    private X1 x1 = new X1();
    public int doSomething(){
        return x1.doSomething();
    }
}

class Exemple3{
    public static void main(String[] args){
        Y1 y1 = new Y1();
        int test = y1.doSomething();
    }
}
