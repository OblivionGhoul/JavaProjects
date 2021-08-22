import java.util.ArrayList;

public class StudentArrayTester2 {
  public static void main(String[] args) {
    Team mathClass = new Team("PreCalc");
    mathClass.addStudent(new Student("Minh", 2, 185, 10.3, 3.2));
    mathClass.addStudent(new Student("Chris", 3, 153, 8.2, 4.0));
    mathClass.addStudent(new Student("Dan", 3, 186, 12.1, 3.6));
    mathClass.addStudent(new Student("Raymond", 4, 149, 11.4, 3.7));;

    System.out.println(mathClass.toString());
    System.out.println("\nTallest Student: " + mathClass.findTallest());
  }
}

class Student {
  private String name;
  private int year;
  private int height;
  private double unitsAttempted;
  private double points;
  private double GPA;

  public Student(String studentName, int yearInSchool, int studentHeight, double studentUnitsAttempted, double studentGradePoints) {
    name = studentName;
    year = yearInSchool;
    height = studentHeight;
    unitsAttempted = studentUnitsAttempted;
    points = studentGradePoints;
  }

  public int getHeight() {
    return height;
  }

  public double getGPA() {
    GPA = unitsAttempted / points;
    return GPA;
  }

  public void reportGrade(int units, int gradePointsEarned) {
    unitsAttempted += units;
    points += gradePointsEarned;
  }

  public String toString() {
    String returnString = "\nName: " + name + "\nYear: " + year + "\nHeight: " + height + "\nGPA: " + GPA + "\nUnits Attempted: " + unitsAttempted + "\nGrade Points: " + points;
    return returnString;
  }
}

class Team {
  private String name;
  private ArrayList<Student> group = new ArrayList<Student>();
  private int classStudents = 0;

  public Team(String teamName) {
    name = teamName;
  }

  // method incorrect
  public Student findTallest() {
    int greatest = 0;
    int idx = 0;
    if (classStudents == 0) {
      return null;
    }

    for (int i = 0; i < classStudents; i++) {
      if (group.get(i).getHeight() > greatest) {
        greatest = group.get(i).getHeight();
        idx = i;
      }
    }
    return group.get(idx);
  }

  public void addStudent(Student newStudent) {
    group.add(newStudent);
  }

  public String toString() {
    String ans = "Class: " + name + "\nStudents: \n";
    for (int i = 0; i < classStudents; i++) {
      ans += group.get(i);
    }
    return ans;
  }
}