package https;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test {

	private static String url = "http://www.sina.com";
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// / 设置GET请求参数，URL一定要以"http://"开头
		HttpGet getReq = new HttpGet(url);
		// / 设置请求报头，模拟Chrome浏览器
		getReq.addHeader("Accept",
				"application/json, text/javascript, */*; q=0.01");
		getReq.addHeader("Accept-Encoding", "gzip,deflate,sdch");
		getReq.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		getReq.addHeader("Content-Type", "text/html; charset=UTF-8");
		getReq
				.addHeader(
						"User-Agent",
						"Mozilla/5.0 (Windows NT 5.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.76 Safari/537.36");
		// / 发送GET请求
		CloseableHttpResponse rep = httpClient.execute(getReq);
		// / 从HTTP响应中取出页面内容
		HttpEntity repEntity = rep.getEntity();
		String content = EntityUtils.toString(repEntity);
		// / 打印出页面的内容：
		System.out.println(content);
		// / 关闭连接
		rep.close();
		httpClient.close();
	}

}
