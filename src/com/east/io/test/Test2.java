package com.east.io.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月25日 下午4:19:01        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Test2 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile(new File("E:\\random.txt"), "rw");
			// raf.writeChars("个厉害");
			// raf.write("个厉害".getBytes());
			// raf.writeUTF("* 模板方法设计模式* 含义：* 在定义功能时，功能的一部分是确定的，但是有\r\n一部分是不确定的（runcode()），而确定的一部分在使用不确定的部分，* 那么这时就将不确定的一部分暴露出去，由该类（sudtime）去完成。* 记住：方法和类不一定是抽象");
			// System.out.println(raf.readUTF());
			System.out.println(raf.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
