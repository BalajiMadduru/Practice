package com.ina.poc2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    // Method to send a command
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private static void send(byte[] cmd) throws IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;

        try {
            socket = new Socket(host.getHostName(), 9876);
            OutputStream os = socket.getOutputStream();
            // sned bytes
            os.write(cmd);
            os.flush();

        } finally {
            if (socket != null) socket.close();
        }
    }

    // Method to send sale command
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public static void sendSale() throws IOException, ClassNotFoundException, InterruptedException {
        byte[] cmd = Hex.decode("020100000000010003");
        Client.send(cmd);
    }

    // Method to send void command
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public static void sendVoid() throws IOException, ClassNotFoundException, InterruptedException {
        byte[] cmd = Hex.decode("020200000000010003");
        Client.send(cmd);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public static void main(String[] args) {
        Client client = new Client();
        try {
            sendSale();
            //  client.sendVoid();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
