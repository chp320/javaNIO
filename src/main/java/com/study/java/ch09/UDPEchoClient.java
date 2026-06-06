package com.study.java.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("사용법: java UDPEchoClient <ip> <port>");
			System.exit(1);
		}
		
		String ip = args[0];
		int port = 0 ;
		
		try {
			port = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("port 번호는 양의 정수로 입력해야 함");
			System.exit(1);
		}
		
		InetAddress inetaddr = null;
		try {
			inetaddr = InetAddress.getByName(ip);
		} catch (Exception e) {
			System.out.println("잘못된 도메인이나 IP임");
			System.exit(1);
		}
		
		DatagramSocket dsock = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			dsock = new DatagramSocket();
			String line = null;
			while((line = br.readLine()) != null) {
				
				// 전송
				DatagramPacket sendPacket = new DatagramPacket(line.getBytes(),
															   line.getBytes().length,
															   inetaddr,
															   port);
				dsock.send(sendPacket);
				
				if(line.equals("quit")) {
					break;
				}
				
				// 수신
				byte[] buffer = new byte[line.getBytes().length];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				
				// 수신 데이터 출력
				String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);
				System.out.println("전송받은 문자열: " + msg);
				
			}	// end of while
			
			System.out.println("UDPEchoClient 종료");
					
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if(dsock != null) {
				dsock.close();
			}
		}
		
	}	// end of main
}	// end of class
