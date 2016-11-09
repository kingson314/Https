package test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJs extends Thread  {
	static{
		System.getProperties().setProperty("webdriver.chrome.driver", "E:\\AppData\\chromedriver_x64.exe"); //这个参数就是【chrome驱动器的位置】
	}
	private int index;
	private String url;
	public SeleniumJs(int idx,String url){
		this.index=idx;
		this.url=url;
	}

	public  void run(){
		long now=System.currentTimeMillis();
		 WebDriver webDriver = new ChromeDriver();  
		 webDriver.get(url);  
		 WebElement rootElement = webDriver.findElement(By.tagName("img"));  
			 System.out.println("线程"+this.index+":                    "+rootElement.getAttribute("src"));
		 webDriver.close();  
		 webDriver.quit();
		System.out.println("线程"+this.index+"耗时:                    "+(System.currentTimeMillis()-now)/1000);
	}
	
	public static void main(String[] args) throws IOException {
		String url = "http://cpquery.sipo.gov.cn/txnCPQueryPublicFileView.do?select-key:fid=GA000101982783&select-key:wenjiandm=210403&select-key:wenjianlx=03&select-key:wendanglx=01&select-key:shenqingh=2013100541281";
		new SeleniumJs(0,url).start();
//		new SeleniumJs(1,url).start();
//		new SeleniumJs(2,url).start();
	} 
}
