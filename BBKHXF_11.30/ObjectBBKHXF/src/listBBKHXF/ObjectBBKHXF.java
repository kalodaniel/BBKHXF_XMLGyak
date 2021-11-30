package listBBKHXF;

import org.json.JSONObject;
import org.json.XML;

public class ObjectBBKHXF {
	public static void main(String[] args){
		JSONObject obj = new JSONObject();

	    obj.put("nev", "KDaniel");
	    obj.put("fizetes", 100000);
	    obj.put("kor", 23);
	    
	    System.out.println("Név: "+obj.get("nev"));
	    System.out.println("Fizetés:"+obj.get("fizetes"));
	    System.out.println("Kor:"+obj.get("kor"));
		
	}
}
