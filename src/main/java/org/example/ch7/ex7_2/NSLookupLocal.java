package org.example.ch7.ex7_2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookupLocal {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}
