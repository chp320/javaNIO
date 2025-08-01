package org.example.ch7.ex7_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length != 1) {
            System.out.println("IP 주소나 도메인 주소를 인자로 지정하세요");
            System.out.println("사용법: java NSLookup <IP> | <DOMAIN>");
            System.exit(0);
        }

        InetAddress inetaddr[] = null;
        inetaddr = InetAddress.getAllByName(args[0]);

        for (InetAddress addr : inetaddr) {
            System.out.println(addr.getHostName());
            System.out.println(addr.getHostAddress());
            System.out.println(addr.toString());
            System.out.println("====================");
        }
    }
}
