package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.util.file.UtilFile;

public class GetPatent {
	public static void main(String[] args) throws IOException {
		long now=System.currentTimeMillis();
		String url = "https://www.cpes-sipo.net/txnCaseDetailPage.do?shenqingh=CN201410712046&faShenqingh=CN201410712046&inner-flag:open-type=window&inner-flag:flowno=1466669916876";
		//getPatent(url);
		String html=getHTML(url,"UTF-8");
		System.out.println(html);
		System.out.println(System.currentTimeMillis()-now);
	}
	public static void getPatent1(String url) throws IOException{
		String html=getHTML(url,"UTF-8");
		String filePath="c:/test2.html";
		UtilFile.writeFile(filePath, html); 
		File file = new File(filePath);
		Document doc = Jsoup.parse(file, "UTF-8");
		//Document doc = Jsoup.parse(html);
		Elements elements = doc.select(".td1");
		for(int i=0;i<elements.size();i++){
			Element element =elements.get(i);
			System.out.print(element.html());
			Elements elements1=element.nextElementSibling().select("span");
			if(i>0){
				System.out.println(elements1.attr("title"));
			}else{
				System.out.println(elements1.text());
			}
		}
	}
	public static void getPatent(String url) throws IOException{
		Document doc = Jsoup.connect(url)
//		/.header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
//		.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
		.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
		.ignoreContentType(true)
		.get();
		System.out.println(doc.html());
		Elements elements = doc.select(".td1");
		for(int i=0;i<elements.size();i++){
			Element element =elements.get(i);
			//System.out.print(element.html());
			Element elements1=element.nextElementSibling().select("span").first();
			if(i>0){
				elements1.html("1234");
				System.out.println(elements1.html());
			}else{
				System.out.println(elements1.text());
			}
		}
	}
	public static void get() throws IOException{
		//申请信息
		String url = "http://cpquery.sipo.gov.cn/txnQueryBibliographicData.do?select-key:shenqingh=2015110170056&select-key:zhuanlilx=1&select-key:backPage=http%3A%2F%2Fcpquery.sipo.gov.cn%2FtxnQueryOrdinaryPatents.do%3Fselect-key%3Ashenqingh%3D2015110170056%26select-key%3Azhuanlimc%3D%26select-key%3Ashenqingrxm%3D%26select-key%3Azhuanlilx%3D%26select-key%3Ashenqingr_from%3D%26select-key%3Ashenqingr_to%3D%26inner-flag%3Aopen-type%3Dwindow%26inner-flag%3Aflowno%3D1466571732276&inner-flag:open-type=window&inner-flag:flowno=1466572878108";
		//审查信息
		
		//费用信息
		//发文信息
		//公布公告
		//专利登记薄
		
		//同族案件信息
		
		Document doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select(".td1");
		for(int i=0;i<elements.size();i++){
			Element element =elements.get(i);
			System.out.print(element.html());
			element=element.nextElementSibling();;
			System.out.println(element.outerHtml());
			//System.out.println(element.attr("title"));
		}
		
	}
	
	// 下载html内容
	private static String getHTML(String pageURL, String encoding) throws IOException {
		URL url = new URL(pageURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        connection.setConnectTimeout(6 * 1000);
        connection.setReadTimeout(6*1000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
		String line = null;
		StringBuilder pageHTML = new StringBuilder();
		while ((line = br.readLine()) != null) {
			pageHTML.append(line);
			pageHTML.append("\r\n");
		}
		connection.disconnect();
		return pageHTML.toString();
	}
	
	public static void getPatent2(String url){
		 System.getProperties().setProperty("webdriver.chrome.driver", "E:\\DevTool\\chromedriver_x64.exe"); //这个参数就是【chrome驱动器的位置】  
		 WebDriver webDriver = new ChromeDriver();  
		 webDriver.get(url);  
		 WebElement rootElement = webDriver.findElement(By.className("tab_box"));  
		 List<WebElement>	listWebElement = rootElement.findElements(By.tagName("td"));  
		 for(WebElement webElement:listWebElement){
			 System.out.println(webElement.getText());
		 }
		 webDriver.close();  
		 webDriver.quit();
	}
}
