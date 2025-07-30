package org.example.ch12.ex12_3;

import java.io.*;

/**
 * 파일 크기만큼 버퍼 사용하는 기능 구현
 * - FullBuffer 와 차이점은
 * 1) FileInputStream 의 available() 을 사용하지 않고, File.length() 로 크기를 확인
 * 2) 파일 전체로 잡을 경우, 사이즈가 과도하게 크면 oom 발생 가능성 존재 -> 따라서 일반적인 디스크 블록 크기인 4096 byte 만큼 버퍼 사이즈 설정
 * 참고) OS 는 파일을 1 바이트 단위로 저장하지 않고, 여러 바이트를 묶어서 "블록" 단위로 저장/읽기하며 1 블록 = 4096 바이트
 */
public class FullBuffer2 {
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
            File source =  new File(fromFile);
            long totalSize = source.length();       // 전체 파일 크기 (바이트 단위)

            // 파일 오픈
            in = new FileInputStream(source);
            out = new FileOutputStream(toFile);

            // 파일 크기만큼 byte[] 형태의 버퍼 생성
            byte buffer[] = new byte[4096];

            long copied = 0;
            int bytesRead;
            int lastPercent = 0;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                copied += bytesRead;

                // 진행률 계산
                int percent = (int) ((copied * 100) / totalSize);
                if (percent != lastPercent) {
                    System.out.print("\r진행률: " + percent + "%");
                    lastPercent = percent;
                }
            }

            System.out.println("\r진행률: 100% (완료)");

        } finally {
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        }
    }
}
