public class QueenBoard {
  private int[][] board;

  //creates a new QueenBoard with desired size
  public QueenBoard(int size) {
    board = new int[size][size];
  }

  //adds a queen to desired location if valid
  //returns true if successful
  //returns false if not
  public boolean addQueen(int r, int c) {
    if (c == board.length || r == board.length) { //if it's out of bounds, return false
      return false;
    }
    if (board[r][c] == 0) { //if it's a good spot that's not in danger
      board[r][c] = -1; //place the queen there
      int d = r; //this will come in use for the diagonal
      int d1 = r; //for the up diagonal
      for (int x = c+1; x < board.length; x++) {
        board[r][x] += 1; //sets the whole row to 1
        if (d < board.length-1) {
          d+=1;
          board[d][x] += 1; //sets the whole down diagonal to 1
        }
        if (d1 > 0) {
          d1-=1;
          board[d1][x] +=1; //sets the whole up diagonal to 1
        }
      }
      return true; //if it goes through everything, return true
    }
    return false; //otherwise return false
  }

  //removes the queen at desired location, if applicable
  //returns true is removal is successful
  public boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) { //if there's a queen there
      board[r][c] = 0; //remove the queen
      int d = r; //this will come in use for the diagonal
      int d1 = r; //for the up diagonal
      for (int x = c+1; x < board.length; x++) {
        board[r][x] -= 1; //subtracts a one because the queen isn't there anymore
        if (d < board.length-1) {
          d+=1;
          board[d][x] -= 1; //subtracts one from all squares in the upward diagonal
        }
        if (d1 > 0) {
          d1-=1;
          board[d1][x] -= 1; //subtracts one from all squares in the downward diagonal
        }
      }
      return true;
    }
    return false;
  }

  //checks to see if the board is empty/cleared
  public boolean cleared() {
    for (int i = 0; i<board.length; i++) {
      for (int x = 0; x<board.length; x++) {
        if (board[i][x] != 0) {
          return false;
        } //if something is not equal to 0, it means the board is not empy
      }
    }
    return true;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String ans = "";
    for (int r = 0; r<board.length; r++) {
      for (int c = 0; c<board[0].length; c++) {
        if (board[r][c] == -1) { //if the value indicates a queen
          ans+= "Q "; //print out a queen
        }
        else {
          ans+="_ "; //otherwise print out an empty slot
        }
      }
      ans += "\n"; //new row
    }
    return ans;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve() {
    if (!this.cleared()) { //checks to see if the board is cleared
      throw new IllegalStateException("Board must be empty"); //if not, throw exception
    }
    return solve(0,0); //calls helper function
  }

  //helper method
  public boolean solve(int r, int c){
    if (c == board.length) {
      return true; //if it reaches the end of the board, a solution is found
    }
    // if (r == board.length || c == board.length) {
    //   return false;
    // }
    for (int i = 0; i<board.length; i++) { //goes through the rows
      if (addQueen(i,c)) { //if a queen can be added
        if (solve(i,c+1)) { //the function is called again recursively
          return true; //if it works out, return true
        }
        removeQueen(i,c); //otherwise remove the queen
      }
    }
    return false;
  }

  public int findAll(int c){
    int answer = 0; //this will store the number of solutions
    if (c == board.length) {
      return 1; //if it reaches the end of the board, a solution is found
    }
    for (int r = 0; r<board.length; r++) {
      if (addQueen(r,c)) { //if a queen can be added
        answer+=findAll(c+1); //the function is called recursively for the next column to see if a queen can be added
        removeQueen(r,c); //otherwise remove the queen
      }
    }
    return answer; //the total number of solutions is returned
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    if (!this.cleared()) { //checks to see if the board is cleared
      throw new IllegalStateException("Board must be empty"); //if not, throw exception
    }
    return findAll(0); //calls the helper function
  }



}
