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
      
      // Bookshelf addFront method
      bs1.addFront(35);
      bs2.addFront(35);
      
      // Test bookshelf addFront method
      System.out.println("\nTest bookshelf addFront method:");
      System.out.println("Expected result for bs1: [35]");
      System.out.println("Actual result for bs1: " + bs1);
      System.out.println("Expected result for bs2: [35, 20, 5, 9]");
      System.out.println("Actual result for bs2: " + bs2);
      
      // Bookshelf addLast method
      bs1.addLast(45);
      bs2.addLast(45);
      
      // Test bookshelf addLast method
      System.out.println("\nTest bookshelf addLast method:");
      System.out.println("Expected result for bs1: [35, 45]");
      System.out.println("Actual result for bs1: " + bs1);
      System.out.println("Expected result for bs2: [35, 20, 5, 9, 45]");
      System.out.println("Actual result for bs2: " + bs2);
      
      // Bookshelf removeFront method
      int removeFirstBS1 = bs1.removeFront();
      int removeFirstBS2 = bs2.removeFront();
      
      // Test bookshelf removeFront method
      System.out.println("\nTest bookshelf removeFront method:");
      System.out.println("Expected result for bs1: [45]");
      System.out.println("Actual result for bs1: " + bs1);
      System.out.println("Expected result for bs2: [20, 5, 9, 45]");
      System.out.println("Actual result for bs2: " + bs2);
      
      // Bookshelf removeLast method
      int removeEndBS1 = bs1.removeLast();
      int removeEndBS2 = bs2.removeLast();
      
      // Test bookshelf removeLast method
      System.out.println("\nTest bookshelf removeLast method:");
      System.out.println("Expected result for bs1: []");
      System.out.println("Actual result for bs1: " + bs1);
      System.out.println("Expected result for bs2: [20, 5, 9]");
      System.out.println("Actual result for bs2: " + bs2);
      
      // Bookshelf getHeight method
      int height = bs2.getHeight(0);
      
      // Test bookshelf getHeight method
      System.out.println("\nTest bookshelf getHeight method:");
      System.out.println("Expected result for height: 20");
      System.out.println("Actual result for height: " + height);
      
      // Bookshelf size method
      int size = bs2.size();
      
      // Test bookshelf size method
      System.out.println("\nTest bookshelf size method:");
      System.out.println("Expected result for size: 3");
      System.out.println("Actual result for size: " + size);
      
      // Bookshelf isSorted method
      boolean isSort1 = bs1.isSorted();
      boolean isSort2 = bs2.isSorted();
      
      // Test bookshelf isSorted method
      System.out.println("\nTest bookshelf isSorted method:");
      System.out.println("Expected result for bs1 isSorted: true");
      System.out.println("Actual result for bs1 isSorted: " + isSort1);
      System.out.println("Expected result for bs2 isSorted: false");
      System.out.println("Actual result for bs2 isSorted: " + isSort2);
   }
}