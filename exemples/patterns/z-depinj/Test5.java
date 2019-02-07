
/** Service locator **/

// ********** client **************
class Client5{

    private ServiceI service;

    public void injectService(ServiceI service){
        this.service = service; // ICI injection
    }
    
    public void action(){
        System.out.println("Client.action() : " + service.doSomething());
    }
}

// ********** service locator **************
// implémenté comme un singleton
class ServiceLocator{
    // singleton stuff
    private _instance = null;
    private ServiceLocator(){}
    public static ServiceLocator getInstance(){
        if(_instance == null){
            _instance = new ServiceLocator();
            return _instance;
        }
    }
    
    // ServiceLocator stuff
    public static ServiceI getServiceI(){
        
    }
}

// ********** service **************
interface ServiceI{ public String doSomething(); }
class Service5 implements ServiceI{
    public String doSomething(){
        return this.getClass() + ".doSomething()";
    }
}

// ********** main **************
public class Test5{
    public static void main(String[] args){
        Client5 client = new Client5();
        client.setService(new Service5());
        client.action();
    }
}

