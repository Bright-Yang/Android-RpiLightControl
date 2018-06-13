package com.example.peilin.rpilightcontrol;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void>{

    public static String HOST ="192.168.10.253"; //the ip of raspberry pi
    public static int PORT =8888;


    Socket socket;
    PrintWriter writer;

    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try {
            socket = new Socket(HOST, PORT);
            writer = new PrintWriter(socket.getOutputStream());

            writer.write(message);
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
