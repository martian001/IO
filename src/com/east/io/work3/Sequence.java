package com.east.io.work3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年5月3日 上午11:19:33      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Sequence {
	public static void main(String[] args) {
		//		String[] s = { "E:\\MyMusic\\Tf家族 - 董小姐.mp3", "E:\\MyMusic\\-yes周杰伦 把JAY15首歌串了起来唱的很动听.mp3" };
		String[] s = { "E:\\contract.txt", "E:\\合同.txt" };
		new Sequence().sequence(s, "e:\\333.txt");
	}

	/**
	 * 合并，该方法适合合并多个文本或者合并多个音乐文件，顺序以传入数组元素顺序为准
	 * @param file
	 * @param target
	 */
	public void sequence(String[] file, String target) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(target), true);
			RandomAccessFile raf;
			for (int i = 0; i < file.length; i++) {
				raf = new RandomAccessFile(new File(file[i]), "r");
				byte[] b = new byte[1024];
				int length = 0;
				while ((length = raf.read(b)) > -1) {
					fos.write(b, 0, length);
				}
			}
			System.out.println("合并成功。");
		} catch (IOException e) {
			System.err.println("IO异常");
		}
	}
}
