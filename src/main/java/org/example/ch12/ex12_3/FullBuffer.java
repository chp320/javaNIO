package org.example.ch12.ex12_3;

import java.io.*;

/**
 * 파일 크기만큼 버퍼로 사용
 * - FullBuffer 처리시간: 38 milli seconds
 */
public class FullBuffer {
    public static void main(String[] args) {
        try {
            long startTime =  System.currentTimeMillis();
            copy("/Users/leo/study/javaNIO/src/main/java/org/example/ch12/file-1.txt", "/Users/leo/study/javaNIO/src/main/java/org/example/ch12/ex12_3/file-2.txt");
            long endTime =  System.currentTimeMillis();
            System.out.println("FullBuffer 처리시간: " + (endTime - startTime) + " milli seconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(String fromFile, String toFile) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            // 파일 오픈
            in = new FileInputStream(fromFile);
            out = new FileOutputStream(toFile);

            // 파일 크기 계산 (byte)
            int availableLength = in.available();
            System.out.println("file size: " + availableLength);

            // 파일 크기만큼 byte[] 형태의 버퍼 생성
            byte buffer[] = new byte[availableLength];

            // 버퍼로 파일 read
            int byteData = in.read(buffer);

            // 파일 저장
            out.write(buffer);

        } finally {
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        }
    }
}
