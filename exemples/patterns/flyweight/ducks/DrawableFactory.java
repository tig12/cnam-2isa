

public class DrawableFactory{
    
    // Pool d'objets qui vont être partagés
    private static MallardDuck mallard;
    private static RedheadDuck redhead;
    
    public static Drawable getHut(int w, int h){
        return new Hut(w, h);
    }
    
    public static Drawable getMallardDuck(){
        if(mallard == null){
            mallard = new MallardDuck();
        }
        return mallard;
    }
    
    public static Drawable getRedheadDuck(){
        if(redhead == null){
            redhead = new RedheadDuck();
        }
        return redhead;
    }
    
}
