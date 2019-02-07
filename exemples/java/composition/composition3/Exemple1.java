class X1{
    public int doSomething(){
        return 3;
    }    
}

class Y1 extends X1{}

class Exemple1{
    public static void main(String[] args){
        Y1 y1 = new Y1();
        int test = y1.doSomething();
    }
}
