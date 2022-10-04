package e4;

public enum MovieRating {
    NOT_RATED,
    AWFUL(0),
    BAD (2),
    MEDIOCRE(4),
    GOOD(6),
    EXCELLENT(8),
    MASTERPIECE(10);

    private int valor;

    MovieRating(int valor) {
        this.valor = valor;
    }

    MovieRating() {

    }

    public int getNumericRating(){
        return valor;
    }


    boolean isBetterThan(MovieRating m){
        if(this.valor > m.getNumericRating() || m.getNumericRating() == NOT_RATED.getNumericRating()){
            return true;
        }else {
            return false;
        }
    }
}
