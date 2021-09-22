import java.util.ArrayList;

public class PersonCreator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Student("Brad", "Rose", 2004, "Wassup Breh."));
        people.add(new bellStudent("Joe", "Banana", 2003, "Welcome!"));
        people.add(new presentationStudent("Ana", "Tomato", 2005, "Yuh Bruh!"));

        people.add(new Teacher("Jacob", "Apple", 1990, "Hello!"));
        people.add(new bellTeacher("David", "Strawberry", 1980, "Hi!"));
        people.add(new presentationTeacher("Eda", "Peach", 1985, "Nice to meet you!"));

        for( Person p : people ){
            p.greet();
        }
    }
}

abstract class Person {
    private final String firstName;
    private final String lastName;
    private final int year;
    private static int id = 0;
    private String greeting;

    public Person(String firstName, String lastName, int year, String greeting) {
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.greeting = greeting;
        id++;

        System.out.println("Person " + id + " born!" + " (Year: " + year + ")");
    }

    public String getName() { return firstName + " " + lastName; }

    public String getGreeting() { return greeting; }

    public int getYear() { return year; }

    public void setGreeting(String greeting) { this.greeting = greeting; }

    public abstract void greet();

    @Override
    public String toString() {
        return "ID: " + getYear() + ", Class Name: " + getClass().getName();
    }
}

class Student extends Person {
    public Student(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        System.out.println(getGreeting() + " " + "I am " + getName() + ", a " + getClass().getName() + "!");
    }
}

class Teacher extends Person {
    public Teacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        System.out.println(getGreeting() + " " + "I am " + getName() + ", a " + getClass().getName() + "!");
    }
}

class bellStudent extends Student {
    public bellStudent(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        super.greet();
    }
}

class bellTeacher extends Teacher {
    public bellTeacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        super.greet();
    }
}

class presentationStudent extends Student {
    public presentationStudent(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        super.greet();
    }
}

class presentationTeacher extends Teacher {
    public presentationTeacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
    }

    public void greet() {
        super.greet();
    }
}