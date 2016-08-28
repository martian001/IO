package com.east.io.myutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**该工具类应用于统计目录下所有java文件的代码和注释的行数 
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年4月25日 下午8:34:12       ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：代码工具类                              ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StatisticsCodeUtil {
   public static void main(String[] args) throws IOException {
      long begin = System.currentTimeMillis();
      StatisticsJavaFile(new File("F:\\eclipse_workspace\\"));
      System.out.println("该目录java文件总数：" + javaCount + ",有效代码总行数：" + sumCode + "(不包含空行),总有效注释：" + sumAnnotation);
      long end = System.currentTimeMillis();
      // System.out.println(end - begin);
   }

   /**
    * 目录下所有java文件总数
    */
   public static int javaCount = 0;

   /**
    * 单个java文件的有效代码行数
    */
   private static int fileAnnotationNumber = 0;

   /**
    * 单个java文件的有效代码行数
    */
   private static int fileCodeNumber = 0;

   /**
    * 目录下所有java文件加起来的有效代码行数
    */
   public static int sumCode = 0;

   /**
    * 目录下所有java文件加起来的有效注释行数
    */
   public static int sumAnnotation = 0;

   /**
    * 默认构造器
    */
   private StatisticsCodeUtil() {

   }

   /**
    *过滤目录下的所有java文件，并且过滤出来的java文件进行统计单个java文件代码行数和注释行数
    * @param file
    * @param name
    * @throws IOException 
    */
   public static void StatisticsJavaFile(File file) {
      if (!file.exists()) {
         return;
      }
      File[] listFiles = file.listFiles();
      if (null == listFiles) {
         return;
      }
      for (File f : listFiles) {
         if (f.isDirectory()) {
            StatisticsJavaFile(f);
         } else if (f.toString().endsWith(".java")) {
            System.out.println(f);
            javaCount++;
            StatisticsAnnotationAndCode(f.getPath());
         }
      }
   }

   /**
    * 统计单个java文件代码行数和注释行数（代码行数不包括空的一行，注释包括单行，多行和文档注释）
    * @param path：要统计的java文件路径
    */
   public static void StatisticsAnnotationAndCode(String path) {
      fileAnnotationNumber = 0;
      fileCodeNumber = 0;
      try {
         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));
         String line = "";
         while (null != (line = br.readLine())) {
            if (line.matches("[\\s]*[/]{2,}.*")) {// 判断单行注释
               fileAnnotationNumber++;
            } else if (line.matches("[\\s]*[/][*].*[*][/]")) {// 判断特殊多行注释，如:/*注释*/
               fileAnnotationNumber++;
            } else if (line.matches("[\\s]*[/][*].*[*]{2}[/]")) {// 判断特殊文档注释，如:/**注释*/
               fileAnnotationNumber++;
            } else if (line.matches("[\\s]*[/][*][^*]*")) {// 判断正常的多行注释
               nextAnnotationLine(br);
            } else if (line.matches("[\\s]*[/][*]{1,}.*")) {// 判断正常的文档注释
               nextAnnotationLine(br);
            } else if (line.trim().length() != 0) {// 判断是否为 有效代码，不包括空行
               fileCodeNumber++;
            }
         }
         sumCode = fileCodeNumber + sumCode;
         sumAnnotation = fileAnnotationNumber + sumAnnotation;
         System.out.println("注释行数：" + fileAnnotationNumber);
         System.out.println("代码行数：" + fileCodeNumber);
      } catch (IOException e) {
         System.err.println("IO异常");
      }
   }

   /**
    * 继续读取注释，这个方法是StatisticsAnnotationAndCode中抽取出来的，当读到单行或者文档注释结尾的时候就会结束该方法
    * @param br
    * @throws IOException
    */
   private static void nextAnnotationLine(BufferedReader br) throws IOException {
      String line = "";
      fileAnnotationNumber++;
      while (null != (line = br.readLine())) {
         fileAnnotationNumber++;
         if (line.matches(".*[*][/][\\s]*")) {
            break;
         }
      }
   }
}
