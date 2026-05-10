package com.study.java.ch06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WindowObjectInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("hwin.dat");
			ois = new ObjectInputStream(fis);
			
			HelloWindow hwin = (HelloWindow)ois.readObject();
			hwin.setVisible(true);
		} catch(Exception e) {
		} finally {
			try {
				fis.close();
				ois.close();
			} catch(IOException ie) {}
		}	// end of finally
	}	// end of main
}	// end of class
