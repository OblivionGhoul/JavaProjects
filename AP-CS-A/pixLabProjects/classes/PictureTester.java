package pixLabProjects.classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("waves.jpg");
    beach.keepOnlyBlue();
    beach.explore();
  }

  public static void testNegate()
  {
    Picture beach = new Picture("waves.jpg");
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale()
  {
    Picture beach = new Picture("waves.jpg");
    beach.grayscale();
    beach.explore();
  }

  public static void testFixUnderwater()
  {
    Picture underwater = new Picture("water.jpg");
    underwater.fixUnderwater();
    underwater.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("waves.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  public static void testSeatingChart()
  {
    Picture canvas = new Picture("classroom.jpg");
    canvas.createSeatingChart();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    //testKeepOnlyBlue();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorHorizontalBotToTop();
    testSeatingChart();
  }
}