

import java.util.List;
import java.util.ArrayList;

public class VisitorDemo1 {

    public static void main(String[] args) {
    
        Node root = new IfNode("if");
        Node node1_1 = new SuperiorNode(">");
        Node node1_1_1 = new VariableNode("x");
        Node node1_1_2 = new VariableNode("y");
        
        Node node1_2 = new AffectationNode("=");
        Node node1_2_1 = new VariableNode("max");
        Node node1_2_2 = new VariableNode("x");
        
        Node node1_3 = new AffectationNode("=");
        Node node1_3_1 = new VariableNode("max");
        Node node1_3_2 = new VariableNode("y");
        
        root.addChild(node1_1);
        node1_1.addChild(node1_1_1);
        node1_1.addChild(node1_1_2);
        root.addChild(node1_2);
        node1_2.addChild(node1_2_1);
        node1_2.addChild(node1_2_2);
        root.addChild(node1_3);
        node1_3.addChild(node1_3_1);
        node1_3.addChild(node1_3_2);
        
        // Simple affichage, en utilisant Composite
        System.out.println("\n=== Simple affichage ===");
        root.print();
        
        // visites
        
        System.out.println("\n=== TypeCheckVisitor ===");
        root.accept(new TypeCheckVisitor());
        
        System.out.println("\n=== CodeGeneratingVisitor ===");
        root.accept(new CodeGeneratingVisitor());
    }
}

// ===== node classes =====

abstract class Node {
    protected String name;
    public Node(String name){ this.name = name; }
    public String getName(){ return name; }
    
    // composite stuff
    abstract public void print();
    public void addChild(Node c){}
    
    // visitor stuff
    abstract public void accept(Visitor v);
}

// Noeud terminal
abstract class Leaf extends Node{
    public Leaf(String name){ super(name); }
    
    // méthodes "operation"
    public void print(){
        System.out.println(name);
    }

}

// Noeud composé
abstract class Composite extends Node{
    protected List<Node> children = new ArrayList<>();
    public Composite(String name){ super(name); }
    public void addChild(Node child){
        children.add(child);
    }
    
    // méthodes "operation"
    public void print(){
        System.out.println(name);
        for(Node child : children){
            child.print();
        }
    }
    
    public void accept(Visitor v){
        v.visit(this);
        for(Node child : children){
            child.accept(v);
        }
    }
}

class IfNode extends Composite{
    public IfNode(String name){ super(name); }
    public void accept(Visitor v){ super.accept(v); }
}

class SuperiorNode extends Composite{
    public SuperiorNode(String name){ super(name); }
    public void accept(Visitor v){ super.accept(v); }
}

class AffectationNode extends Composite{
    public AffectationNode(String name){ super(name); }
    public void accept(Visitor v){ super.accept(v); }
}

class VariableNode extends Leaf{
    public VariableNode(String name){ super(name); }
    public void accept(Visitor v){ v.visit(this); }
}


// ===== visitor classes =====
abstract class Visitor{
        // pour factoriser l'implémentation de accept()
    public void visit(Composite node){}
    
    abstract public void visit(IfNode node);
    abstract public void visit(SuperiorNode node);
    abstract public void visit(AffectationNode node);
    abstract public void visit(VariableNode node);
}

class TypeCheckVisitor extends Visitor{
    public void visit(IfNode node){
        System.out.println("TypeCheckVisitor visiting IfNode : " + node.getName());
    }
    public void visit(SuperiorNode node){
        System.out.println("TypeCheckVisitor visiting SuperiorNode : " + node.getName());
    }
    public void visit(AffectationNode node){
        System.out.println("TypeCheckVisitor visiting AffectationNode : " + node.getName());
    }
    public void visit(VariableNode node){
        System.out.println("TypeCheckVisitor visiting VariableNode : " + node.getName());
    }
}

class CodeGeneratingVisitor extends Visitor{
    public void visit(IfNode node){
        System.out.println("CodeGeneratingVisitor visiting IfNode : " + node.getName());
    }
    public void visit(SuperiorNode node){
        System.out.println("CodeGeneratingVisitor visiting SuperiorNode : " + node.getName());
    }
    public void visit(AffectationNode node){
        System.out.println("CodeGeneratingVisitor visiting AffectationNode : " + node.getName());
    }
    public void visit(VariableNode node){
        System.out.println("CodeGeneratingVisitor visiting VariableNode : " + node.getName());
    }
}

