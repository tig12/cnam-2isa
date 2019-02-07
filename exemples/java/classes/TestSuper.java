
public class TestSuper {
    public static void main(String[] args) {
        var obj = new SousClasse();
        obj.instanceMethod();
    }
}


class SuperClasse {
    public void instanceMethod() {
        System.out.println("SuperClasse.instanceMethod()");
    }
}

class SousClasse extends SuperClasse {
    @Override
    public void instanceMethod(){
        System.out.println("SousClasse.instanceMethod()");
        super.instanceMethod();
    }
}

