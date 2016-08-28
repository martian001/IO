package com.east.io.work;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月22日 下午6:01:54        ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class Util {
	/**
	 * 读取文件内容（使用UTF-8编码）
	 * @param filePath 输出文件路径
	 * @return
	 * @throws Exception
	 */
	public static String readFileUTF8(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
		String fileContent = "";
		String temp = "";
		while ((temp = br.readLine()) != null) {
			fileContent = fileContent + temp;
		}
		br.close();
		fis.close();
		return fileContent;
	}

	/**
	 * 将文件内容写入文件（使用UTF-8编码）
	 * @param content 文件内容
	 * @param filePath  输出文件路径
	 * @throws Exception
	 */
	public static void writeFileUTF8(String content, String filePath) throws Exception {
		createDir(filePath);
		File file = new File(filePath);
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
		bw.write(content);
		bw.flush();
		bw.close();
		fos.close();

	}

	/**
	 * 写文件
	 * @param outputPath 输出文件路径
	 * @param is 输入流
	 * @param isApend 是否追加
	 * @throws IOException
	 */
	public static void writeFile(InputStream is, String outputPath, boolean isApend) throws IOException {
		FileInputStream fis = (FileInputStream) is;
		createDir(outputPath);
		FileOutputStream fos = new FileOutputStream(outputPath, isApend);
		byte[] bs = new byte[1024 * 16];
		int len = -1;
		while ((len = fis.read(bs)) != -1) {
			fos.write(bs, 0, len);
		}
		fos.close();
		fis.close();
	}

	/**
	 * copy文件
	 * @param is 输入流
	 * @param outputPath 输出文件路径
	 * @throws Exception
	 */
	public static void writeFile(InputStream is, String outputPath) throws Exception {
		InputStream bis = null;
		OutputStream bos = null;
		createDir(outputPath);
		bis = new BufferedInputStream(is);
		bos = new BufferedOutputStream(new FileOutputStream(outputPath));
		byte[] bs = new byte[1024 * 10];
		int len = -1;
		while ((len = bis.read(bs)) != -1) {
			bos.write(bs, 0, len);
		}
		bos.flush();
		bis.close();
		bos.close();
	}

	/**
	 * 写文件
	 * @param outputPath 输出文件路径
	 * @param inPath 输入文件路径
	 * @throws IOException
	 */
	public static void writeFile(String inPath, String outputPath, boolean isApend) throws IOException {
		if (new File(inPath).exists()) {
			FileInputStream fis = new FileInputStream(inPath);
			writeFile(fis, outputPath, isApend);
		} else {
			System.out.println("文件copy失败，由于源文件不存在!");
		}
	}

	/**
	 * 将字符串写到文件内
	 * @param outputPath 输出文件路径
	 * @param msg 字符串
	 * @param isApend  是否追加
	 * @throws IOException
	 */
	public static void writeContent(String msg, String outputPath, boolean isApend) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath, isApend));
		bw.write(msg);
		bw.flush();
		bw.close();
	}

	/**
	 * 删除文件夹下的所有内容,包括本文件夹
	 * @param path 删除文件路径
	 * @throws IOException
	 */
	public static void delFileOrDerectory(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					File subFile = files[i];
					delFileOrDerectory(subFile.getAbsolutePath());
				}
				file.delete();
			} else {
				file.delete();
			}
		}
	}

	/**
	 * 如果欲写入的文件所在目录不存在，需先创建
	 * @param outputPath 输出文件路径
	 */
	public static void createDir(String outputPath) {
		File outputFile = new File(outputPath);
		if (!outputFile.exists()) {
			outputFile.mkdirs();
		}
	}

}
