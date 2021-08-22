public class StudentArrayTester {
    public static void main(String[] args) {
        Student minh = new Student("Minh", 94, 73, 4.1);
        Student raymond = new Student("Raymond", 83, 64, 4.1);
        Student chris = new Student("Chris", 83, 73, 3.4);
        Student alex = new Student("Alex", 95, 75, 3.9);
        Student ben = new Student("Ben", 93, 80, 3.3);
        Student michael = new Student("Michael", 85, 74, 3.3);
        Student sK = new Student("SK", 83, 65, 4.2);
        Student luke = new Student("Luke", 93, 73, 2.4);
        Student robin = new Student("Robin", 93, 78, 3.9);
        Student[] group = {minh, raymond, chris, alex, ben, michael, sK, luke, robin};
        Group students = new Group("APCS Class", group);
        Student sergio = new Student("Sergio", 84, 62, 2.9);
        students.addStudent(sergio);
        students.dropStudent("Michael");
        System.out.println("The tallest student is: " + students.findTallest().name);
        System.out.println(students.toString());
    }
}

class Student {
    String name;
    int grade;
    int height;
    double gpa;

    public Student(String setName, int setGrade, int setHeight, double setGpa) {
        name = setName;
        grade = setGrade; 
        height = setHeight;
        gpa = setGpa;
    }

    public int getHeight() {
        return height;
    }

    public double getGpa() {
        return gpa;
    }

    public void addGrade(int points) {
        grade += points;
    }

    public String toString() {
        return "Student Name: " + name + ", Grade: " + grade + ", Height: " + " inches, GPA:  " + gpa;
    }
}

class Group {
    String teamName;
    Student[] team = new Student[10];
    int teamSize;

    public Group(String setTeamName, Student[] setTeam) {
        teamName = setTeamName;
        for (int i = 0; i < setTeam.length; ++i) {
            team[i] = setTeam[i];
        }
        teamSize = setTeam.length;
    }

    public void addStudent(Student newStudent) {
        if (teamSize < team.length) {
            team[teamSize++] = newStudent;
        } else {
            System.out.println("Unable to add another student because the team is full.");
        }
    }

    public void dropStudent(String dropName) {
        for (int i = 0; i < team.length; ++i) {
            if (dropName.equals(team[i].name)) {
                team[i] = null;
                --teamSize;
            }
        }
    }

    public Student findTallest() {
        int index = 0;
        int tallest = Integer.MIN_VALUE;
        for (int i = 0; i < team.length; ++i) {
            if (team[i] != null) {
                int height = team[i].getHeight();
                if (height > tallest) {
                    tallest = height;
                    index = i;
                }
            }
        }
        return team[index];
    }

    public String toString() {
        String sentence = "Class Name: " + teamName + ", Number Of Students: " + teamSize + ", The students are: ";
        for (int i = 0; i < teamSize; ++i) {
            if (team[i] != null) {
                sentence = sentence + team[i].name + ", ";
            }
        }
        sentence = " and " + sentence + team[teamSize].name + ".";
        return sentence;
    }
}