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

  //clears the board
  public void clear() {
    for (int i = 0; i<board.length; i++) {
      for (int x = 0; x<board.length; x++) {
        board[i][x] = 0; //sets everything back to zero
      }
    }
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
    return solve(0,0);
  }

  //helper method
  public boolean solve(int r, int c){
    //r keeps track of the row
    //c keeps track of column
    if (c == board.length) {
      return true;
    }
    if (r == board.length || c == board.length) {
      return false;
    }
    for (int i = 0; i<board.length; i++) {
      if (addQueen(i,c)) {
        if (solve(i,c+1)) {
          return true;
        }
        removeQueen(i,c);
      }
    }
    return false;
  }

  public int solveAll(int r, int c){
    //r keeps track of the row
    //c keeps track of column
    int answer = 0;
    if (c == board.length) {
      return 1;
    }
    for (int i = 0; i<board.length; i++) {
      if (addQueen(i,c)) {
        answer+=solveAll(i,c+1);
        removeQueen(i,c);
      }
    }
    return answer;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int answer = solveAll(0,0);
    return answer;
  }



}
