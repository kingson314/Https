package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;


/**
 * httpclient https
 * 
 */
public class HTTPSSecureProtocolSocketFactory {// SecureProtocolSocketFactory
//	public static void main(String[] args) throws Exception {
		// Log in
//		Connection.Response login = Jsoup.connect("https://www.cpes-sipo.net").data(
//				"username", "dongqingwei@sipo.gov.cn").data("password", "111111").method(
//				Method.POST).execute();
//		Map<String, String> loginCookies = login.cookies();
//		System.setProperty("javax.net.ssl.trustStore",
//				"/Users/philipjakobsen/Desktop/login.emu.dk.jks");
//		System.setProperty("javax.net.ssl.trustStore",
//				"/Users/philipjakobsen/Desktop/login.emu2.dk.jks");
//		Document doc = Jsoup.connect("https://www.cpes-sipo.net/txnCaseListPage.do").cookies(
//				loginCookies).get();
//		System.out.println(doc.html());
//	}
	public static void main(String[] args) throws Exception {
		String url = "https://www.cpes-sipo.net/txnCaseListPage.do";
		trustAllHttpsCertificates();
			HostnameVerifier hv = new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					// TODO Auto-generated method stub
					return false;
				}
				};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
		Document doc = Jsoup.connect(url).userAgent("Mozilla").post();
		System.out.println(doc.html());
	
	}
		private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
		.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
		.getSocketFactory());
		}

		static class miTM implements javax.net.ssl.TrustManager,
		javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
		}

		public boolean isServerTrusted(
		java.security.cert.X509Certificate[] certs) {
		return true;
		}

		public boolean isClientTrusted(
		java.security.cert.X509Certificate[] certs) {
		return true;
		}

		public void checkServerTrusted(
		java.security.cert.X509Certificate[] certs, String authType)
		throws java.security.cert.CertificateException {
		return;
		}

		public void checkClientTrusted(
		java.security.cert.X509Certificate[] certs, String authType)
		throws java.security.cert.CertificateException {
		return;
		}
		}

}
