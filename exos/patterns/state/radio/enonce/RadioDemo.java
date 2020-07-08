
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.Arrays;

/** 
    Implémentation d'un poste radio pouvant changer d'état
    Les états sont exprimés par une variable d'instance.
**/
public class RadioDemo {

    public static void main(String[] args){
        PosteRadio poste = new PosteRadio();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        poste.changerBandeFrequence();
        poste.printEtat();
                                 
        System.out.println("");
        poste.on();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        
        System.out.println("");
        poste.changerBandeFrequence();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        
        System.out.println("");
        poste.changerBandeFrequence();
        poste.printEtat();
        poste.stationSuivante();
        poste.printEtat();
        
        System.out.println("");
        poste.off();
        poste.printEtat();
        
        System.out.println("");
        poste.on();
        poste.printEtat();
    }

}

class PosteRadio {
    
    public final static String STATE_OFF = "OFF";
    public final static String STATE_FM = "FM";
    public final static String STATE_AM = "AM";
    public final static String STATE_LW = "LW";
    
    private Map<String, TreeSet<String>> stations = new HashMap<>();
    private Map<String, String> stationEnCours = new HashMap<>();
    private String state; // OFF, FM, AM ou LW
    
    
    public PosteRadio() {
        stations.put(STATE_FM, new TreeSet<String>(Arrays.asList(new String[]{"81.3", "89.1", "99.9"})));
        stations.put(STATE_AM, new TreeSet<String>(Arrays.asList(new String[]{"1250", "1380", "1510"})));
        stations.put(STATE_LW, new TreeSet<String>(Arrays.asList(new String[]{"1852", "1647", "1389", "1282"})));
        
        stationEnCours.put(STATE_FM, stations.get(STATE_FM).first());
        stationEnCours.put(STATE_AM, stations.get(STATE_AM).first());
        stationEnCours.put(STATE_LW, stations.get(STATE_LW).first());
        
        state = STATE_OFF;
    }
    
    public String getState(){ return state; }
    
    public void on(){
        System.out.println("on()");
        state = STATE_FM;
    }
    
    public void off(){
        state = STATE_OFF;
    }
    
    public String getStationEnCours(){
        if(state == STATE_OFF){
            return "";
        }
        return stationEnCours.get(state);
    }
    
    public void printEtat(){
        System.out.printf("Etat du poste : %s %s%n", getStationEnCours(), getState());
    }
    
    public void changerBandeFrequence(){
        System.out.println("changerBandeFrequence()");
        if(state == STATE_OFF){
            return;
        }
        switch(state){
            case STATE_FM : state = STATE_AM; break; 
            case STATE_AM : state = STATE_LW; break; 
            case STATE_LW : state = STATE_FM; break; 
        }
    }
    
    public void stationSuivante(){
        System.out.println("stationSuivante()");
        if(state == STATE_OFF){
            return;
        }
        NavigableSet<String> next = stations.get(state).tailSet(getStationEnCours(), false);
        if(next.size() == 0){
            // c'est la dernière station de la liste, on prend la première station.
            stationEnCours.put(state, stations.get(state).first());
        }
        else{
            // on prend la station suivante = premier elt de la liste des suivants.
            stationEnCours.put(state, next.first());
        }
    }
}
