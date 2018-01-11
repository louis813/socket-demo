package com.louis.basic;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int port = Config.getPort();

    private static final int backlog = Config.getServerSocketBacklog();

    private static InetAddress bindAddr = Config.getAddress();

    private static ServerSocket serverSocket;

    public static void init() {
        if (serverSocket == null) {
            try {
                serverSocket = new ServerSocket(port, backlog, bindAddr);
            } catch (IOException ex) {
                System.out.println("Init server fail: " + ex);
            }
        }
    }

    public static void read() {
        String lineString;

        try {
            Socket socket = serverSocket.accept();
            Reader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((lineString = bufferedReader.readLine()) != null) {
                System.out.println("Robot read: " + lineString);
            }
        } catch (IOException ex) {
            System.out.println("Read socket fail: " + ex);
        }

    }

    public static void main(String[] args) {
        Server.init();
        Server.read();
    }
}
