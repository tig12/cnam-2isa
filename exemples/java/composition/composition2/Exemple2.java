class X2{
    public void doSomething(){}
    public int work(){ return 2; }
}

class Y2{
    X2 x = new X2();
    public void work(){    
        x.doSomething();
    }
}
