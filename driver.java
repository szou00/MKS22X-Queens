public class driver {

public static void main(String[] args) {
  QueenBoard queenboard = new QueenBoard(8);
  System.out.println("TESTING----------------");
  System.out.println("SIZE ZERO: ");
  QueenBoard zero = new QueenBoard(0);
  System.out.println(zero);
  // System.out.println(zero.solve());
  // System.out.println(zero);
  System.out.println("SIZE ONE: ");
  QueenBoard one = new QueenBoard(1);
  System.out.println(one);
  System.out.println("Can this be solved: " + one.solve());
  System.out.println(one);
  one.clear();
  System.out.println("Number of solutions: " + one.countSolutions());
  System.out.println(one);
  System.out.println("SIZE TWO: ");
  QueenBoard two = new QueenBoard(2);
  System.out.println("Number of solutions: " + two.countSolutions());
  System.out.println("SIZE THREE: ");
  QueenBoard three = new QueenBoard(3);
  System.out.println("Number of solutions: " + three.countSolutions());
  System.out.println("SIZE FOUR: ");
  QueenBoard four = new QueenBoard(4);
  System.out.println("Number of solutions: " + four.countSolutions());
  System.out.println("SIZE FIVE: ");
  QueenBoard five = new QueenBoard(5);
  System.out.println("Number of solutions: " + five.countSolutions());
  System.out.println("SIZE THREE: ");
  QueenBoard six = new QueenBoard(6);
  System.out.println("Number of solutions: " + six.countSolutions());
  System.out.println("SIZE SEVEN: ");
  QueenBoard seven = new QueenBoard(7);
  System.out.println("Number of solutions: " + seven.countSolutions());
  System.out.println("SIZE EIGHT: ");
  QueenBoard eight = new QueenBoard(8);
  System.out.println("Number of solutions: " + eight.countSolutions());
  System.out.println("SIZE NINE: ");
  QueenBoard nine = new QueenBoard(9);
  System.out.println("Number of solutions: " + nine.countSolutions());
  System.out.println("SIZE TEN: ");
  QueenBoard ten = new QueenBoard(10);
  System.out.println("Number of solutions: " + ten.countSolutions());
  System.out.println("SIZE ELEVEN: ");
  QueenBoard eleven = new QueenBoard(11);
  System.out.println("Number of solutions: " + eleven.countSolutions());
  System.out.println("SIZE TWELVE: ");
  QueenBoard twelve = new QueenBoard(12);
  System.out.println("Number of solutions: " + twelve.countSolutions());
  System.out.println("SIZE THIRTEEN: ");
  QueenBoard thirteen = new QueenBoard(13);
  System.out.println("Number of solutions: " + thirteen.countSolutions());
  System.out.println("SIZE FOURTEEN: ");
  QueenBoard fourteen = new QueenBoard(14);
  System.out.println("Number of solutions: " + fourteen.countSolutions());
  // System.out.println(queenboard.solve());
  // System.out.println(queenboard);
  // // System.out.println(queenboard.countSolutions());
  // System.out.println(queenboard1.countSolutions());
  // System.out.println(queenboard1);
  // QueenBoard unsolvable = new QueenBoard(2);
  // System.out.println(unsolvable.solve());
  // System.out.println(unsolvable);

  }

}
