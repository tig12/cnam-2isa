

public class Main{

    public static void main(String[] args){

        Thermometre thermo1 = new Thermometre("Thermometre 1");
        Thermometre thermo2 = new Thermometre("Thermometre 2");
        CapteurLuminosite cl = new CapteurLuminosite("Capteur luminosité 1");
        
        Serre serre1 = new Serre("Serre 1");
        serre1.setThermometre(thermo1);
        
        Serre serre2 = new Serre("Serre 2");
        serre2.setThermometre(thermo2);
        
        Parcelle parcelle1 = new Parcelle("Parcelle 1");
        
        
        // On simule le deroulement d'une journee, une iteration toute les heures
        for(int minute=0; minute < 1440; minute+=60){ // 1440 = 24 * 60
            double t1 = thermo1.getTemperature(minute);
            double t2 = thermo2.getTemperature(minute);
            double lum = cl.getLuminosite(minute);
            System.out.printf( "h = %d - T1 : %.2f - T2 %.2f - CL %.2f%n", minute, t1, t2, lum );
        }
    }
    
    
}