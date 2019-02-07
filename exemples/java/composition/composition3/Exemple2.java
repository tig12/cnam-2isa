class X1{    
    public String doSomething(){
        return "doSomething";
    }    
}

class Y1 extends X1{}

class Exemple2{
    public static void main(String[] args){
        Y1 y1 = new Y1();
        int test = y1.doSomething();
    }
}
