/**
 * Do a simple tests on Heap12
 */
public class SimpleP4Test {

  private static class MyBigInteger extends java.math.BigInteger {
    MyBigInteger() {super("0");}
  }
  
  public static void main(String args[]) {

    PQueue<MyBigInteger> a =  new Heap12<MyBigInteger>();
    if(a.size() != 0) {
      System.err.println("Heap12: problem with initial size().");
      System.exit(-1);
    }

    String[] s = {"b","a"};
    Heap12.sort(s);
    if(!s[0].equals("a")) {
      System.err.println("Heap12: problem with sort().");
      System.exit(-1);
    }
    

    System.exit(0);

  }

}
