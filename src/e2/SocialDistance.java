package e2;

public class SocialDistance {
    /**
     * Given the layout of a class with available sites marked with an ’A’ and
     * invalid sites marked with a ’. ’, returns the resulting layout with the
     * sites occupied by the students marked with a ’#’ following two rules :
     * - Students occupy an empty seat if there are no other adjacent students .
     * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
     * @param layout The initial layout .
     * @return The resulting layout .
     * @throws IllegalArgumentException if the initial layout is invalid (is null ,
     * is ragged , includes characters other than ’.’ or ’A ’)).
     */

    public static char [][]seatingPeople(char [][] layout){
        char [][] resultLayout = layout;
        for(int i = 0; i< layout.length;i++ ){
            for(int j = 0; j < layout[i].length;i++){
                if(layout[i][j] == 'A'){
                    int z = i-1;
                    int y = j+1;
                    boolean found = true;
                    while(z < layout.length && found){
                        /*escribir luego*/
                    }
                }
            }
        }
        return resultLayout;
    }

    public boolean checkToSit(char[][] layout, int i, int j){

        if(layout[i-1][j+1] != 'A'){
            return true;
        }else{
            return false
        }
    }
}
