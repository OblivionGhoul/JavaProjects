class PlantTester {
    public static void main(String[] args) {
      Plant plant = new Plant("David", "Snow", 100, 5);
      Tree tree = new Tree("Plant", "Mountains", 10, 10, 100, "Oak");
      Bush bush = new Bush("Bush", "Forest", 29, 50, 23);
  
      System.out.println(plant.toString());
      System.out.println(tree.toString());
      System.out.println(bush.toString());
    }
  }
  
  class Plant {
    private String name;
    private String environment;
    private int population = 0;
    private int age;
    
    public Plant(String name, String environment, int population, int age) {
      this.name = name;
      this.environment = environment;
      this.population = population;
      this.age = age;
    }
  
    public int plant() {
      population++;
      return population;
    }
  
    public int age() {
      age++;
      return age;
    }
    
    public String toString() {
      return "Plant Name: " + name + "\nEnvironment: " + environment + "\nPopulation: " + population + "\nAge: " + age;
    }
  }
  
  class Flower extends Plant{
    private int numPetals;
  
    public Flower(String name, String environment, int population, int age, int numPetals) {
      super(name, environment, population, age);
      this.numPetals = numPetals;
    }
  
    public int pluck() {
      numPetals--;
      return numPetals;
    }
  
    @Override
    public String toString() {
      return "Num of Petals: " + numPetals + "\nPopulation: " + super.plant() + "\nAge: " + super.age();
    }
  
  }
  
  class Tree extends Plant {
    private int size;
    private String type;
  
    public Tree(String name, String environment, int population, int age, int size, String type) {
      super(name, environment, population, age);
      this.size = size;
      this.type = type;
    }
  
    public int trim() {
      size--;
      return size;
    }
  
    @Override
    public String toString() {
      return "Tree Size: " + size + "\nTree Type: " + type+ "\nPopulation: " + super.plant() + "\nAge: " + super.age();
    }
  
  }
  
  class Bush extends Plant {
    private double area;
  
    public Bush(String name, String environment, int population, int age, double area) {
      super(name, environment, population, age);
      this.area = area;
    }
  
    public double trim() {
      area--;
      return area;
    }
  
    @Override
    public String toString() {
      return "Bush Area: " + area + "\nPopulation: " + super.plant() + "\nAge: " + super.age();
    }
  }