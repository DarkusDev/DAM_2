package EjRepasoExamen;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ej4 {
    public static void main(String[] args) {
        try {
            // 1. Creamos la "fábrica" que nos da el parser (lector) de XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 2. Con la fábrica obtenemos el parser
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 3. El parser lee el fichero y lo carga en memoria como un árbol (Document)
            Document document = builder.parse(new File("menu.xml"));

            // 4. Limpia el árbol: elimina nodos de texto vacíos y une los adyacentes
            document.getDocumentElement().normalize();

            // 5. Obtenemos TODOS los elementos <menu> del documento
            NodeList menus = document.getElementsByTagName("menu");

            // Recorremos cada menú
            for (int i = 0; i < menus.getLength(); i++) {
                // Convertimos el nodo a Element para poder usar getAttribute()
                Element menu = (Element) menus.item(i);

                // "id" es un ATRIBUTO de <menu id="1">, por eso se usa getAttribute
                System.out.println("MENÚ " + menu.getAttribute("id"));

                // Obtenemos los <plato> que hay DENTRO de este menú
                // (se llama sobre "menu", no sobre "document", para no coger todos los platos
                // del fichero)
                NodeList platos = menu.getElementsByTagName("plato");

                // Recorremos cada plato del menú
                for (int j = 0; j < platos.getLength(); j++) {
                    Element plato = (Element) platos.item(j);

                    // "tipo" también es un atributo: <plato tipo="primero">
                    String tipo = plato.getAttribute("tipo");

                    // <nombre> es una ETIQUETA hija del plato:
                    // cogemos la primera (item(0)) y leemos su texto.
                    // trim() quita los espacios y tabuladores que sobran
                    String nombre = plato.getElementsByTagName("nombre")
                            .item(0).getTextContent().trim();

                    System.out.println("   " + tipo + ": " + nombre);

                    // Obtenemos los <ingrediente> que hay DENTRO de este plato
                    NodeList ingredientes = plato.getElementsByTagName("ingrediente");

                    // Recorremos cada ingrediente del plato
                    for (int k = 0; k < ingredientes.getLength(); k++) {
                        Element ing = (Element) ingredientes.item(k);

                        // El nombre del ingrediente es un atributo: <ingrediente nombre="tomate">
                        // (la cantidad no se pide, así que no la leemos)
                        System.out.println("      - " + ing.getAttribute("nombre"));
                    }
                }
                // Línea en blanco para separar un menú del siguiente
                System.out.println();
            }
        } catch (Exception e) {
            // Si el fichero no existe o el XML está mal formado, mostramos el error
            e.printStackTrace();
        }
    }
}