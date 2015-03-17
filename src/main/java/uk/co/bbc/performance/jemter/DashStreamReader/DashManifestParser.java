package uk.co.bbc.performance.jemter.DashStreamReader;

import java.io.IOException;

import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import us.monoid.web.Resty;
import us.monoid.web.XMLResource;

public class DashManifestParser {

	XMLResource doc;

	public DashManifestParser(String url, String auth) {
		Resty r = new Resty();
		r.withHeader("X-AUTH", auth);
		try {
			doc = r.xml(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String argv[]) throws Exception {
		DashManifestParser u = new DashManifestParser("http://localhost:8080/car-20120827-manifest.xml", "asd");
		u.getTime();
	}

	public Period getTime() throws Exception {
		// Period duration="PT0H3M1.63S"
		NodeList nodeList = doc.get("//Period");
		Node nNode = nodeList.item(0);
		Element eElement = (Element) nNode;
		String duration = eElement.getAttribute("duration");
		PeriodFormatter format = ISOPeriodFormat.standard();
		Period start = format.parsePeriod(duration);
		System.out.println(start);
		return start;
	}
}
