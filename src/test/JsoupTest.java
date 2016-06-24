package test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String[] args) throws IOException {
		long now = System.currentTimeMillis();
		String url = "https://www.cpes-sipo.net/txnCaseListPage.do";
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
