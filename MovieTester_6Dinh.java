//Minh Dinh Array-A4: Movie Class

/**
 * Creates an 2 instances of the class Movie
 * Paramter for movie title, genre, length, and mpaa rating in constructor
 * Rates the movie
 * Prints movie info and ratings
 */
class MovieTester_6Dinh {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Cars 1", "Animation", 117, "G");
        movie1.Rate(7);
        movie1.Rate(9);
        movie1.Rate(5);
        movie1.Rate(4);
        System.out.println(movie1.toString());
        System.out.printf("Rating Points: %3.1f", movie1.rating);
        System.out.println("\nAmount of ratings: " + movie1.numRating);

        System.out.println();

        Movie movie2 = new Movie("Cars 2", "Animation", 120, "G");
        movie2.Rate(2);
        movie2.Rate(4);
        movie2.Rate(9);
        movie2.Rate(4);
        movie2.Rate(2);
        System.out.println(movie2.toString());
        System.out.printf("Rating Points: %3.1f", movie2.rating);
        System.out.println("\nAmount of ratings: " + movie2.numRating);
    }
}

/**
 * Creates instance variables
 * Constructor sets instance variables
 * Rate method finds the average value of the ratings and the amount of ratings
 * toString method to return the info of the movie
 */
class Movie {
    private String title;
    private String genre;
    private int length;
    private String mpaa;
    private int[] ratings = new int[69];
    int numRating;
    Double rating;

    public Movie(String setTitle, String setGenre, int setLength, String setMpaa) {
        title = setTitle;
        genre = setGenre;
        length = setLength;
        mpaa = setMpaa;
        rating = 0.0;
        numRating = 0;
    }

    public void Rate(int setRating) {
        int sum = 0;
        ratings[numRating] = setRating;
        ++numRating;
        for (int i = 0; i < ratings.length; ++i) {
            sum += ratings[i];
        }
        rating = (double) (sum) / (double) (numRating);
    }

    public String toString() {
        String result = "Movie title: " + title + "\nMovie Genre: " + genre + "\nMovie Length: " + length + " minutes"
                + "\nMpaa Rating: " + mpaa;
        return result;
    }
}