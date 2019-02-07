
public class Stack1<E> implements StackI<E>{
    
    E bidon;
    
    public void push(E e){
        System.out.println("Stack1.push()");
    }
    
    public E pop(){
        System.out.println("Stack1.pop()");
        return bidon;
    }
    
    public boolean isEmpty(){
        System.out.println("Stack1.isEmpty()");
        return false;
    }
}