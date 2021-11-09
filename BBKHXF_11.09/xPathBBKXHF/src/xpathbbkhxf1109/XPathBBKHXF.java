package xpathbbkhxf1109;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class XPathBBKHXF {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		try {
	        //First
	        String expression1 = "/class/student";
	        System.out.println("--------First--------");
	        writeToConsole(expression1);
	        	
	        //Second
	        String expression2 = "//student[@id=01]";
	        System.out.println("--------Second--------");
	       writeToConsole(expression2);
	        //Third
	        String expression3 = "//student";
	        System.out.println("--------Third--------");
	       writeToConsole(expression3);
	        
	        //Fourth
	        String expression4 = "/class/student[2]";
	        System.out.println("--------Fourth--------");
	       writeToConsole(expression4);
	        
	        //Fifth
	        String expression5 = "/class/student[last()]";
	        System.out.println("--------Fifth--------");
	       writeToConsole(expression5);
	        
	        //Sixth
	        String expression6 = "/class/student[last()-1]";
	        System.out.println("--------Sixth--------");
	       writeToConsole(expression6);
	       
	     //Seventh
	        String expression7 = "/class/*";
	        System.out.println("--------Seventh--------");
	       writeToConsole(expression7);
	       
	     //Eight
	        String expression8 = "/class/*[@*>=1]";
	        System.out.println("--------Eight--------");
	       writeToConsole(expression8);
	     //Ninth
	        String expression9 = "/descendant-or-self::*";
	        System.out.println("--------Ninth--------");
	       writeToConsole2(expression9);
	     //Tenth
	        String expression10 = "/class/student[20<age]";
	        System.out.println("--------Tenth--------");
	       writeToConsole(expression10);
	       
	     //Eleventh
	        String expression11 = "/class/student/firstname | /class/student/lastname";
	        System.out.println("--------Eleventh--------");
	       writeToConsole2(expression11);
	        
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToConsole(String expression) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File inputFile = new File("studentBBKHXF.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
	    doc.getDocumentElement().normalize();
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
    		Node nNode = nodeList.item(i);
    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
         
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Student id :" + eElement.getAttribute("id"));
                System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                System.out.println("Age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
             }
		}
	}
	
	public static void writeToConsole2(String expression) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File inputFile = new File("studentBBKHXF.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
	    doc.getDocumentElement().normalize();
		XPath xPath =  XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc,XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
    		Node nNode = nodeList.item(i);
    		System.out.println("Current element:" + nNode.getNodeName());
    		if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode.getNodeName().equals("firstname")) {
                Element eElement = (Element) nNode;
                System.out.println(eElement.getTextContent());
             }
    		else {
    			Element eElement = (Element) nNode;
                System.out.println(eElement.getTextContent());
    		}
    		
		}
	}
}
