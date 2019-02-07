
/** Injection par constructeur **/

// ********** client **************
class Client2{

    private ServiceI service;

    public Client2(ServiceI service) {
        this.service = service; // ICI injection
    }

    public void action(){
        System.out.println("Client.action() : " + service.doSomething());
    }
}

// ********** service **************
interface ServiceI{ public String doSomething(); }
class Service2 implements ServiceI{
    public String doSomething(){
        return this.getClass() + ".doSomething()";
    }
}

// ********** main **************
public class Test2{
    public static void main(String[] args){
        Client2 client = new Client2(new Service2());
        client.action();
    }
}

