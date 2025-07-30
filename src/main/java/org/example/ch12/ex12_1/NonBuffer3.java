package org.example.ch12.ex12_1;

import java.io.*;

/**
 * 파일 copy 진행 프로그레스바 추가
 */
public class NonBuffer3 {
    public static void main(String[] args) {
        try {
            // 파일을 복사하는 시작 시간을 설정
            long startTime =  System.currentTimeMillis();
            // 파일을 복사
            copy("/Users/leo/study/javaNIO/src/main/java/org/example/ch12/file-1.txt", "/Users/leo/study/javaNIO/src/main/java/org/example/ch12/ex12_1/file-2.txt");
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
            File source = new File(fromFile);
            long totalSize = source.length();  // 전체 파일 크기

            long copied = 0;
            int lastPercent = 0;

            in = new FileInputStream(source);
            out = new FileOutputStream(toFile);

            while (true) {
                int byteData = in.read();
                if (byteData == -1) { break; }
                out.write(byteData);
                copied++;

                int percent = (int)((copied * 100) / totalSize);
                if (percent != lastPercent) {
                    printProgressBar(percent);
                    lastPercent = percent;
                }
            }

            printProgressBar(100);  // 마지막 100% 보장
            System.out.println(" (완료)");
        } finally {
            // 다 사용한 스트림을 안전하게 닫는다.
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        }
    }

    private static void printProgressBar(int percent) {
        final int BAR_WIDTH = 50;  // 프로그레스 바 총 길이
        int filledLength = (percent * BAR_WIDTH) / 100;

        StringBuilder bar = new StringBuilder();
        bar.append("\r진행률: [");
        for (int i = 0; i < BAR_WIDTH; i++) {
            if (i < filledLength) {
                bar.append("█");  // 채운 부분
            } else {
                bar.append("-");  // 남은 부분
            }
        }
        bar.append("] ").append(percent).append("%");

        System.out.print(bar.toString());
    }
}
