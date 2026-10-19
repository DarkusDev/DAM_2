import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class PruebaDOM {
    public static void main(String args[]) throws IOException {
        File fichero = new File("ficheroEmpleados.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        int id, dep, posicion = 0; // para situarnos al principio del fichero
        Double salario;
        char apellido[] = new char[10], aux;

        // Crear una instancia de DocumentBuilderFactory para construir el parser.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Encerrar en un bloque try – catch por si se produce la excepción
        // ParserConfigurationException
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Crear un documento vacío de nombre document, con el nodo raíz de nombre
            // Empleados y
            // asignamos la versión del XML. La interfaz DOMImplementation permite crear
            // objetos Document con nodo raíz
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0");
            // recorrer el fichero con los datos de los empleados y por cada registro crear
            // un nodo
            // empleado con 4 hijos (id, apellido, departamento y salario)
            for (;;) {
                file.seek(posicion); // nos posicionamos
                id = file.readInt(); // obtenemos id de empleado
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();
                    apellido[i] = aux;
                }
                String apellidos = new String(apellido);
                dep = file.readInt();
                salario = file.readDouble();
                if (id > 0) { // id validos a partir de 1
                    Element emple = document.createElement("empleado"); // crear el nodo empleado
                    document.getDocumentElement().appendChild(emple); // lo pegamos en la raíz del documento
                    // Añadir los hijos de ese nodo (raíz). Se añaden en el método CrearElemento()
                    // El método recibe el nombre del nodo hijo (id, apellido, dep o salario) y sus
                    // textos o valores en
                    // formato String (1, FERNANDEZ, 10, 1000.45), el nodo al que se va a añadir
                    // (raíz) y el documento (document)
                    CrearElemento("id", Integer.toString(id), emple, document); // añadir ID
                    CrearElemento("apellido", apellidos.trim(), emple, document); // Apellido
                    CrearElemento("dep", Integer.toString(dep), emple, document); // añadir DEP
                    CrearElemento("salario", Double.toString(salario), emple, document); // añadir salario
                }
                posicion = posicion + 36; // me posiciono para el sig empleado
                if (file.getFilePointer() == file.length())
                    break;
            } // fin del for que recorre el fichero

            // Se crea la fuente XML a partir del documento
            Source source = new DOMSource(document);
            // Se crea el resultado en el fichero Empleados.xml
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            // Se obtiene ahora un TransformerFactory
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            // se realiza la transformación
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        file.close(); // cerrar fichero
    }// fin de main
     // Inserción de los datos del empleado

    static void CrearElemento(String datoEmple, String valor, Element emple, Document document) {
        // Para crear el nodo hijo (<id> o <apellido> o <dep> o <salario>) se escribe:
        Element elem = document.createElement(datoEmple);
        // Para añadir su valor o su texto se usa el método createTextNode(String)
        Text text = document.createTextNode(valor); // damos valor
        // A continuación se añade el nodo hijo a la raíz (empleado) y su valor al nodo
        // hijo
        emple.appendChild(elem); // pegamos el elemento hijo a la raíz
        elem.appendChild(text); // pegamos el valor
    }
}// fin de la clase
/*
 * Al final se generaría algo similar a esto por cada empleado
 * <empleado><id>1</id><apellido>FERNANDEZ</apellido><dep>10</dep><salario>1000.
 * 45</salario></empleado>
 */