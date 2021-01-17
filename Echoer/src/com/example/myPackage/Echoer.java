package com.example.myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{
    private Socket socket;

    Echoer(final Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (true){
                String echoString = input.readLine();
                if (echoString.equals("exit")){
                    break;
                }
                output.println(echoString);
            }
        } catch (IOException e){
            System.out.println("Oups");
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                e.getMessage();
            }
        }
    }
}