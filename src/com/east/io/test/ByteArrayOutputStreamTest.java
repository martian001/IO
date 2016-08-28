package com.east.io.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月24日 上午10:34:43        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class ByteArrayOutputStreamTest {
	public static void main(String[] args) {
		/**
		 * 字节数组输出流
		 */
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byteArrayOutputStream.write(11);
		byteArrayOutputStream.write(12);
		byteArrayOutputStream.write(13);
		byteArrayOutputStream.write(14);
		byteArrayOutputStream.write(15);
		byte[] byteArray = byteArrayOutputStream.toByteArray();
		for (byte b : byteArray) {
			System.out.println(b);
		}
		/**
		 * 字节数组输入流
		 */
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
		int temp = 0;
		while ((temp = byteArrayInputStream.read()) != -1) {
			System.out.println(temp);
		}
	}
}
