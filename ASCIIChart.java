/*
 *  Creates new instance 
 *  Calls printChart method
 */
class ASCIIChart {
  public static void main(String[] args) {
    ASCII ascii = new ASCII();
    ascii.printChart();
  }
}

/*
 * Contains method printChart thats prints out an ascii table Contains 2 for
 * loops for columm and row
 */
class ASCII {
  public void printChart() {
    System.out.println("--------------------------------------------");
    for (int i = 32; i <= 123; i += 5) {
      for (int j = 0; j < 5; j++) {
        if (i + j < 100) {
          System.out.print(" " + (i + j) + ": " + (char) (i + j) + " | ");
        } else {
          System.out.print((i + j) + ": " + (char) (i + j) + " | ");
        }
      }
      System.out.println();
      System.out.println("--------------------------------------------");
    }
  }
}