
/** Pas d'injection de dépendance **/

// ********** client **************
class Client1{

    private ServiceI service;

    public Client1() {
        service = new Service1(); // ICI le client choisit
    }

    public void action(){
        System.out.println("Client.action() : " + service.doSomething());
    }
}

// ********** service **************
interface ServiceI{ public String doSomething(); }
class Service1 implements ServiceI{
    public String doSomething(){
        return this.getClass() + ".doSomething()";
    }
}

// ********** main **************
public class Test1{
    public static void main(String[] args){
        Client1 client = new Client1();
        client.action();
    }
}

