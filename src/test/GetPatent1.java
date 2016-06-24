package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetPatent1 {

	
	public static void main(String[] args) throws IOException {
		long now=System.currentTimeMillis();
		String url = "http://www.pss-system.gov.cn/sipopublicsearch/search/search/showViewList.shtml";
		String  filePath="c:/test1.html";
		File file = new File(filePath);
		Document doc = Jsoup.parse(file, "UTF-8");
		//String html=getHTML(url,"UTF-8");
		//UtilFile.writeFile(filePath, html); 
		//Document doc = Jsoup.parse(html);
		Elements elements = doc.select("td");
		for(int i=0;i<elements.size();i++){
			Element element =elements.get(i);
			System.out.print(element.html());
		/*	Elements elements1=element.nextElementSibling().select("span");
			if(i==1){
				System.out.println(elements1.attr("title"));
			}else if(i==2){
				System.out.println(elements1.text());
			}else{
				System.out.println(elements1.text());
			}*/
		}
		System.out.println(System.currentTimeMillis()-now);
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
		StringBuilder pageHTML = new StringBuilder();
		URL url = new URL(pageURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "MSIE 7.0");
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
		String line = null;
		while ((line = br.readLine()) != null) {
			pageHTML.append(line);
			pageHTML.append("\r\n");
		}
		connection.disconnect();
		return pageHTML.toString();
	}
	
	
}
