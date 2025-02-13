package com.celcom.day8;

import java.io.FileReader;
import java.io.IOException;

public class IOExample1 {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("D://TrainingUtils/Data_File.txt");
		int ch=0;
		while((ch=fr.read())!=-1) {
			System.out.println((char)ch);
		}
		fr.close();
	}

}
