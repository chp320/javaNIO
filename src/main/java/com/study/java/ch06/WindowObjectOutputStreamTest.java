package com.study.java.ch06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WindowObjectOutputStreamTest {
	
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		HelloWindow hwin = new HelloWindow();
		
		try {
			fos = new FileOutputStream("hwin.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(hwin);		// HelloWindow 객체 생성 후 마샬링해서 hwin.dat 파일에 저장
			oos.reset();
			
			System.out.println("저장되었습니다.");
			hwin.setVisible(true);		// 화면에 window 출력
		} catch(Exception e) {
			//
		} finally {
			try {
				oos.close();
				fos.close();
			} catch(IOException ie) {}
		}	// end of finally
	}	// end of main
}	// end of class
