package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Format {
	public static void main(String[] args) throws IOException {
		String splitStr="=";
		String filePath = "E:\\360云盘\\百度云\\Projects\\Repository\\test\\format.txt";
		String tmpline = "";
		int leftLen = 0;
		BufferedReader fReader = new BufferedReader(new FileReader(filePath));
		while ((tmpline = fReader.readLine()) != null) {
			if (tmpline.indexOf(splitStr) <= 0)
				continue;
			String leftStr = tmpline.substring(0, tmpline
					.indexOf(splitStr)).trim();
			int tmpLeftLen = leftStr.length();
			leftLen = Math.max(leftLen, tmpLeftLen);
		}
		fReader.close();
		fReader = new BufferedReader(new FileReader(filePath));
		while ((tmpline = fReader.readLine()) != null) {
			if (tmpline.indexOf(splitStr) <= 0) {
				System.out.println(tmpline.trim());
				continue;
			}
			String leftStr = tmpline.substring(0, tmpline
					.indexOf(splitStr)).trim();
			System.out.print(leftStr);
			for (int i = 0; i < leftLen - leftStr.length(); i++) {
				System.out.print(" ");
			}
			System.out.println(splitStr+" "+tmpline.substring(tmpline.indexOf(splitStr)+1).trim());
		}
		fReader.close();

	}
}
