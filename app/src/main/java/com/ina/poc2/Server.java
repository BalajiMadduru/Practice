package com.ina.poc2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    private static ServerSocket server;
    private static int port = 9876;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public static void main(String args[]) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Waiting for the client request");
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        try {
            while (true) {
                byte[] cmd = is.readAllBytes(); // data is empty
                if (cmd.length > 0) {
                    byte[] ack = processRequest(cmd);
                    System.out.println("Hhhhh " + Hex.toHexString(ack));
                    os.write(ack);
                    os.flush();
                } else {
                    Thread.sleep(50);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while processing request " + e.getMessage());
            is.close();
            os.close();
            socket.close();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private static byte[] processRequest(byte[] cmd) {

        System.out.println("Data received " + Hex.toHexString(cmd));

        // Parsing the received command
        parse(cmd);

        return new byte[]{
                0x20, 0x00, 0x30
        };
    }

    private static void parse(byte[] cmd) {
        byte stx = cmd[0];
        if (stx != 0x02) {
            System.out.println("Invalid command: Start byte is not 0x02");
            return;
        }

        byte[] txnType = Arrays.copyOfRange(cmd, 1, 2);
        byte[] amount = Arrays.copyOfRange(cmd, 2, 8);

        System.out.println("Transaction Type: " + Hex.toHexString(txnType));
        System.out.println("Amount: " + Hex.toHexString(amount));
    }
}
