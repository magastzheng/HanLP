package com.magast;

import java.io.IOException;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import static com.hankcs.hanlp.utility.Predefine.logger;

public class KeywordExtractor {
  public static void main(String[] args){
    System.out.println("Test");
    //String filePath = "D:/sourcecode/testdata/125.txt";
    String filePath = "D:/sourcecode/testdata/data/125.txt";
    String content = "";
    try {
      content = FileUtil.readFile(filePath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(content);
    System.out.println("Read finish###############################");
    HanLP.Config.enableDebug();
    LoggerUtil.setLogingProperties(logger);
    List<String> phaseList = HanLP.extractPhrase(content, 10);
    //List<String> keywordList = HanLP.extractKeyword(content, 5);
    //System.out.println(keywordList);
    System.out.println(phaseList);
    System.out.println("E###############################");
  }
}
