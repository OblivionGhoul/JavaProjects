import java.util.Scanner;
/*
Tester class
Creates instance of Cs Quiz class
Calls the askQuestions method
Calls the getScore method
*/
class TestQuizzer_6Dinh {
  public static void main(String[] args) {
    CsQuiz quiz = new CsQuiz();
    quiz.askQuestions();
    System.out.println(quiz.displayResults());
  }
}

/*
CsQuiz class
contains testScore instance variable
contains the askQuestions method
contains the displayResults method
contains the getScore method
*/
class CsQuiz {
  // score instance variable
  private int testScore = 0;

  public void askQuestions() {
    // creates a scanner for each question
    Scanner input = new Scanner(System.in);
    // explains quiz
    System.out.println("Welcome to the \"Should you take AP CS?\" quiz.");
    // first question and input asked
    System.out.println("#1: On a scale of 1-10, how much does coding interest you?");
    int codeInterest = input.nextInt();
    // checks for valid input
    while (codeInterest > 10 || codeInterest < 1) {
      System.out.println("Please provide a number between 1-10");
      codeInterest = input.nextInt();
    }
    // second question and input asked
    System.out.println("#2: You give up easily (a. True, b. False).");
    String giveUp = input.nextLine();
    // checks for valid input
    if ((!giveUp.equals("a")) && (!giveUp.equals("b"))) {
      System.out.println("Please enter either a or b.");
      giveUp = input.nextLine();
    }
    // third question and input asked
    System.out.println("#3: What is your coding experience?");
    System.out.println("(a. None, b. A little bit, c. A lot)");
    String codingExperience = input.nextLine();
    // checks for valid input
    if (!codingExperience.equals("a") && !codingExperience.equals("b") && !codingExperience.equals("c")) {
      System.out.println("Please enter either a, b, or c.");
      codingExperience = input.nextLine();
    }
    // fourth question and input asked
    System.out.println("#4: Do you like to solve problems?");
    System.out.println("(a. Not at all, b. A little bit, c. A lot)");
    String problemSolve = input.nextLine();
    // checks for valid input
    if (!problemSolve.equals("a") && !problemSolve.equals("b") && !problemSolve.equals("c")) {
      System.out.println("Please enter either a, b, or c.");
      problemSolve = input.nextLine();
    }
    // fifth question and input asked
    System.out.println("#5: Does your dream job require coding?");
    System.out.println("(a. Not at all, b. A little bit, c. A lot)");
    String codingJob = input.nextLine();
    // checks for valid input
    if (!codingJob.equals("a") && !codingJob.equals("b") && !codingJob.equals("c")) {
      System.out.println("Please enter either a, b, or c.");
      codingJob = input.nextLine();
    }
    // sixth question and input asked
    System.out.println("#6: Do you like the computer science teacher at your school?");
    System.out.println("(a. Not at all, b. Not sure, c. A little bit, d. A lot)");
    String likeTeacher = input.nextLine();
    // checks for valid input
    if (!likeTeacher.equals("a") && !likeTeacher.equals("b") && !likeTeacher.equals("c") && !likeTeacher.equals("d")) {
      System.out.println("Please enter either a, b, c, or d.");
      likeTeacher = input.nextLine();
    }
    // adds one point to test score if interest is greater than 4
    if (codeInterest >= 5) {
      testScore++;
    }
    // adds one point to test score if user does not give up easily
    if (giveUp.equals("b")) {
      testScore++;
    }
    // adds one point to test score if user has a lot of coding experience
    if (codingExperience.equals("c")) {
      testScore++;
    }
    // adds one point to test score if user likes solving problems a lot
    if (problemSolve.equals("c")) {
      testScore++;
    }
    // adds one point to test score if dream job requires coding
    if (codingJob.equals("c")) {
      testScore++;
    }
    // adds one point to test score if user likes teacher
    if (likeTeacher.equals("d")) {
      testScore++;
    }

    input.close();
  }

  // displays the final results
  public String displayResults() {
    // custom messages
    String pass = "You would do great in AP Computer Science!";
    String fail = "You should consider another class :).";
    // returns a message depending if the test score is greater than or equal to 3
    if (testScore >= 3) {
      return pass + "Your score: " + getScore();
    } else {
      return fail + "Your score: " + getScore();
    }
  }

  // returns score or the total amount of points earned
  public int getScore() {
    return testScore;
  }
}
