package com.hankcs.test.other;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
  public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
    InputStream is = new FileInputStream(filePath);
    String line;
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    line = reader.readLine();
    while(line != null){
      //if(line.length() > 0){
        buffer.append(line);
        buffer.append("\n");
        line = reader.readLine();
        //System.out.println(line);
      //}
      //System.out.println("test");
    }
    reader.close();
    is.close();
  }

  public static String readFile(String filePath) throws IOException {
    StringBuffer sb = new StringBuffer();
    readToBuffer(sb, filePath);
    return sb.toString();
  }
}
