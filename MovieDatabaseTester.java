/**
 * Creates a movie instances and prints them out
 * Inserts an age
 */
class MovieDatabaseTester {
  public static void main(String[] args) {
    Movies person1 = new Movies(31);
    Movies person2 = new Movies(10);
    Movies person3 = new Movies(21);
    //best pg rated movie
    System.out.println(person1.getBestMovie());
    //best movie overall
    System.out.println(person2.getBestMovie());
    //longest pg rated movie
    System.out.println(person1.getDateMovie());
    //longest movie overall
    System.out.println(person2.getDateMovie());
    //randon movie
    System.out.println(person3.getrandomMovie());
  }
}
/**
 * Creates arrays
 * Uses age to calculate which movies are best
 */
class Movies {
  String[] movies = new String[10];
  int[] movieLength = new int[10];
  double[] movieRating = new double[10];
  String[] rMovies = {"American Sniper", "Robocop", "Joker", "Aliens", "1917"};
  int[] rLength = {103, 142, 97, 101, 105};
  double[] rRating = {8.3, 7.3, 8.3, 8.3, 9.5};
  String[] pgMovies = {"The Goonies", "Abominable", "Brave", "COCO", "Up"};
  int[] pgLength = {152, 132, 79, 73, 102};
  double[] pgRating = {7.3, 7.7, 8.3, 7.1, 9.4};


  public Movies (int age) {
    if (age < 17) {
      movies = pgMovies;
      movieLength = pgLength;
      movieRating = pgRating;
    } else {
      for (int i = 0; i < movies.length; ++i) {
        if (i < 5) {
          movies[i] = rMovies[i];
          movieLength[i] = rLength[i];
          movieRating[i] = rRating[i];
        } else {
          movies[i] = pgMovies[i - 5];
          movieLength[i] = pgLength[i - 5];
          movieRating[i] = pgRating[i - 5];
        }
      }
    }
  }

  public String getBestMovie() {
    double rating = 0;
    int count = 0;
    for (int i = 0; i < movieRating.length; ++i) {
      if (movieRating[i] > rating) {
        rating = movieRating[i];
      }
    }
    for (int i = 0; i < movieRating.length; ++i) {
      if (movieRating[i] == rating) {
        break;
      }
      ++count;
    }
    return movies[count];
  }

  public String getDateMovie() {
    int length = 0;
    int count = 0;
    for (int i = 0; i < movieLength.length; ++i) {
      if (movieLength[i] > length) {
        length = movieLength[i];
      }
    }
    for (int i = 0; i < movieLength.length; ++i) {
      if (movieLength[i] == length) {
        break;
      }
      ++count;
    }
    return movies[count];
  }

  public String getrandomMovie() {
    int num = (int)(Math.random() * 10);
    if (movies.length == 10) {
      return movies[num];
    } else {
      num = (int)(Math.random() * 5);
      return movies[num];
    }
  }
}