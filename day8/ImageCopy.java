package com.celcom.day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {

	public static void main(String[] args) throws IOException {
		FileInputStream fi = new FileInputStream("D:\\TrainingUtils\\scenery.jpg");
		FileOutputStream fo = new FileOutputStream("D:\\TrainingUtils\\scenery1.jpg");
		int ch = 0;
		while ((ch = fi.read()) != -1) {
			fo.write(ch);
		}
		fi.close();
		fo.close();
		System.out.println("Image Copied");

	}

}
