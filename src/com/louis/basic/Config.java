package com.louis.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Config {

    private static final int port = 3001;

    private static final int serverSocketBacklog = 10;

    private static InetAddress address;

    public static int getPort() {
        return port;
    }

    public static int getServerSocketBacklog() {
        return serverSocketBacklog;
    }

    public static InetAddress getAddress() {
        if (address == null) {
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                System.out.println(ex);
            }
        }

        return address;
    }
}
