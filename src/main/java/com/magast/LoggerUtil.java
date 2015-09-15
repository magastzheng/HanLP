package com.magast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
  private static String logFileName = "HanLP.log";
  
  private static String getLogName(){
      StringBuffer sb = new StringBuffer();
      String userHome = System.getProperty("user.home");
      if(userHome == null || userHome.length() == 0){
        userHome = ".\\log";
      }
      sb.append(userHome);
      sb.append("\\" + logFileName);
      File file = new File(sb.toString());
      if(!file.exists()){
        file.mkdir();
      }
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sb.append("\\" + sdf.format(new Date())+".log");
      return sb.toString();
  }
  
  public static void setLogingProperties(Logger logger){// throws SecurityException, IOException{
    setLogingProperties(logger, Level.ALL);
  }
  
  public static void setLogingProperties(Logger logger, Level level){
    FileHandler fh;
    try{
      String logPathName = getLogName();
      System.out.println(logPathName);
      fh = new FileHandler(logPathName, true);
      logger.addHandler(fh);
      fh.setFormatter(new SimpleFormatter());
    }catch(SecurityException e){
      logger.log(Level.SEVERE, "Security error: ", e);
    }catch(IOException e){
      logger.log(Level.SEVERE, "Fail to read the log file", e);
    }
  }
  
}
