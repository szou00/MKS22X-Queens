public class driver {

public static void main(String[] args) {
  QueenBoard queenboard = new QueenBoard(8);
  QueenBoard queenboard1 = new QueenBoard(8);
  // System.out.println(queenboard);
  // queenboard.addQueen(0,0);
  // System.out.println(queenboard);
  // queenboard.addQueen(2,0);
  // System.out.println(queenboard);
  // queenboard.removeQueen(0,0);
  // System.out.println(queenboard);
  // queenboard.addQueen(2,0);
  // queenboard.addQueen(0,0);
  System.out.println(queenboard.solve());
  System.out.println(queenboard);
  System.out.println(queenboard.countSolutions());
  System.out.println(queenboard);
  QueenBoard unsolvable = new QueenBoard(2);
  System.out.println(unsolvable.solve());
  System.out.println(unsolvable);

  }

}
