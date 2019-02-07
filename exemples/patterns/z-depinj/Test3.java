
/** Injection par setter **/

// ********** client **************
class Client3{

    private ServiceI service;

    public void setService(ServiceI service){
        this.service = service; // ICI injection
    }
    
    public void action(){
        System.out.println("Client.action() : " + service.doSomething());
    }
}

// ********** service **************
interface ServiceI{ public String doSomething(); }
class Service3 implements ServiceI{
    public String doSomething(){
        return this.getClass() + ".doSomething()";
    }
}

// ********** main **************
public class Test3{
    public static void main(String[] args){
        Client3 client = new Client3();
        client.setService(new Service3());
        client.action();
    }
}

