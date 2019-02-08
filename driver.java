public class driver {

public static void main(String[] args) {
  QueenBoard queenboard = new QueenBoard(8);
  System.out.println(queenboard);
  queenboard.addQueen(0,0);
  System.out.println(queenboard);
  queenboard.addQueen(2,0);
  System.out.println(queenboard);
  queenboard.removeQueen(0,0);
  System.out.println(queenboard);
  queenboard.solve();
  System.out.println(queenboard);
  }

}
