package com.east.io.myutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月25日 下午8:08:13       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class LogUtil {
	public static void main(String[] args) {
		PrintLog("好会计本科", "e:\\log.txt");
	}

	/**
	 * 默认构造器
	 */
	private LogUtil() {

	}

	/**
	 * 写入一个日记
	 * @param log
	 * @param path
	 */
	public static void PrintLog(String log, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(path), true);
			fos.write(("\r\n" + log).getBytes());
			fos.close();
		} catch (IOException e) {
			System.err.println("IO异常");
		}
	}

	/**
	 * 把一组日记写入文件
	 * @param logs
	 * @param path
	 */
	public static void PrintListLog(ArrayList<String> logs, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file, true);
			for (String log : logs) {
				fos.write(("\r\n" + log).getBytes());
			}
			fos.close();
		} catch (IOException e) {
			System.err.println("IO异常");
		}
	}

}
