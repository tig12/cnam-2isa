enum CouleurPrimaire {
    ROUGE, VERT, BLEU
}

class TestEnum2{
    public static void main(String[] args) {
        for(CouleurPrimaire cp : CouleurPrimaire.values()) {
         System.out.println(cp.ordinal() + " " + cp.name() + " " + cp);
      }

        
    }
}


