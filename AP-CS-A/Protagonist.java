public class Protagonist {
    public static void main(String[] args) {
        Warrior gladiator = new Warrior("Minh");
        gladiator.starve();
        gladiator.starve();
        gladiator.starve();
        gladiator.eat();
        System.out.println(gladiator);
    }
}

class Warrior {
    private String name;
    private int hp = 100;

    public Warrior(String warriorName) {
        name = warriorName;
    }

    public Warrior() {
        name = "Anonymous";
    }

    public void starve() {
        hp = hp - (int) (Math.random() * 5 + 1);
    }

    public void eat() {
        hp = hp + (int) (Math.random() * 10 + 5);
    }

    public String toString() {
        String result = "Warrior Name: " + name + ", Warrior Health: " + hp + " Hp";
        return result;
    }
}