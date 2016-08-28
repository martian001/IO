package com.east.io.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年6月4日 下午8:48:04      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile accessFile = new RandomAccessFile(new File("C:\\Users\\Administrator\\Desktop\\第一组java总结.doc"), "rw");
		accessFile.setLength((long) (1024 * 1024 * 2.30));
	}
}
