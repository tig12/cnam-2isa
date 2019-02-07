enum CouleurPrimaire {
    
    // liste des valeurs possibles
    
    ROUGE("255 0 0", "FF0000"),
    VERT("0 128 0", "008000"),
    BLEU("0 0 255", "0000FF");
    
    // Définition des champs et méthodes de l'enum
    
    private final String codeRGB;
    
    private final String codeHTML;
    
    private CouleurPrimaire(String codeRGB, String codeHTML){
        this.codeRGB = codeRGB;
        this.codeHTML = codeHTML;
    }
    
    public String getCodeHTML(){ return codeHTML; }
    
    public String getCodeRGB(){ return codeRGB; }
    
}

class TestEnum3{
    
    public static void main(String[] args) {
        for(CouleurPrimaire cp : CouleurPrimaire.values()) {
         System.out.println(cp.ordinal() + "\t" + cp + "\t#" + cp.getCodeHTML() + "\t" + cp.getCodeRGB());
      }
    }
}


