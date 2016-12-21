package com.gmail.nikolay.zinin;

import java.io.*;
import java.util.ArrayList;

public class CatalogIO {

   public  ArrayList <String> getCatalog() {
     //   public  String getCatalog() {
        File file = new File("database.csv");
        String line = null;

        ArrayList <String> list = new ArrayList <String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            try {

             while ((line= br.readLine()) != null) {
                // System.out.println(line);
                    list.add(line);
                }
                br.close();

                // StringBuffer stringBuffer = new StringBuffer();
             //   String line;
               /* while ((line = br.readLine()) != null) {
                    stringBuffer.append(line.replace(",", " "));
                    stringBuffer.append("\n");
                }
              br.close();*/
                // line= stringBuffer.toString();
              //  System.out.println(line);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
      //  return line;
    }
}

