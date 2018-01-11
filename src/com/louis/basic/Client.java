package com.louis.basic;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final int port = Config.getPort();

    private static InetAddress address = Config.getAddress();

    private static Socket socket;

    public static void init() {
        try {
            if (socket == null) {
                socket = new Socket(address, port);
            }
        } catch (IOException ex) {
            System.out.println("Init socket failed: " + ex);
        }
    }

    public static void write() {
        String input;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();
            PrintWriter writer = null;

            try {
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Write socket failed: " + ex);
            }

            writer.println(input);
            writer.flush();
        }
    }

    public static void main(String[] args) {
        Client.init();
        Client.write();
    }

}
