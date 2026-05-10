package com.study.java.ch05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법: java StreamReaderTest <파일명>");
			System.exit(0);
		}	// end of if
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			
			fis = new FileInputStream(args[0]);
			isr = new InputStreamReader(fis);
			osw = new OutputStreamWriter(System.out);
			
			char[] buffer = new char[512];
			int readcount = 0;
			// read() - 문자 입력 스트림에서 buffer 크기만큼을 읽어 buffer에 저장하고 읽은 '문자수'를 반환
			// write() - buffer 의 offset 위치에서부터 len 만큼의 문자를 출력
			while((readcount = isr.read(buffer)) != -1) {
				osw.write(buffer, 0, readcount);
			}
			
		} catch(Exception e) {
		} finally {
			try {
				fis.close();
				isr.close();
				osw.close();
			} catch(IOException ie) {}
		}	// end of finally
	}	// end of main
}	// end of class
