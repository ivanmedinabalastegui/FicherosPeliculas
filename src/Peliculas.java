import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Peliculas {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Peliculas p = new Peliculas();
        p.Menu();
    }

    public void Menu(){
        while(true){
            System.out.println("\nMenú Películas");
            System.out.println("\n1) Presentar el documento XML completo\n" +
                    "2) Añadir nuevo nodo al documento\n" +
                    "3) Modificar datos de un nodo del documento\n" +
                    "4) Eliminar un nodo concreto del documento\n" +
                    "5) Salir\n");
            System.out.print("Introduzca una opción: ");
            String opc = sc.nextLine();
            switch (opc){
                case "1":{
                    Mostrar();
                    break;
                }
                case "2":{
                    MenuAgregar();
                    break;
                }
                case "3":{
                    MenuModificar();
                    break;
                }
                case "4":{
                    MenuEliminar();
                    break;
                }
                case "5":{
                    System.exit(0);
                }
            }
        }
    }

    public void MenuAgregar(){
        while(true){
            System.out.println("\n1) Insertar nodo al principio del documento\n" +
                    "2) Insertar nodo en posiciones intermedias del documento\n" +
                    "3) Insertar nodo al final del documento\n" +
                    "4) Volver al menú principal");
            System.out.print("\nIntroduzca una opción: ");
            String opc =sc.nextLine();
            switch (opc){
                case "1":{
                    Agregar(opc);
                    break;
                }
                case "2":{
                    Agregar(opc);
                    break;

                }
                case "3":{
                    Agregar(opc);
                    break;

                }
                case "4":{
                    Menu();
                }
            }}
    }
    public void MenuModificar(){
        while(true){
            System.out.println("\n1) Modificar nodo al principio del documento\n" +
                    "2) Modificar nodo en posiciones intermedias del documento\n" +
                    "3) Modificar nodo al final del documento\n" +
                    "4) Volver al menú principal");
            System.out.print("\nIntroduzca una opción: ");
            String opc =sc.nextLine();
            switch (opc){
                case "1":{
                    Modificar(opc);
                    break;
                }
                case "2":{
                    Modificar(opc);
                    break;
                }
                case "3":{
                    Modificar(opc);
                    break;
                }
                case "4":{
                    Menu();
                }
            }
        }
    }

    public void MenuEliminar(){
        while (true){
            System.out.println("\n1) Eliminar nodo al principio del documento\n" +
                    "2) Eliminar nodo en posiciones intermedias del documento\n" +
                    "3) Eliminar nodo al final del documento\n" +
                    "4) Volver al menú principal");
            System.out.print("\nIntroduzca una opción: ");
            String opc =sc.nextLine();
            switch (opc){
                case "1":{
                    Eliminar((opc));
                    System.out.println("\nEliminado correctamente");
                    break;
                }
                case "2":{
                    Eliminar((opc));
                    System.out.println("\nEliminado correctamente");
                    break;
                }
                case "3":{
                    Eliminar((opc));
                    System.out.println("\nEliminado correctamente");
                    break;
                }
                case "4":{
                    Menu();
                }
            }}
    }

    public int Menu2(){
        System.out.println("\n1) Titulo \t4) Director\n" +
                "2) Guionista \t5) Actor\n" +
                "3) Productora \t6) Sinopsis\n" +
                "7) Volver al menú anterior");
        System.out.print("\nIntroduzca una opción: ");
        int retorno = Integer.parseInt(sc.nextLine());
        if(retorno == 7){
            MenuModificar();
        }
        return retorno;
    }

    public void Mostrar() {
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            docDOM.getDocumentElement().normalize();
            System.out.println("\n========================");
            Element raiz = docDOM.getDocumentElement();
            System.out.println("Elemento raíz: " + raiz.getNodeName());
            System.out.println("========================");
            NodeList pelic = docDOM.getElementsByTagName("pelicula");
            for (int cont = 0; cont < pelic.getLength(); cont++) {
                Node nodo = pelic.item(cont);
                System.out.println("------------------------");
                System.out.println(nodo.getNodeName()+" --> Nodo: "+cont);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Título: " + element.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Guionista: " + element.getElementsByTagName("guionista").item(0).getTextContent());
                    System.out.println("Productora: " + element.getElementsByTagName("productora").item(0).getTextContent());
                    System.out.println("Director: " + element.getElementsByTagName("director").item(0).getTextContent());
                    System.out.println("Actor: " + element.getElementsByTagName("actor").item(0).getTextContent());
                    System.out.println("Sinopsis: " + element.getElementsByTagName("sinopsis").item(0).getTextContent());
                }
            }
            System.out.println("------------------------");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void Agregar(String s){

        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            docDOM.getDocumentElement().normalize();
            Element raiz = docDOM.getDocumentElement();
            Element Pelicula = docDOM.createElement("pelicula");
            switch (s){
                case "1": {
                    raiz.insertBefore(Pelicula, raiz.getFirstChild());
                    break;
                }
                case "2":{
                    System.out.print("\nIntroduzca la posición del nodo: ");
                    int posicion =Integer.parseInt(sc.nextLine());
                    NodeList listpelic = docDOM.getElementsByTagName("pelicula");
                    Node p = listpelic.item(posicion);
                    raiz.insertBefore(Pelicula, p);
                    break;
                }
                case "3":{
                    raiz.appendChild(Pelicula);
                    break;
                }
            }

            Element Titulo = docDOM.createElement("titulo");
            System.out.print("\nIntroduzca el título: ");
            Titulo.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Titulo);

            Element Guionista = docDOM.createElement("guionista");
            System.out.print("Introduzca el guionista: ");
            Guionista.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Guionista);

            Element Productora = docDOM.createElement("productora");
            System.out.print("Introduzca la productora: ");
            Productora.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Productora);

            Element Director = docDOM.createElement("director");
            System.out.print("Introduzca el director: ");
            Director.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Director);

            Element Actor = docDOM.createElement("actor");
            System.out.print("Introduzca el actor: ");
            Actor.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Actor);

            Element Sinopsis = docDOM.createElement("sinopsis");
            System.out.print("Introduzca la sinopsis: ");
            Sinopsis.appendChild(docDOM.createTextNode(sc.nextLine()));
            Pelicula.appendChild(Sinopsis);

            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource fuenteDom = new DOMSource(docDOM);
            StreamResult resulFinal = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(fuenteDom, resulFinal);
            System.out.println("\nAgregado correctamente");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    public void Modificar(String opc){
        File fichXML = new File("src/peliculas.xml");
        try{
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            docDOM.getDocumentElement().normalize();
            Element raiz = docDOM.getDocumentElement();
            NodeList listPelic = docDOM.getElementsByTagName("pelicula");
            NodeList DentroPelic;
            switch (opc){
                case "1":{
                    DentroPelic = listPelic.item(0).getChildNodes();
                    Node nodeSelP = DentroPelic.item(Menu2()-1);
                    System.out.print("\nIntroduzca el nuevo contenido para el nodo: ");
                    nodeSelP.setTextContent(sc.nextLine());
                    break;}
                case "2":{
                    System.out.print("Introduzca el título a buscar");
                    String tituloBusq = sc.nextLine();
                    for(int cont = 0; cont < listPelic.getLength(); cont++){
                        DentroPelic = listPelic.item(cont).getChildNodes();
                        if (tituloBusq.equals(DentroPelic.item(0).getTextContent())) {

                            Node nodeSel = DentroPelic.item(Menu2()-1);
                            System.out.println("Introduzca el nuevo contenido para el nodo");
                            nodeSel.setTextContent(sc.nextLine());
                        }}
                    break;}
                case "3":{
                    DentroPelic = listPelic.item(listPelic.getLength()-1).getChildNodes();
                    Node nodeSelF = DentroPelic.item(Menu2()-1);
                    System.out.println("Introduzca el nuevo contenido para el nodo");
                    nodeSelF.setTextContent(sc.nextLine());
                    break;}}
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, fileResult);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void Eliminar(String opc){
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            docDOM.getDocumentElement().normalize();
            Element raiz = docDOM.getDocumentElement();
            NodeList listPelic = docDOM.getElementsByTagName("pelicula");
            NodeList DentroPelic;
            switch (opc){
                case "1":{
                    listPelic.item(0).getParentNode().removeChild(listPelic.item(0));
                    break;}
                case "2":{
                    System.out.print("\nIntroduzca el título de la película a buscar: ");
                    String tituloBusq = sc.nextLine();
                    for(int cont = 0; cont < listPelic.getLength(); cont++){
                        DentroPelic = listPelic.item(cont).getChildNodes();
                        if (tituloBusq.equals(DentroPelic.item(0).getTextContent())) {

                            listPelic.item(cont).getParentNode().removeChild(listPelic.item(cont));
                        }}
                    break;}
                case "3":{
                    listPelic.item(listPelic.getLength()-1).getParentNode().removeChild(listPelic.item(listPelic.getLength()-1));
                    break;}}
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, fileResult);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
