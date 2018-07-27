package com.accper.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

/**
 * hadle picture
 * 
 * @author taoye
 *
 */
public class Main {

	// 照片文件的数量
	private final static int PIC_NUM = 20;
	private final static String SUFFIX = ".JPG";

	/**
	 * 处理照片不足20张的情况，复制凑齐20张，并保证文件命名规范
	 * 
	 * @param absolutePath
	 *            绝对路径
	 */
	public static void handlePic(String absolutePath) {
		if (absolutePath == null || absolutePath == "") {
			System.out.println("the file path is not right....");
			return;
		}
		try {
			File file = new File(absolutePath);
			if (file.isDirectory()) { // 如果file是文件夹,递归遍历
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					handlePic(files[i].getAbsolutePath());
				}
			} else if (file.isFile()) { // 如果是文件
				// 核心处理
				int num = file.getParentFile().listFiles().length;
				if (num <= Main.PIC_NUM) {
					if(file.getName().contains(Main.SUFFIX)){
						copyPic(file.getParent());	
					}
				}
				System.out.println("processing, please wait...");
			} else {
				System.out.println("the file path is illegal....");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 处理文件拷贝文件夹下面的文件，并符合命名规范
	 * 
	 * @param absoluatePath
	 *            绝对路径
	 */
	public static void copyPic(String absolutePath) {
		if (absolutePath == null || absolutePath == "") {
			System.out.println("the file path is not right....");
			return;
		}
		File file = new File(absolutePath);
		File[] files = file.listFiles();
		int num = files.length;
		Random random = new Random();
		while (num <= Main.PIC_NUM) {
			int index = random.nextInt(files.length);
			copy(files[index],files[index].getName().split("\\.")[0]+num+Main.SUFFIX);
			num++;
		}
	}

	/**
	 * 在原始文件的目录下，复制该文件
	 * 
	 * @param file
	 *            原始文件
	 * @param newFileName
	 *            新文件的命名
	 */
	public static void copy(File file, String newFileName) {
		FileInputStream ins = null;
		FileOutputStream out = null;
		try {
			ins = new FileInputStream(file);
			out = new FileOutputStream(new File(file.getParent() + "/"
					+ newFileName));
			byte[] b = new byte[1024];
			int n = 0;
			while ((n = ins.read(b)) != -1) {
				out.write(b, 0, n);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void test() {
//		File file = new File(
//				"C:/Users/optimais/Desktop/face_ivt/12/120/120_20171204131107335.JPG");
//		copy(file, "120_20171204131107110.JPG");
//		copyPic("C:/Users/optimais/Desktop/face_ivt/12/120");
		handlePic("C:/Users/optimais/Desktop/face_ivt");
		System.out.println("the process is end....");
	}
}
