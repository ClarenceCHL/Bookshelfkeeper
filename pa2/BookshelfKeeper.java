// Name: Haolun Cheng
// USC NetID: haolunch
// CSCI455 PA2
// Fall 2021

import java.util.Stack;

/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
      Representation invariant:

      -- BookshelfKeeper keeps all books on bookshelf in non-decreasing order
      -- Books are all positive integers

   */
   private Bookshelf bookshelf;
   private int totalOperation;
   private int numOfCalls;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      this.bookshelf = new Bookshelf();
      this.totalOperation = 0;
      this.numOfCalls = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      this.bookshelf = sortedBookshelf;
      this.totalOperation = 0;
      this.numOfCalls = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {
      numOfCalls = 0;
      // Use stack to do the remove operation
      Stack<Integer> stack = new Stack<Integer>();
      // If starting from the left of the bookshelf is closer to the desired book
      if(bookshelf.size() - position > position){
         // Remove books one at a time starting from left
         for(int i = 0; i <= position; i ++){
            int height = bookshelf.removeFront();
            numOfCalls++;
            if(i != position) stack.push(height);
         }
         // Put other books back to the bookshelf
         while(!stack.empty()){
            bookshelf.addFront(stack.pop());
            numOfCalls++;
         }
      }
      // If starting from the right of the bookshelf is closer to the desired book
      else{
         // Remove books one at a time starting from right
         for(int i = bookshelf.size() - 1; i >= position; i --){
            int height = bookshelf.removeLast();
            numOfCalls++;
            if(i != position) stack.push(height);
         }
         // Put other books back to the bookshelf
         while(!stack.empty()){
            bookshelf.addLast(stack.pop());
            numOfCalls++;
         }
      }
      // Total number of operations
      this.totalOperation += numOfCalls;
      assert isValidBookshelfKeeper();
      return numOfCalls;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      int position = 0;
      numOfCalls = 0;
      // Use stack to do the put operation
      Stack<Integer> stack = new Stack<Integer>();
      // Find the appropriate position for the book in the bookshelf
      position = findPos(height);
      // If starting from the left of the bookshelf is closer to the desired book
      if(bookshelf.size() - position > position){
         // Remove books one at a time starting from left
         for(int j = 0; j < position; j++){
            int ht = bookshelf.removeFront();
            numOfCalls++;
            stack.push(ht);
         }
         // Put the book into the bookshelf
         bookshelf.addFront(height);
         numOfCalls++;
         // Put other books back to the bookshelf
         while(!stack.empty()){
            bookshelf.addFront(stack.pop());
            numOfCalls++;
         }
      }
      // If starting from the right of the bookshelf is closer to the desired book
      else{
         // Remove books one at a time starting from right
         for(int j = bookshelf.size() - 1; j >= position; j--){
            int ht = bookshelf.removeLast();
            numOfCalls++;
            stack.push(ht);
         }
         // Put the book into the bookshelf
         bookshelf.addLast(height);
         numOfCalls++;
         // Put other books back to the bookshelf
         while(!stack.empty()){
            bookshelf.addLast(stack.pop());
            numOfCalls++;
         }
      }
      // Total number of operations
      this.totalOperation += numOfCalls;
      assert isValidBookshelfKeeper();
      return numOfCalls;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperation;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return bookshelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      assert isValidBookshelfKeeper();
      return bookshelf.toString() + " " + this.numOfCalls + " " + this.totalOperation;
      
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      for(int i = 0; i < bookshelf.size(); i++){
         // Satisfy all representation invariants
         if(bookshelf.getHeight(i) <= 0 || bookshelf.getHeight(i) != (int)bookshelf.getHeight(i) || !bookshelf.isSorted())
            return false;
      }
      return true;

   }

   /**
    * This method finds the appropriate position for a book with specified height such that
    * the bookshelf is still in non-decreasing order after inserting the book.
    *
    * @param height the height of the book to be inserted
    * @return position the index where the book should be inserted
    */
   private int findPos(int height){
      int position = 0;
      int pointer = bookshelf.size() - 1;
      int rightSteps = 0;
      boolean existLarge = false;
      for(int i = 0; i < bookshelf.size(); i++){
         // If there exists books which have the same height as the book to be inserted
         if(bookshelf.getHeight(i) == height){
            // Check which insertion direction requires less operations (left or right)
            while(bookshelf.getHeight(pointer) != height){
               pointer--;
               rightSteps++;
            }
            if(rightSteps > i) {
               position = i;
               existLarge = true;
            }
            else{
               position = pointer + 1;
               existLarge = true;
            }
            break;
         }
         // If there does not exist any book with the same height, then insert the book directly
         if(bookshelf.getHeight(i) > height){
            position = i;
            existLarge = true;
            break;
         }
      }
      // Put the current book at the end of the bookshelf if it has the largest height
      if(!existLarge) position = bookshelf.size();
      return position;
   }

}
