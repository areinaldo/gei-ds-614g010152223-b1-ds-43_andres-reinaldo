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
        for(int i = 0; i < layout.length-1 ; i++){
           if(layout[i].length != layout[i+1].length){
               throw new IllegalArgumentException();
           }
       }
        for (int i = 0; i < layout.length; i++){
            for (int j = 0; j < layout[i].length;j++){
                if(layout[i][j] == 'A'){
                    layout[i][j] = '#';
                }
            }
        }
        boolean stop = false;
        while (!stop){
            for (int i = 0; i < layout.length;i++){
                for (int j = 0; j < layout[i].length;j++){
                    if(layout[i][j] == '#'){
                        int numStundents = 0;
                        int z = i-1;
                        boolean found = false;
                        while(z < (i-1) +3 && !found){
                            if(z >= 0 && z < layout.length){
                                int y = j-1;
                                while (y <= (j-1) +3 && !found ){
                                    if(y >= 0 && y < layout[i].length){
                                        if(layout[z][y] == '#' && z != i && j != y){
                                            numStundents++;
                                            if(numStundents == 4){
                                                found= true;
                                            }
                                        }
                                    }
                                    y++;
                                }
                            }
                            z++;

                        }
                        if(found){
                            layout[i][j] = 'A';
                            stop = false;
                        }else {
                            stop = true;
                        }
                    }
                }
            }
            for(int i = 0; i< layout.length;i++ ){
                for(int j = 0; j < layout[i].length;j++){
                    if(layout[i][j] == 'A'){
                        int z = i-1;
                        boolean found = true;
                        while(z < (i-1) +3 && found){
                            if(z >= 0 && z < layout.length){
                                int y = j-1;
                                while (y < (j-1) +3 && found ){
                                    if(y >= 0 && y < layout[i].length){
                                        if(layout[z][y] == '#'){
                                            found = false;
                                        }
                                    }
                                    y++;
                                }
                            }
                            z++;

                        }
                        if(found){
                            layout[i][j] = '#';
                            stop = false;
                        }else {
                            stop = true;
                        }
                    }
                }
            }
        }


        return layout;
    }

}
