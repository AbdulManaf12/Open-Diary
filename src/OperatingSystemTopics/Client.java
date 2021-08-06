package OperatingSystemTopics;

import java.io.*;
import java.net.*;

public class Client
{
    public static String StartClient(String request)
    {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.StartServer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            Socket s = new Socket("localhost", 888);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str1 = "";

            dos.writeBytes(request + "\n");
            str1 = br.readLine();

            dos.close();
            br.close();
            s.close();
            return str1;
        }
        catch (Exception e){
            System.err.println("Client has issue");
        }
        return "None";
    }
}
