package test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium extends Thread  {
	static{
		System.getProperties().setProperty("webdriver.chrome.driver", "E:\\DevTool\\chromedriver_x64.exe"); //这个参数就是【chrome驱动器的位置】
	}
	private int index;
	private String url;
	public Selenium(int idx,String url){
		this.index=idx;
		this.url=url;
	}

	public  void run(){
		long now=System.currentTimeMillis();
		 WebDriver webDriver = new ChromeDriver();  
		 webDriver.get(url);  
		 WebElement rootElement = webDriver.findElement(By.className("case_detail_table"));  
		 List<WebElement>	listWebElement = rootElement.findElements(By.tagName("td"));  
		 for(int i=0;i<listWebElement.size();i++){
			 WebElement webElement=listWebElement.get(i);
			 if(i%2==0){
				 System.out.print("[线程"+this.index+":] "+webElement.getText());
			 }else{
				 System.out.println(webElement.getText());
			 }
		 }
		 webDriver.close();  
		 webDriver.quit();
		System.out.println("[线程"+this.index+"耗时:] "+(System.currentTimeMillis()-now)/1000);
	}
	
	public static void main(String[] args) throws IOException {
		String url = "http://cpquery.sipo.gov.cn/txnQueryBibliographicData.do?select-key:shenqingh=2015110170056";
		url="https://www.cpes-sipo.net/txnCaseDetailPage.do?shenqingh=CN201410712046&faShenqingh=CN201410712046&inner-flag:open-type=window&inner-flag:flowno=1466676231616";
		new Selenium(0,url).start();
//		new Selenium(1,url).start();
//		new Selenium(2,url).start();
	} 
}
