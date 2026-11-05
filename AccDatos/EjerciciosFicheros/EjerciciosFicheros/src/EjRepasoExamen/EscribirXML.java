package EjRepasoExamen;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EscribirXML {
    public static void main(String[] args) {
        try {
            // 1. Igual que al leer: fábrica y builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. En vez de parse(), creamos un documento VACÍO en memoria
            Document document = builder.newDocument();

            // 3. Creamos el elemento raíz <menus> y lo añadimos al documento
            // (un XML solo puede tener UNA raíz)
            Element raiz = document.createElement("menus");
            document.appendChild(raiz);

            // ===== MENÚ 1 =====
            // createElement crea la etiqueta, pero NO la coloca en ningún sitio
            Element menu1 = document.createElement("menu");
            // setAttribute crea un ATRIBUTO: <menu id="1">
            menu1.setAttribute("id", "1");
            // appendChild la mete DENTRO de la raíz
            raiz.appendChild(menu1);

            // Plato 1 del menú 1
            Element plato1 = document.createElement("plato");
            plato1.setAttribute("tipo", "primero");
            menu1.appendChild(plato1);

            // <nombre> es una ETIQUETA hija con texto dentro:
            // creamos la etiqueta y le ponemos el texto con setTextContent
            Element nombre1 = document.createElement("nombre");
            nombre1.setTextContent("Ensalada mixta");
            plato1.appendChild(nombre1);

            // Ingredientes: etiquetas vacías con atributos
            // <ingrediente nombre="lechuga" cantidad="100g"/>
            Element ing1 = document.createElement("ingrediente");
            ing1.setAttribute("nombre", "lechuga");
            ing1.setAttribute("cantidad", "100g");
            plato1.appendChild(ing1);

            Element ing2 = document.createElement("ingrediente");
            ing2.setAttribute("nombre", "tomate");
            ing2.setAttribute("cantidad", "50g");
            plato1.appendChild(ing2);

            // Plato 2 del menú 1
            Element plato2 = document.createElement("plato");
            plato2.setAttribute("tipo", "segundo");
            menu1.appendChild(plato2);

            Element nombre2 = document.createElement("nombre");
            nombre2.setTextContent("Pollo asado");
            plato2.appendChild(nombre2);

            Element ing3 = document.createElement("ingrediente");
            ing3.setAttribute("nombre", "pollo");
            ing3.setAttribute("cantidad", "200g");
            plato2.appendChild(ing3);

            // ===== MENÚ 2 =====
            Element menu2 = document.createElement("menu");
            menu2.setAttribute("id", "2");
            raiz.appendChild(menu2);

            Element plato3 = document.createElement("plato");
            plato3.setAttribute("tipo", "primero");
            menu2.appendChild(plato3);

            Element nombre3 = document.createElement("nombre");
            nombre3.setTextContent("Sopa de verduras");
            plato3.appendChild(nombre3);

            Element ing4 = document.createElement("ingrediente");
            ing4.setAttribute("nombre", "zanahoria");
            ing4.setAttribute("cantidad", "80g");
            plato3.appendChild(ing4);

            // 4. Hasta aquí el árbol solo existe en MEMORIA.
            // Para pasarlo a un fichero se usa un Transformer
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            // Opcional: que el XML salga con saltos de línea y sangría
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // 5. Origen: el documento en memoria. Destino: el fichero
            DOMSource origen = new DOMSource(document);
            StreamResult destino = new StreamResult(new File("menuEscrto.xml"));

            // 6. Escribimos el fichero
            transformer.transform(origen, destino);

            System.out.println("Fichero menu.xml creado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}