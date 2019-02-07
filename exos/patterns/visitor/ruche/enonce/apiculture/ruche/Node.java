
package apiculture.ruche;

import apiculture.abeilles.Abeille;

/** 
    Classe abstraite utilisée pour gérer la structure composite
**/

public abstract class Node {
    
    protected String name;
    
    public Node(String name){ this.name = name; }
    
    public String getName(){ return name; }
    
    // composite stuff
    public void print(){
        System.out.println(name);
    }
    public void addChild(Node n){}
    
    // visitor stuff
    abstract public void accept(Abeille a);
}



