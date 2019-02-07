class X1{    
    public void doSomething(){ }    
    public int work(){ return 2; }
}

class Y1 extends X1{
    public void work(){    
        doSomething();
    }
}
