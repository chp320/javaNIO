package org.example.ch12.ex12_2;

import java.io.*;

/**
 * 2048 byte 의 버퍼 크기를 갖는 "Buffered" 스트림을 연결해서 파일을 복사
 * - (2048 byte) SmallBuffer 처리시간: 51789 milliseconds
 * - (4096 byte) SmallBuffer 처리시간: 47625 milliseconds
 */
public class SmallBuffer {
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            copy("/Users/leo/study/javaNIO/src/main/java/org/example/ch12/file-1.txt", "/Users/leo/study/javaNIO/src/main/java/org/example/ch12/ex12_2/file-2.txt");
            long endTime =  System.currentTimeMillis();
            System.out.println("SmallBuffer 처리시간: " + (endTime - startTime) + " milli seconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(String fromFile, String toFile) throws IOException {
        InputStream inBuffer = null;
        OutputStream outBuffer = null;

        try {
            // 파일을 읽고 쓸 때 2048 byte 의 크기를 갖는
            // 버퍼스트림으로 버퍼링하면서 파일을 복사
            InputStream in = new FileInputStream(fromFile);
            inBuffer = new BufferedInputStream(in, 4096);
            OutputStream out = new FileOutputStream(toFile);
            outBuffer = new BufferedOutputStream(out, 4096);

            while (true) {
                int byteData = inBuffer.read();
                if (byteData == -1) { break; }
                out.write(byteData);
            }
        } finally {
            // 스트림 종료
            if (inBuffer != null) { inBuffer.close(); }
            if (outBuffer != null) { outBuffer.close();}
        }
    }
}
