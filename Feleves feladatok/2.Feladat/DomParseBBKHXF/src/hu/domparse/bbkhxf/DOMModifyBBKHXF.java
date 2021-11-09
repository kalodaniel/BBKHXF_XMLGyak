package hu.domparse.bbkhxf;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyBBKHXF {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		try {
			//file nev megadasa, parszolas
			File inputFile = new File("XML2bbkhxf.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
	        
			//az elso es a masodik auto adatainak mentese
			Node car = doc.getElementsByTagName("auto").item(0);
			Node car1 = doc.getElementsByTagName("auto").item(1);
			//gyokerelem mentese
			Node autocentrum = doc.getFirstChild();
	        
			//autoId modositasa
			NamedNodeMap attr = car.getAttributes();
			Node nodeAttr = attr.getNamedItem("autoId");
			nodeAttr.setTextContent("6");
	         
			//az elso auto szinenek modositasa feketerol sargara
			NodeList list = car.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					if ("szin".equals(elem.getNodeName())) {
						if("Fekete".equals(elem.getTextContent())) {
							elem.setTextContent("Sarga");  
						}
					}
				}
			}
	        
			//a masodik auto szinenek modositasa feherrol pirosra
			NodeList list1 = car1.getChildNodes();
			for (int i = 0; i < list1.getLength(); i++) {
				Node node1 = list1.item(i);
				if (node1.getNodeType() == Node.ELEMENT_NODE) {
					Element elem1 = (Element) node1;
					if ("szin".equals(elem1.getNodeName())) {
						if("Feher".equals(elem1.getTextContent())) {
							elem1.setTextContent("Piros");  
						}
					}
				}
			}
	        
			//szamlak kitorlese
			NodeList childNodes = autocentrum.getChildNodes();
			for(int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
	            
				if("szamla".equals(node.getNodeName()))
					autocentrum.removeChild(node);
			}
	        
	        //megjelenites a consolon
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			System.out.println("-----------New File-----------");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}

