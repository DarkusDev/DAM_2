import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ej31 {
    public static void main(String[] args) {
        // creamos una instancia de DocumentBuilderFactory para construir el parser y
        // cargamos el documento con el método parse()
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("./clase.xml"));
            // Elimina nodos vacios y combina adyacentes en caso de que los hubiera
            document.getDocumentElement().normalize();
            System.out.printf("Elemento raiz: %s %n",
                    document.getDocumentElement().getNodeName());
            // crea una lista con todos los nodos empleado
            NodeList empleados = document.getElementsByTagName("alumno");
            System.out.printf("Nodos alumno a recorrer: %d %n",
                    empleados.getLength());
            // recorrer la lista de nodos. Por cada nodo se obtienen sus etiquetas y sus
            // valores
            for (int i = 0; i < empleados.getLength(); i++) {
                // obtener un nodo empleado
                Node emple = empleados.item(i);
                if (emple.getNodeType() == Node.ELEMENT_NODE) {// tipo de nodo
                    // obtener los elementos del nodo
                    Element elemento = (Element) emple;
                    System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
                    System.out.printf(" * Apellido = %s %n",
                            elemento.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.printf(" * Departamento = %s %n",
                            elemento.getElementsByTagName("dep").item(0).getTextContent());
                    System.out.printf(" * Salario = %s %n",
                            elemento.getElementsByTagName("salario").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// fin de main
}// fin de la clase