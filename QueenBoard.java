public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) { //if it's a good spot that's not in danger
      board[r][c] = -1; //place the queen there
      int d = c; //this will come in use for the diagonal
      for (int x = r+1; x < board.length; x++) {
        board[r][x] = 1; //sets the whole row to 1
        if (d < board.length-1) {
          d+=1;
          board[d][x] = 1; //sets diagonals to 1
        }
      }
      return true;
    }
    return false;
  }

  public int getValue(int r, int c) {
    return board[r][c];
  }


  private boolean removeQueen(int r, int c) {
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
        if (c!=-5) {
          ans += board[r][c] + " ";
        }
        else {
          ans += "-1 ";
        }
      }
      ans += "\n";
    }
    return ans;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return 0;
  }

    public static void main(String[] args) {
      QueenBoard queenboard = new QueenBoard(8);
      System.out.println(queenboard);
      queenboard.addQueen(0,0);
      System.out.println(queenboard);
    }


}
