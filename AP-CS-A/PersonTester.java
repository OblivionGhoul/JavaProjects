public class PersonTester {
    public static void main(String[] args) {
        Person newPerson = new Person("Dan");
        System.out.println(newPerson);

        System.out.print("\n");

        Student newStudent = new Student("Minh", 4.0);
        System.out.println(newStudent);
    }
}

class Person {
    private String name;

    public Person( String name ) {
        this.name = name;
    }

    public String toString() {
        return "Person Name: " + name;
    }
}

class Student extends Person {
    private double gpa;

    public Student( String name, double gpa ) {
        super(name);
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + " (" + "Student GPA: " + gpa + ")";
    }
}