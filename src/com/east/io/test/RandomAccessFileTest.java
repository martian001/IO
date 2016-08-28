package com.east.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月23日 上午11:32:00      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class RandomAccessFileTest {
	public static void main(String[] args) {
		// t1();
		try {
			RandomAccessFile random = new RandomAccessFile(new File("e:\\zz.txt"), "rw");
			random.writeBytes("梁衍君");
			random.writeInt(20);
			random.writeBytes("唐冬明");
			random.writeInt(24);
			System.out.println("ok");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void t1() {
		try {
			RandomAccessFile random = new RandomAccessFile(new File("F:\\注册信息.txt"), "rw");
			FileOutputStream outputStream = new FileOutputStream(new File("e:\\zz.txt"));
			// random.seek(1);
			int temp = 0;
			while ((temp = random.read()) != -1) {
				outputStream.write(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
