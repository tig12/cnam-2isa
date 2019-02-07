import java.util.List;
import java.util.Arrays;
import java.lang.reflect.Constructor;

/** 
    Adaptation de https://sourcemaking.com/design_patterns/strategy/java/1
**/

// ============== 1 - interface de l'algo ==============
interface Strategy {
    void solve();
}

// ============== 2 - implémentation de l'algo ==============
abstract class Solution1 implements Strategy {
    // une Template Method
    public void solve() {
        System.out.print(this.getClass().getName() + " : ");
        start();
        while (nextTry() && !isSolution()) {}
        stop();
    }

    abstract void start();
    abstract boolean nextTry();
    abstract boolean isSolution();
    abstract void stop();
}

class Solution1_1 extends Solution1 {
    private int state = 1;

    protected void start() { System.out.print("Start  "); }

    protected void stop() { System.out.print("Stop"); }

    protected boolean nextTry() {
        System.out.print("NextTry-" + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.print("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}

// ============== 2 - implémentation de l'algo ==============
abstract class Solution2 implements Strategy {
    // encore une Template Method
    public void solve() {
        System.out.print(this.getClass().getName() + " : ");
        while (true) {
            preProcess();
            if (search()) {
                break;
            }
            postProcess();
        }
    }

    abstract void preProcess();
    abstract boolean search();
    abstract void postProcess();
}

class Solution2_1 extends Solution2 {
    private int state = 1;

    protected void preProcess()  { System.out.print("PreProcess  "); }

    protected void postProcess() { System.out.print("PostProcess  "); }

    protected boolean search() {
        System.out.print("Search-" + state++ + "  ");
        return state == 3 ? true : false;
    }
}

// ============== 2 - implémentation de l'algo ==============
class Solution3 implements Strategy {
    public void solve() {
        System.out.print(this.getClass().getName() + " : la réponse est 42");
    }
}

// ============== 3 - client ==============
class StrategyDemo1 {
    
    // Exemple où le choix de l'implémentation est statique
    public static void main( String[] args ) {
        Strategy[] algorithms = {new Solution1_1(), new Solution2_1(), new Solution3()};
        for (Strategy algorithm : algorithms) {
            algorithm.solve();
            System.out.print("\n");
        }
    }
}

// ============== 3 - client ==============
class StrategyDemo2 {
    
    /** Liste des algos disponibles **/
    private static final String[] algos = {
        "1_1",
        "2_1",
        "3"
    };
    
    // Exemple où le choix de l'implémentation est dynamique
    public static void main( String[] args ) {
        // param check
        String usage = "usage : java StrategyDemo2 <algo>\n<algo> can be one of : " + Arrays.toString(algos);
        List<String> possibles = Arrays.<String>asList(algos);
        if (args.length != 1 || !possibles.contains(args[0])) { // Remarquer que ça ne fait pas de NullPointerException
            System.out.println(usage);
            System.exit(0);
        }
        try{
            /*
            // équivalent à :
            Strategy algo = null;
            switch(args[0]){
            	case "1_1" : algo = new Solution1_1(); break;
            	case "2_1" : algo = new Solution2_1(); break;
            	case "3" : algo = new Solution3(); break;
            }
            */
            // la méthode Class.newInstance() est deprecated depuis java 9
            // on doit utiliser Constructor.newInstance() à la place
            @SuppressWarnings("deprecation")
            Strategy algo = (Strategy) Class.forName("Solution" + args[0]).newInstance();
            /* 
            // Autre solution, non deprecated, mais qui demande de définir explicitement des 
            // constructeurs vides dans les classes Solution*
            Constructor c = Class.forName("Solution" + args[0]).getConstructor();
            Strategy algo = (Strategy) c.newInstance();
            */
            algo.solve();
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
