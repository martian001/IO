package com.east.io.myutils;

/**
 * 说明：
 * 每一个线程下载的位置计算方式：
 * 开始位置：
 * (线程id - 1)*每一块大小
 * 结束位置：
 * (线程id*每一块大小) - 1 
 *  ---注意有时候不一定能够整除，所以最后一个线程的结束位置应该是文件的末尾
 *  
 *  步骤：
 *  1.本地创建一个大小跟服务器文件相同的临时文件
 *  2.计算分配几个线程去下载服务器上的资源，知道每个线程下载文件的位置
 *  3.开启三个线程，每一个线程下载对应位置的文件
 *  4.如果所有的线程，都把自己的数据下载完毕后，服务器上的资源都被下载到本地了
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class ThreadDownload {
	public static int threadCount = 2;

	public static void main(String[] args) throws Exception {
		File f = new File("E:\\easy photo\\1231户外活动照片\\101_1231\\IMGP2581.JPG");
		InputStream is = new FileInputStream(f);
		int length = (int) f.length();
		RandomAccessFile raf = new RandomAccessFile("E:\\IMGP2581.JPG", "rwd");
		//指定创建的这个文件的长度  
		raf.setLength(length);
		raf.close();
		//平均每一个线程下载的文件大小.
		int blockSize = length / threadCount;
		for (int threadId = 1; threadId <= threadCount; threadId++) {
			//第一个线程下载的开始位置
			int startIndex = (threadId - 1) * blockSize;
			int endIndex = (threadId * blockSize) - 1;
			if (threadId == threadCount) {//最后一个线程下载的长度要稍微长一点
				endIndex = length;
			}
			is = new FileInputStream(f);
			System.out.println("线程：" + threadId + "下载:---" + startIndex + "--->" + endIndex);
			new Thread(new DownLoadThread(is, threadId, startIndex, endIndex)).start();
		}
	}

	/**
	 * 下载文件的子线程  每一个线程下载对应位置的文件
	 * @author jie
	 *
	 */
	public static class DownLoadThread implements Runnable {
		private final int threadId;
		private final int startIndex;
		private final int endIndex;
		private final InputStream is;

		public DownLoadThread(InputStream is, int threadId, int startIndex, int endIndex) {
			this.is = is;
			this.threadId = threadId;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}

		@Override
		public void run() {
			try {
				RandomAccessFile raf = new RandomAccessFile("E:\\IMGP2581.JPG", "rwd");
				raf.seek(startIndex);
				is.skip(startIndex);
				int len = 0;
				double sum = 0;
				byte[] buffer = new byte[1024];
				while (((len = is.read(buffer)) > -1) && (sum <= endIndex)) {
					raf.write(buffer, 0, len);
					sum = len + sum;
					System.out.println("线程：" + threadId + "   下载进度：" + (100.0 / (endIndex / sum)) + "%");
				}
				is.close();
				raf.close();
				System.out.println("线程：" + threadId + "下载完毕");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}