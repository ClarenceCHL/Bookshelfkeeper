// Name: Haolun Cheng
// USC NetID: haolunch
// CSCI455 PA2
// Fall 2021

import java.util.ArrayList;

public class BookshelfTester{
   public static void main(String[] args){
      // Bookshelf constructor one
      Bookshelf bs1 = new Bookshelf();
      
      // Test bookshelf constructor one
      System.out.println("\nTest bookshelf constructor one:");
      System.out.println("Expected result: []");
      System.out.println("Actual result: " + bs1);
      
      // Bookshelf constructor two
      ArrayList<Integer> pileOfBooks = new ArrayList<Integer>();
      pileOfBooks.add(20);
      pileOfBooks.add(5);
      pileOfBooks.add(9);
      Bookshelf bs2 = new Bookshelf(pileOfBooks);
      
      // Test bookshelf constructor two
      System.out.println("\nTest bookshelf constructor two:");
      System.out.println("Expected result: [20, 5, 9]");
      System.out.println("Actual result: " + bs2);
      
      // Bookshelf toString method
      String BS1 = bs1.toString();
      String BS2 = bs2.toString();
      
      // Test bookshelf toString method
      System.out.println("\nTest bookshelf toString method:");
      System.out.println("Expected result for bs1: []");
      System.out.println("Actual result for bs1: " + BS1);
      System.out.println("Expected result for bs2: [20, 5, 9]");
      System.out.println("Actual result for bs2: " + BS2);
   }
}