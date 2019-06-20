package elevage;

import elevage.animaux.*;
import com.catfeeders.cats.*;

public class Main {

    public static void main(String[] args) {
        
        ChatNormal chat1 = new ChatNormal("Chat 1 normal");
        ChatNormal chat2 = new ChatNormal("Chat 2 normal");
        ChatVorace chat3 = new ChatVorace("Chat 3 vorace");
        ChatMalade chat4 = new ChatMalade("Chat 4 malade");
        
        chat1.alimenter();
        chat2.alimenter();
        chat3.alimenterAvecParcimonie();
        chat4.donnerNourritureEtMedicaments();
        
    }
}
