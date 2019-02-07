
/** Injection par interface **/

// ********** client **************
interface ServiceUser{
    public void injetcService(ServiceI service);
}

class Client4 implements ServiceUser{

    private ServiceI service;

    public void injectService(ServiceI service){
        this.service = service; // ICI injection
    }
    
    public void action(){
        System.out.println("Client.action() : " + service.doSomething());
    }
}

// ********** service **************
interface ServiceI{ public String doSomething(); }
class Service4 implements ServiceI{
    public String doSomething(){
        return this.getClass() + ".doSomething()";
    }
}

// ********** main **************
public class Test4{
    public static void main(String[] args){
        Client4 client = new Client4();
        client.setService(new Service4());
        client.action();
    }
}

