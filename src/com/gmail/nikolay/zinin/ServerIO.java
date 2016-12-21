package com.gmail.nikolay.zinin;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerIO {


    public void talkToClient() {


        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(61616);

                Socket clientSocket = serverSocket.accept();

            String inLine;
            //String outLine = null;

                try {
                    InputStream inputStream = clientSocket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(inputStreamReader);

                    OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream, true);

                    while (true){
                        inLine = br.readLine();   //getall
                   System.out.println(inLine);

                   if (inLine.equals("getall")) {
                       ArrayList<String> catalog = new CatalogIO().getCatalog();
                       //  outLine=new CatalogIO().getCatalog();
                       for (String fileLine : catalog) {
                           // System.out.println(fileLine);
                           out.println(fileLine);}
                       out.println("EOF");

                       //out.println("another line after socket");



                  /*     for (String fileLine : catalog) {

                           out.println(fileLine);
                       }*/
                    //   out.println("EOF"); //

                     //  out.println("test");
                      // out.flush();
                   }
                //    inLine = br.readLine();      //"exit"
                        if (inLine.equals("exit")){  System.out.println("break!!!!!!!!!!!!!!!");break;}
                    //System.out.println(inLine);
                }
                    System.out.println("came here");
                    out.close();
                    br.close();
                    serverSocket.close();

                } catch (Exception e) {

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

