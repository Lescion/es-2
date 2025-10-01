package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        ServerSocket mioServerSocket = new ServerSocket(3000);
        Socket miosocket = mioServerSocket.accept();
        System.out.println("qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        PrintWriter out = new PrintWriter(miosocket.getOutputStream(), true);

        do{
        String stringricevuta = in.readLine();
        String stringMaiuscola = stringricevuta.toUpperCase();
        out.println(stringMaiuscola);
        }while(in.readLine().equals("!"));


        mioServerSocket.close();
    }
}
