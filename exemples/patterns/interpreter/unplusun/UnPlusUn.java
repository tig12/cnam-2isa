
/** 
    Exemple d'interpréteur
    Exemple d'utilisation : java "un plus deux"
    (ne pas oublier les guillemets afin que le programme n'ait en entrée q'un seul argument).
**/
public class UnPlusUn{

    public static void main(String[] args) {
        
        // Vérification des paramètres
        String usage = "Utilisation : java UnPlusUn <expression>\nExemple : java UnPlusUn \"deux plus trois\"";
        
        if(args.length != 1){
            System.out.println(usage);
            System.exit(-1);
        }
        
        try{
            AbstractExpression exp = parse(args[0]);
            System.out.println(args[0] + " = " + exp.interpret());
            
        }
        catch(IllegalExpressionException e){
            e.printStackTrace();
        }
    }
    
    /** 
        Méthode auxiliaire, qui effectue le parsing
        Transforme une chaîne en AST
        Etape antérieure à l'interprétation, ne fait pas partie du pattern Interpreter
    **/
    static AbstractExpression parse(String str) throws IllegalExpressionException{
        String[] parts = str.split(" ");
        if(parts.length != 3){
            throw new IllegalExpressionException("Illegal expression : " + str);
        }
        AbstractExpression e1 = new Nb(parts[0]);
        AbstractExpression e2 = new Nb(parts[2]);
        
        AbstractExpression operation = null;
        switch(parts[1]){
        	case "fois" : operation = new Fois(e1, e2); break;
        	case "plus" : operation = new Plus(e1, e2); break;
            default: throw new IllegalExpressionException("Illegal expression '" + str + "' : '" + parts[1] + "' n'est pas un opérateur valable");
        }
        return operation;
    }
}

class IllegalExpressionException extends Exception{
    public IllegalExpressionException(String msg){
        super(msg);
    }
}

// === abstract expression ===
interface AbstractExpression {
    public int interpret();
}

// === concrete expressions : composed ===
abstract class BinaryExpression implements AbstractExpression {
    
    protected AbstractExpression exp1, exp2;
    
    public BinaryExpression(AbstractExpression exp1, AbstractExpression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
}

class Plus extends BinaryExpression {
    public Plus(AbstractExpression exp1, AbstractExpression exp2){
        super(exp1, exp2);
    }
    public int interpret() {
        return exp1.interpret() + exp2.interpret();
    }
}

class Fois extends BinaryExpression {
    public Fois(AbstractExpression exp1, AbstractExpression exp2){
        super(exp1, exp2);
    }
    public int interpret() {
        return exp1.interpret() * exp2.interpret();
    }
}

// === concrete expressions : terminal ===
class Nb implements AbstractExpression{
    private int value;
    public Nb(String str) throws IllegalExpressionException{
        switch(str){
            case "un" : value = 1; break;
            case "deux" : value = 2; break;
            case "trois" : value = 3; break;
            case "quatre" : value = 4; break;
            case "cinq" : value = 5; break;
            case "six" : value = 6; break;
            case "sept" : value = 7; break;
            case "huit" : value = 8; break;
            case "neuf" : value = 9; break;
            default:
                throw new IllegalExpressionException("Illegal number string : " + str);
        }
}
    
    public int interpret() {
        return value;
    }
}

