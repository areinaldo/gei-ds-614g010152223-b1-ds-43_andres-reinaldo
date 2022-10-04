package e4;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Movie {

    private String title;
    private List <MovieRating> valoration;


    /**
     * Creates a new movie with the list of ratings empty .
     * @param title Movie title .
     */
    public Movie ( String title ) {
        this.title = title;
        valoration= new ArrayList<>();
    }
    /**
     * Returns the movie title
     * @return the movie title .
     */
    public String getTitle () {

        return title;
    }

    /**
     * Inserts a new movieRating .
     * It is allowed to insert NOT_RATED .
     * @param movieRating MovieRating to be inserted .
     */
    public void insertRating ( MovieRating movieRating ) {
        valoration.add(movieRating);
    }
    /**
     * Check if this movie has any rating .
     * @return true if and only if there is a valuation other than NOT_RATED .
     */
    private boolean isRated () {
        if(valoration.isEmpty() ){
            return false;
        }else {
            return true;
        }
    }
    /**
     * Gets the highest rating for this movie .
     * @return maximum rating ; or NOT_RATED if there are no ratings .
     */
    public MovieRating maximumRating () {
        MovieRating mostRated;
        if(!isRated()){
            return MovieRating.NOT_RATED;
        }else {
            mostRated = valoration.get(0);
            for (int i = 1; i < valoration.size();i++){
                if(mostRated.getNumericRating() < valoration.get(i).getNumericRating()){
                    mostRated = valoration.get(i);
                }
            }
        }
        return mostRated;
    }
    /**
     * Calculate the numerical average rating of this movie .
     * NOT_RATED values are not considered .
     * @return Numerical average rating of this movie .
     * @throws java . util . NoSuchElementException if there are no valid ratings .
     */
    public double averageRating () {
        int count = 0;
        float result = 0;
        for(int i =0;i<valoration.size();i++){
            if(valoration.get(i) != MovieRating.NOT_RATED){
                result = result + valoration.get(i).getNumericRating();
                count++;
            }
        }
        if(result == 0){
            throw new NoSuchElementException();
        }
        return (result/count);
    }
}
