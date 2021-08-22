public class StudentClass {
    public static void main(String[] args) {
        // student 1
        Student freshman = new Student();
        freshman.initialize("Josh Apple");
        freshman.location("Bellarmine College Prep");
        freshman.grad(2024);
        System.out.println(freshman);
        // student 2
        Student sophomore = new Student();
        sophomore.initialize("Bryce Grape");
        sophomore.location("Bellarmine College Prep");
        sophomore.grad(2023);
        System.out.println(sophomore);
        // student 3
        Student junior = new Student();
        junior.initialize("Ethan Banana");
        junior.location("Bellarmine College Prep");
        junior.grad(2022);
        System.out.println(junior);
        // student 3 change schools
        junior.changeSchool("Fremont High School");
        System.out.println("(Junior Transfers School)" + junior);
    }
}

class Student {
    // instance variables
    private String name;
    private String school;
    private int year;

    public void initialize(String studentName) {
        name = studentName;
    }

    public void location(String studentSchool) {
        school = studentSchool;
    }

    public void grad(int studentYear) {
        year = studentYear;
    }

    public void changeSchool(String newSchool) {
        school = newSchool;
    }

    public String toString() {
        String result = "Student Name: " + name + ", Student School: " + school + ", Student Year: " + year;
        return result;
    }
}