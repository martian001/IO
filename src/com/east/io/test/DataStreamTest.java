package com.east.io.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月24日 上午10:40:03      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class DataStreamTest {
	public static void main(String[] args) throws IOException {
		/**
		 * 数据输出流
		 */
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("e:\\User.txt")));
		dataOutputStream.writeInt(12);
		dataOutputStream.writeInt(13);
		dataOutputStream.writeBoolean(true);
		dataOutputStream.close();
		/**
		 * 数据输入流
		 */
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("e:\\User.txt")));
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readBoolean());
	}
}
