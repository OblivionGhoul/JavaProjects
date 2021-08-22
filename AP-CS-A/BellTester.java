import java.util.List;
import java.util.ArrayList;

class BellTester {
    public static void main(String[] args) {
        BellTester test = new BellTester(); // not needed
        Bell minh = new Bell(222067);
        Bell jake = new Bell(222733);
        Bell brennan = new Bell(222729);
        Bell kay = new Bell(222243);
        Bell terry = new Bell(222351);
        Bell josh = new Bell(224246);
        Bell dan = new Bell(222257);
        Bell ethan = new Bell(222739);
        Bell vincent = new Bell(222835);
        Bell jordan = new Bell(222835);
        List<Bell> students = new ArrayList<>();
        students.add(minh);
        students.add(jake);
        students.add(brennan);
        students.add(kay);
        students.add(terry);
        students.add(josh);
        students.add(dan);
        students.add(ethan);
        students.add(vincent);
        students.add(jordan);
        System.out.println("Student IDs: " + students);
        System.out.print("All Elements:");
        test.evenIndex(students);
        System.out.println();
        System.out.print("All Even Elements:");
        test.evenId(students);
        System.out.println();
        test.firstLast(students);
    }

    public void evenIndex(List<Bell> students) {
        for (int i = 0; i < students.size(); i += 2) {
            System.out.print(students.get(i).toString());
        }
    }

    public void evenId(List<Bell> students) {
        for (Bell student : students) {
            int id = student.id();
            if (id % 2 == 0) {
                System.out.print(student.toString());
            }
        }
    }

    public void firstLast(List<Bell> students) {
        System.out.println(students.get(0).toString() + " is the first on the list.");
        System.out.println(students.get((students.size() - 1)).toString() + " is the last on the list.");
    }
}

class Bell {
    private int studentId;

    public Bell(int id) {
        studentId = id;
    }

    public int id() {
        return studentId;
    }

    public int compareTo(Bell otherBell) {
        return this.id() - otherBell.studentId;
    }

    public String toString() {
        return " " + studentId;
    }
}