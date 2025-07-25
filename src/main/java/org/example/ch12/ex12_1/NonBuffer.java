package org.example.ch12.ex12_1;

import java.io.*;

public class NonBuffer {
    public static void main(String[] args) {
        try {
            // 파일을 복사하는 시작 시간을 설정
            long startTime =  System.currentTimeMillis();
            // 파일을 복사
            copy("/Users/leo/Downloads/file-1.txt", "/Users/leo/Downloads/file-2.txt");
            // 파일을 복사한 종료 시간을 기록
            long endTime =  System.currentTimeMillis();
            // 복사한 시간이 얼마나 되는지 출력
            System.out.println("NonBuffer 처리 시간: " + (endTime - startTime) + " milli seconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(String fromFile, String toFile) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(fromFile);
            out = new FileOutputStream(toFile);
            while (true) {
                // 1 바이트 읽음
                int byteData = in.read();
                // EOF 인 경우 종료
                if (byteData == -1) { break; }
                // 앞에서 읽은 1 바이트를 파일에 쓴다.
                out.write(byteData);
            }
        } finally {
            // 다 사용한 스트림을 안전하게 닫는다.
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        }
    }
}
