// Name: Haolun Cheng
// USC NetID: haolunch
// CSCI455 PA2
// Fall 2021

import java.util.ArrayList;

public class TestAssert{
   public static void main(String[] args){
      ArrayList<Integer> goodPRE = new ArrayList<Integer>();
      goodPRE.add(10);
      goodPRE.add(11);
      goodPRE.add(12);
      ArrayList<Integer> badPRE = new ArrayList<Integer>();
      badPRE.add(-10);
      goodPRE.add(11);
      goodPRE.add(12);
      
      Bookshelf bs1 = new Bookshelf(goodPRE);
      Bookshelf bs2 = new Bookshelf(badPRE);
   }
}