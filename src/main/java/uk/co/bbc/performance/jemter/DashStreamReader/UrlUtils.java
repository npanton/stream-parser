package uk.co.bbc.performance.jemter.DashStreamReader;

import java.io.IOException;

import org.w3c.dom.NodeList;

import us.monoid.web.Resty;
import us.monoid.web.XMLResource;

public class UrlUtils {

	public static void main(String argv[]) {
		UrlUtils u = new UrlUtils();
		try {
			u.getUrl();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getUrl() throws IOException, Exception {
		Resty r = new Resty();
		XMLResource name = r.xml("http://www.w3schools.com/xml/note.xml");
		// System.out.println(name.text(new XPathQuery("//heading")));
		NodeList nodeList = name.get("//heading");
		System.out.println(nodeList.item(0).getTextContent());
	}
}
