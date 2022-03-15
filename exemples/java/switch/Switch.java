/** 
    But : tester switch en tant qu'expression, introduit en java 14
    Voir https://docs.oracle.com/en/java/javase/14/language/switch-expressions.html
**/
class Switch {
    public static void main(String[] args) {
        
        int a = 3;
        String message = "";
        
        // switch traditionnel (statement)
        switch(a){
            case 1: message = "a vaut 1"; break;
            case 2: message = "a vaut 2"; break;
            case 3: message = "a vaut 3"; break;
            case 4: message = "a vaut 4"; break;
            default: message = "a est trop grand pour moi"; break;
        }
        System.out.println("switch traditionnel (statement) : " + message);
        
        // switch traditionnel (statement), plus compact
        switch(a){
            case 1:
            case 2:
            case 3:
            case 4: message = "a vaut " + Integer.toString(a); break;
            default: message = "a est trop grand pour moi"; break;
        }
        System.out.println("switch traditionnel (statement), plus compact : " + message);
        
        // switch nouveau (expression)
        message = switch(a){
            case 1, 2, 3, 4 -> "a vaut " + Integer.toString(a);
            default -> "a est trop grand pour moi";
        };
        System.out.println("switch nouveau : " + message);
        
        // comme switch est une expression, on pourrait aussi écrire :
        System.out.println("switch nouveau (directement dans le println) : " + switch(a){
            case 1, 2, 3, 4 -> "a vaut " + Integer.toString(a);
            default -> "a est trop grand pour moi";
        });
    }
}
