import java.util.ArrayList;

public class PersonCreator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Student("Minh", "Dinh", 2004, "Wassup Breh."));
        people.add(new bellStudent("Joe", "Banana", 2003, "Welcome!"));
        people.add(new presentationStudent("Ana", "Tomato", 2005, "Yuh Bruh!"));

        people.add(new Teacher("Jacob", "Apple", 1990, "Hello!"));
        people.add(new bellTeacher("David", "Strawberry", 1980, "Hi!"));
        people.add(new presentationTeacher("Eda", "Peach", 1985, "Nice to meet you!"));

        for( Person p : people ){
            p.greet();
        }

        // testing the compareTo() method
        System.out.println(people.get(0).compareTo(people.get(0)));
        System.out.println(people.get(0).compareTo(people.get(1)));
        System.out.println(people.get(1).compareTo(people.get(2)));
        System.out.println(people.get(2).compareTo(people.get(3)));
        System.out.println(people.get(3).compareTo(people.get(4)));
        System.out.println(people.get(4).compareTo(people.get(5)));

        // testing the equals() and clone() method
        Person presTeach = new presentationTeacher("Eda", "Peach", 1985, "Nice to meet you!");
        System.out.println(presTeach.equals(people.get(5)));

        Person personClone1 = people.get(0).clone();
        System.out.println(personClone1.equals(people.get(0)));
        Person personClone2 = people.get(1).clone();
        System.out.println(personClone2.equals(people.get(1)));
        Person personClone3 = people.get(2).clone();
        System.out.println(personClone3.equals(people.get(2)));

        // testing the getFQN() method
        System.out.println(people.get(0).getFQN());
        System.out.println(people.get(1).getFQN());
        System.out.println(people.get(2).getFQN());
        System.out.println(people.get(3).getFQN());
        System.out.println(people.get(4).getFQN());
        System.out.println(people.get(5).getFQN());

        // testing out the specific and family counts
        System.out.println(Person.getSpecificCount());
        System.out.println(Person.getFamilyCount());
        System.out.println(Teacher.getSpecificCount());
        System.out.println(Teacher.getFamilyCount());
    }
}

abstract class Person {
    private final String firstName;
    private final String lastName;
    private final int year;
    private static int id = 0;
    private String greeting;
    private static int specificCount;
    private static int familyCount;

    public Person(String firstName, String lastName, int year, String greeting) {
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.greeting = greeting;
        id++;
        if (getClass().getName().equals("Person")) specificCount++;
        familyCount++;

        System.out.println("Person " + id + " born!" + " (Year: " + year + ")");
    }

    public String getName() { return firstName + " " + lastName; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getGreeting() { return greeting; }

    public int getYear() { return year; }

    public void setGreeting(String greeting) { this.greeting = greeting; }

    public int getId() { return id; }

    public static int getSpecificCount() { return specificCount; }

    public static int getFamilyCount() { return familyCount; }

    public abstract void greet();

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public int compareTo(Person person) {
        if (person instanceof Teacher) {
            return 1;
        } else if (this instanceof Teacher) {
            if (person instanceof Student) {
                return -1;
            } else if (lastName.compareTo(person.getLastName()) == 0) {
                return firstName.compareTo(person.getFirstName());
            } else {
                return lastName.compareTo(person.getLastName());
            }
        } else {
            if (lastName.compareTo(person.getLastName()) == 0) {
                return lastName.compareTo(person.getLastName());
            } else {
                return lastName.compareTo(person.getLastName());
            }
        }
    }

    public boolean equals(Person person) {
        if (id == person.getId()) return true;
        else return false;
    }

    public String getFQN() {
        return getClass().getName() + "." + hashCode() + "." + getId();
    }

    public abstract Person clone();
}

class Student extends Person {
    private static int specificCount;
    private static int familyCount;

    public Student(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);

        if (getClass().getName().equals("Student")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        System.out.println(getGreeting() + " " + "I am " + getName() + ", a " + getClass().getName() + "!");
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new Student(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}

class Teacher extends Person {
    private static int specificCount;
    private static int familyCount;

    public Teacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
        if (getClass().getName().equals("Teacher")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        System.out.println(getGreeting() + " " + "I am " + getName() + ", a " + getClass().getName() + "!");
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new Teacher(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}

class bellStudent extends Student {
    private static int specificCount;
    private static int familyCount;

    public bellStudent(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
        if (getClass().getName().equals("bellStudent")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        super.greet();
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new bellStudent(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}

class bellTeacher extends Teacher {
    private static int specificCount;
    private static int familyCount;

    public bellTeacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
        if (getClass().getName().equals("bellTeacher")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        super.greet();
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new bellTeacher(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}

class presentationStudent extends Student {
    private static int specificCount;
    private static int familyCount;

    public presentationStudent(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
        if (getClass().getName().equals("presentationStudent")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        super.greet();
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new presentationStudent(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}

class presentationTeacher extends Teacher {
    private static int specificCount;
    private static int familyCount;

    public presentationTeacher(String firstName, String lastName, int year, String greeting) {
        super(firstName, lastName, year, greeting);
        if (getClass().getName().equals("presentationTeacher")) specificCount++;
        familyCount++;
    }

    public static int getSpecificCount() {
        return specificCount;
    }

    public static int getFamilyCount() {
        return familyCount;
    }

    public void greet() {
        super.greet();
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Class Name: " + getClass().getName() + ", Name: " + getName() + ", Size: " + getSpecificCount();
    }

    public Person clone(){
        return new presentationTeacher(getFirstName(), getLastName(), getYear(), getGreeting());
    }
}