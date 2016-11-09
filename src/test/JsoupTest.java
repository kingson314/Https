package test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String[] args) throws IOException {
		long now = System.currentTimeMillis();
		String url = "https://www.dailyfx.com.hk/inc/cal_qry.php?symbol=rmb-usd-eur-jpy-gbp-chf-aud-cad-nzd&section=event-holiday-figure&sdate=2016-11-01&edate=2016-11-01";
		getPatent(url);
		System.out.println(System.currentTimeMillis() - now);
	}

	public static void getPatent(String url) throws IOException {
		Document doc = Jsoup.connect(url).userAgent("Mozilla").post();
		System.out.println(doc.html());
//		Elements elements = doc.select(".text_ellipsis ");
//		for (int i = 0; i < elements.size(); i++) {
//			Element element = elements.get(i);
//			System.out.println(element.attr("abs:href"));
//		}
	}

}
