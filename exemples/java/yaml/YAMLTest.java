
import java.util.*;
import java.io.*;
import com.esotericsoftware.yamlbeans.*;

/** 
**/
public class YAMLTest {
    public static void main(String[] args){
        try{
            var yamlFile = "MT2.yml";
            YamlReader reader = new YamlReader(new FileReader(yamlFile));
            Map map = (Map)reader.read();
            // symbols
            Map symbols = (Map)map.get("symbols");
            for(Object symbolName : symbols.keySet()) {
//                this.symbols.put((String)symbolName, (String)symbols.get(symbolName));
            }
            // currentMConfig
            var currentMConfig = (String)map.get("initial-mconfig");
            // mconfigs
            Map mconfigs = (Map)map.get("mconfigs");
            for(Object configName : mconfigs.keySet()) {
                Map mconfigYAML = (Map)mconfigs.get(configName); // lu dans le yaml
                Map<String, Map<String, Object>> mconfig = new HashMap<>(); // stocké en variable d'instance
                for(Object symbolName : mconfigYAML.keySet()) {
                    Map<String, Object> configForSymbol = (Map<String, Object>)mconfigYAML.get(symbolName);
                    ArrayList operations = (ArrayList)configForSymbol.get("operations");
                    configForSymbol.put("operations", operations);
                    String next = (String)(configForSymbol.get("next"));
                    configForSymbol.put("next", next);
                    mconfig.put((String)symbolName, configForSymbol);
                }
//                this.mconfigs.put((String)configName, mconfig);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
