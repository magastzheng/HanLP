package com.magast;

import java.io.IOException;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.occurrence.Occurrence;
import com.hankcs.hanlp.corpus.occurrence.PairFrequency;

import static com.hankcs.hanlp.utility.Predefine.logger;

public class KeywordExtractor {
  public static void main(String[] args){
    System.out.println("Test");
    //String filePath = "D:/sourcecode/testdata/125.txt";
    //String filePath = "D:/sourcecode/testdata/data/125.txt";
    String filePath = "data/testdata/125-1.txt";
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
    testExtractDirectly(content);
    System.out.println("E###############################");
  }
  
  public static void testExtractDirectly(String content){
    Occurrence occurrence = new Occurrence();
    occurrence.addAll(content);
    occurrence.compute();
    occurrence.toString();
    List<PairFrequency> sclist = occurrence.getPhraseByScore();
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (PairFrequency phrase : sclist)
    {
        String output = phrase.getKey().replace(Occurrence.RIGHT, '→') + "\tscore=" + phrase.score + " , ";
        logger.info(output) ;
        sb.append(output);
        sb2.append(phrase.first + phrase.second + ":" + phrase.score);
    }
    logger.info("\n============================================\n");
    logger.info(sb.toString());
    logger.info("\n===================================================\n");
    logger.info(sb2.toString());
  }
  
  public static void testSplitFirst(String content){
    List<String> phaseList = HanLP.extractPhrase(content, 10);
    //List<String> keywordList = HanLP.extractKeyword(content, 5);
    //System.out.println(keywordList);
    System.out.println(phaseList);
  }
}
