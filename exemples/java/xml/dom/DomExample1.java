/** 
    Inspiré de https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
**/
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomExample1 {

   public static void main(String[] args) {

      try {
         File inputFile = new File("etudiants.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         //doc.getDocumentElement().normalize();
         
         System.out.println("Root : " + doc.getDocumentElement().getNodeName());
         
         NodeList nList = doc.getElementsByTagName("étudiant");
         
         System.out.println("----------------------------");
         for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element elt = (Element) nNode;
               System.out.print("Étudiant n° " + elt.getAttribute("id"));
               System.out.print(" : ");
               System.out.print(elt.getElementsByTagName("prénom").item(0).getTextContent());
               System.out.print(" ");
               System.out.print(elt.getElementsByTagName("nom").item(0).getTextContent());
               System.out.print(" (\"");
               System.out.print(elt.getElementsByTagName("surnom").item(0).getTextContent());
               System.out.print(" \") : ");
               System.out.print(elt.getElementsByTagName("moyenne").item(0).getTextContent());
               System.out.println("/20");
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}