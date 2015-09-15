package com.hankcs.test.other;

import java.io.IOException;
import java.util.List;

import com.hankcs.hanlp.HanLP;

import junit.framework.TestCase;

public class TextRankKeywordTest extends TestCase{
  public void testextractKeyword()
  {
    String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
    System.out.println("B###############################");
    List<String> keywordList = HanLP.extractKeyword(content, 5);
    System.out.println(keywordList);
    System.out.println("E###############################");
  }
  
  public void testextractKeywordCN125()
  {
    String filePath = "D:/sourcecode/testdata/125.txt";
    String content = "";
    try {
      content = FileUtil.readFile(filePath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(content);
    System.out.println("Read finish###############################");
    List<String> keywordList = HanLP.extractKeyword(content, 5);
    System.out.println(keywordList);
    System.out.println("E###############################");
  }
}