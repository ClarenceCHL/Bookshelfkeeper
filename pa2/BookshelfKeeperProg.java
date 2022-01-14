// Name: Haolun Cheng
// USC NetID: haolunch
// CSCI455 PA2
// Fall 2021

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class BookshelfKeeperProg
 *
 * This class handles the user's interface on console. It takes user's input arguments
 * and does error checkings with them. If there is no error in the user's input, it
 * will execute the command/method that correspondes to the user's input.
 */

public class BookshelfKeeperProg{
   /**
    * Main method
    *
    * @param args
    */
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      ArrayList<Integer> bookshelf = new ArrayList<Integer>();
      System.out.println("Please enter initial arrangement of books followed by newline:");
      bookshelf = books(in.nextLine());
      // If the input books are not sorted
      if(!isSorted(bookshelf)){
         notSorted();
      } 
      // If the input books have negative heights
      else if(isNegative(bookshelf)){
         negativeInt();
      } else{
         Bookshelf bs = new Bookshelf(bookshelf);
         BookshelfKeeper bookshelfkeeper = new BookshelfKeeper(bs);
         Scanner operation;
         // Print out all books on the bookshelf
         System.out.println(bookshelfkeeper.toString());
         System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
         // Executing command based on user's input
         while(true){
            String operations = in.nextLine();
            operation = new Scanner(operations);
            String command = operation.next();
            int posOrHeight = 0;
            if(operation.hasNextInt()) posOrHeight = operation.nextInt();
            if(!errorCheckCMD(command, posOrHeight, bookshelfkeeper)) break;
            if(operations.trim().equals("end")){
               System.out.println("Exiting Program.");
               break;
            }
            else executeCMD(command, posOrHeight, bookshelfkeeper);
            System.out.println(bookshelfkeeper.toString());
         }
         in.close();
         operation.close();
      }
   }
   
   /**
    * This method prints out error message for unsorted bookshelf
    */
   public static void notSorted(){
      System.out.println("ERROR: Heights must be specified in non-decreasing order.");
      System.out.println("Exiting Program.");
   }
   
   /**
    * This method prints out error message for book with a negative height
    */
   public static void negativeInt(){
      System.out.println("ERROR: Height of a book must be positive.");
      System.out.println("Exiting Program.");
   }
   
   /**
    * This method stores the height of each book into an arraylist 
    * by scanning the input string from the user's input.
    * 
    * @param str user's input
    * @return al an arraylist containing height of each book
    */
   public static ArrayList<Integer> books(String str){
      Scanner in = new Scanner(str);
      ArrayList<Integer> al = new ArrayList<Integer>();
      while(in.hasNextInt()){
         al.add(in.nextInt());
      }
      in.close();
      return al;
   }
   
   /**
    * This method checks if an arraylist is sorted.
    * 
    * @param al an arraylist
    * @return true if sorted and false if not sorted
    */
   public static boolean isSorted(ArrayList<Integer> al) {
      for(int i = 1; i < al.size(); i++){
         if(al.get(i - 1) > al.get(i)) return false;
      }
      return true;
   }
   
   /**
    * This method checks if there is an negative integer in the arraylist
    *
    * @param al an arraylist
    * @return true if there is an negative integer and false otherwise
    */
   public static boolean isNegative(ArrayList<Integer> al){
      for(int i = 0; i < al.size(); i++){
         if(al.get(i) < 0) return true;
      }
      return false;
   }
   
   /**
    * This method does the error checking for user's input command
    *
    * @param cmd   user's input command string
    * @param index user's input index
    * @param bsk   a bookshelfkeeper
    * @return true if the input passes all error checking and false otherwise
    */
   public static boolean errorCheckCMD(String cmd, int index, BookshelfKeeper bsk){
      if(!cmd.trim().equals("pick") && !cmd.trim().equals("put") && !cmd.trim().equals("end")){
         errorCheckCMDInfo();
         return false;
      }
      if(!errorCheckIndex(index, bsk) && cmd.trim().equals("pick")) {
         errorCheckIndexInfo();
         return false;
      }
      if(cmd.trim().equals("put") && !errorCheckHeight(index)){
         errorCheckHeightInfo();
         return false;
      }
      return true;
   }
   
   /**
    * This method prints out the error message for invalid user's input string
    */
   public static void errorCheckCMDInfo(){
      System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
      System.out.println("Exiting Program.");
   }
   
   /**
    * This method checks if the user's input index is out of bounds.
    * 
    * @param index user's input index
    * @param bsk   a bookshelfkeeper
    * @return true if the user's input index is within the bounds and false otherwise
    */
   public static boolean errorCheckIndex(int index, BookshelfKeeper bsk){
      if(index > bsk.getNumBooks() - 1) return false;
      return true;
   }
   
   /**
    * This method prints out the error message for user's input index out of bounds
    */
   public static void errorCheckIndexInfo(){
      System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
      System.out.println("Exiting Program.");
   }
   
   /**
    * This method checks if a height is negative
    *
    * @param height the height of a book
    * @return true if the height is positive and false otherwise
    */
   public static boolean errorCheckHeight(int height){
      if(height <= 0){
         return false;
      }
      return true;
   }
   
   /**
    * This method prints out error message for negative height input
    */
   public static void errorCheckHeightInfo(){
      System.out.println("ERROR: Height of a book must be positive.");
      System.out.println("Exiting Program.");
   }
   
   /**
    * This method executes the corresponding command based on the user's input
    *
    * @param cmd         user's input command string
    * @param posOrHeight position or height of a book
    * @param bsk         a bookshelfkeeper
    */
   public static void executeCMD(String cmd, int posOrHeight, BookshelfKeeper bsk){
      if(cmd.trim().equals("pick")) bsk.pickPos(posOrHeight);
      else if(cmd.trim().equals("put")) bsk.putHeight(posOrHeight);
   }
}