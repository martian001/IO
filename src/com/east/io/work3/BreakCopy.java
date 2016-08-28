package com.east.io.work3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月26日 上午10:59:32      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class BreakCopy {
	public static void main(String[] args) throws IOException {
		breakCopy(new File("E:\\easy photo\\1231户外活动照片\\101_1231\\IMGP2581.JPG"), new File("e:\\IMGP2581.JPG"));

	}

	/**
	 * 断点下载
	 * @param src:源文件
	 * @param target：目标
	 * @throws IOException
	 */
	public static void breakCopy(File src, File target) throws IOException {
		RandomAccessFile reader = new RandomAccessFile(src, "r");
		RandomAccessFile write = new RandomAccessFile(target, "rw");
		// 跳过上次已经下载过的内容
		double mark = target.length();
		reader.seek((long) mark);
		write.seek((long) mark);

		int count = 0;
		int length = 0;
		byte[] b = new byte[1024];
		while ((length = reader.read(b)) > -1) {
			write.write(b, 0, length);
			mark = mark + length;
			System.out.println("下载进度：" + (100 / (src.length() / mark)) + "%");
			//控制断点
			if (count++ == (1024 * 1)) {
				break;
			}
		}
		//判断文件已经完全下载
		if (reader.length() == write.length()) {
			System.out.println("下载成功！");
		}
		reader.close();
		write.close();
	}

}
