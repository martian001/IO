package com.east.io.myutils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年7月19日 下午3:16:17      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★

注意多线程访问
 */
public class RandomImageUtil {

	/**
	 * 矩形的宽
	 */
	private final int WIDTH = 120;

	/**
	 * 矩形的高
	 */
	private final int HEIGHT = 35;

	/**
	 * 随机的字符穿内容
	 */
	private final String CONTENT = "笔记本扣低保看阿克苏减肥呢了是否把谁的故事苟富贵接口是否啊空降兵";

	/**
	 * 验证码字符串
	 */
	private StringBuffer verificationCode = new StringBuffer();

	/**
	 * 实例化RandomImage
	 */
	private final static RandomImageUtil RI = new RandomImageUtil();

	/**
	 * 构造器私有化
	 */
	private RandomImageUtil() {
		
	}

	/**
	 * 获取本类实例
	 * @return
	 */
	public static RandomImageUtil getInstance() {
		return RI;
	}

	/**
	 * 获取验证码图片
	 * @return
	 */
	public BufferedImage getRandomImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		//1.设置背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);//填充指定的矩形

		//2.设置边框
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);

		//3.画干扰线
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			//头坐标
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			//尾坐标
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}

		//4.写随机数
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		int x = 5;
		int degree = 0;
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < 4; i++) {
			degree = new Random().nextInt() % 30;//-30-30的数字
			char ch = CONTENT.charAt(new Random().nextInt(CONTENT.length()));
			g2d.rotate((degree * Math.PI) / 180, x, 20);//设置旋转
			g.drawString(String.valueOf(ch), x, 20);//添加字体
			g2d.rotate((-degree * Math.PI) / 180, x, 20);//恢复旋转
			x += 30;
			verificationCode.append(ch);
		}
		return image;
	}

	/**
	 * 返回验证字符串
	 * @return
	 */
	public String getVerificationCode() {
		String string = verificationCode.toString();
		verificationCode = null;
		verificationCode = new StringBuffer();
		return string;
	}
}
