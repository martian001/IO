package com.east.io.work3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年5月5日 下午9:29:19      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class NetWordDownload {
	public static void main(String[] args) throws IOException {
		String http = "http://g.hiphotos.baidu.com/image/w%3D2048/sign=9dfb6ee460d9f2d3201123ef9dd48a13/0d338744ebf81a4cb700bdccd52a6059252da681.jpg";
		http = "http://10.200.3.148/[电影天堂www.dy2018.com]庞贝末日BD中英双字.rmvb?fid=D90LEeCz7vYuIeLN7Mq5SZ1xaUHYeu5IAAAAAED8VqyHCnY-oQitruOradU3zzY4&mid=666&threshold=150&tid=71146F6CC118F46BF48BE9B917F09F73&srcid=119&verno=1";
		HttpURLConnection connection = getURLcon(http);
		writerFile1(connection, "e:\\[电影天堂www.dy2018.com]庞贝末日BD中英双字.rmvb");
	}

	public static HttpURLConnection getURLcon(String http) throws IOException {
		URL url = new URL(http);
		// 根据URL，发送http请求
		HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();// 打开连接，通过向下转型获取urlcon对象
		urlcon.setRequestMethod("GET");// 设置请求方式
		urlcon.setConnectTimeout(5000);// 请求时间
		urlcon.setRequestProperty(
				"User-Agent",
				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/6.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E; InfoPath.2; doyo 2.6.1)");
		int respondCode = urlcon.getResponseCode();// 得到服务器返回的响应码3e
		if (respondCode == 200) {//返回200就成功
			return urlcon;
		}
		return null;
	}

	public static void writerFile1(HttpURLConnection urlcon, String outPath) throws IOException {
		InputStream inputStream = urlcon.getInputStream();
		int sum = urlcon.getContentLength();
		OutputStream os = new FileOutputStream(new File(outPath));
		int length = 0;
		double mark = 0;
		byte[] b = new byte[1024];
		while ((length = inputStream.read(b)) > -1) {
			os.write(b, 0, length);
			mark = length + mark;
			System.out.println("下载进度：" + (100 / (sum / mark)) + "%");
		}
		System.out.println("下载完成");
		os.close();
		inputStream.close();
	}
}
