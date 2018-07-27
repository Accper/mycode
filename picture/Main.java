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

	// ��Ƭ�ļ�������
	private final static int PIC_NUM = 20;
	private final static String SUFFIX = ".JPG";

	/**
	 * ������Ƭ����20�ŵ���������ƴ���20�ţ�����֤�ļ������淶
	 * 
	 * @param absolutePath
	 *            ����·��
	 */
	public static void handlePic(String absolutePath) {
		if (absolutePath == null || absolutePath == "") {
			System.out.println("the file path is not right....");
			return;
		}
		try {
			File file = new File(absolutePath);
			if (file.isDirectory()) { // ���file���ļ���,�ݹ����
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					handlePic(files[i].getAbsolutePath());
				}
			} else if (file.isFile()) { // ������ļ�
				// ���Ĵ���
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
	 * �����ļ������ļ���������ļ��������������淶
	 * 
	 * @param absoluatePath
	 *            ����·��
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
	 * ��ԭʼ�ļ���Ŀ¼�£����Ƹ��ļ�
	 * 
	 * @param file
	 *            ԭʼ�ļ�
	 * @param newFileName
	 *            ���ļ�������
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
