package com.celcom.day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyExample {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("D://TrainingUtils/Data_File.txt");
		FileWriter fw=new FileWriter("D://TrainingUtils/Data_File1.txt");
		int ch=0;
		while((ch=fr.read())!=-1) {
			fw.write(ch);
		}
	/*	FileInputStream fi=new FileInputStream("D://TrainingUtils/Data_File.txt");
		FileOutputStream fo=new FileOutputStream("D://TrainingUtils/Data_File2.txt");
		byte ch1=0;
		while((ch1=(byte) fi.read())!=-1) {
			fo.write(ch1);
		}
		fi.close();
		fo.close(); */
			
		fr.close();
		fw.close();
		System.out.println("File Copied");
	}
}
