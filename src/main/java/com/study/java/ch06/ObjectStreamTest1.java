package com.study.java.ch06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class ObjectStreamTest1 
{
    public static void main( String[] args )
    {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        Vector v = new Vector();
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        
        v1.addElement(new String("data 1"));
        v1.addElement(new String("data 2"));
        v1.addElement(new String("data 3"));
        v2.addElement(new String("data 4"));
        v3.addElement(v2);
        v.addElement(v1);
        v.addElement(v3);
        
        try {
        	fout = new FileOutputStream("object.dat");		// 파일에 저장하기 위한 스트림 (object.dat 파일 생성)
        	oos = new ObjectOutputStream(fout);				// 객체를 저장하기 위한 스트림
        	
        	oos.writeObject(v);		// 인자로 전달된 Object 를 스트림으로 출력. vector 객체를 FileOutputStream 을 통해 파일로 출력
        	oos.reset();			// writeObject() 호출 후 반드시 호출 (메모리릭 방지)
        	System.out.println("저장되었습니다.");
        } catch (Exception e) {
        	//
        } finally {
        	try {
        		oos.close();
        		fout.close();
        	} catch (IOException ie) {}
        }	// end of finally
    }	// end of main
}	// end of class
