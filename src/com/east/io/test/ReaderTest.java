package com.east.io.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月22日 下午4:32:37        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class ReaderTest {
	public static void main(String[] args) throws IOException {
		// r();
		Reader reader = new FileReader("F:\\homework-eclipse\\IO\\src\\com\\east\\io\\test\\OutputStreamTest2.java");
		char[] b = new char[1024];
		int temp = 0;
		while ((temp = reader.read(b)) != -1) {
			System.out.println(new String(b, 0, temp));
		}
	}

	private static void r() throws IOException {
		try {
			Reader reader = new FileReader("F:\\homework-eclipse\\IO\\src\\com\\east\\io\\test\\OutputStreamTest2.java");
			int temp = 0;
			while ((temp = reader.read()) != -1) {
				// reader.skip(1);
				System.out.print((char) temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
