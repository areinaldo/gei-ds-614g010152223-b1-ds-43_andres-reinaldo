package e2;

public class SocialDistance {

    /**
     * Given a layout copy the content in another layout with the same length
     * @param layout the layout to copy
     * @return the result layout
     */
    static char[][] copyArray (char [][] layout){
        char [][] resultLayout= new char[layout.length][layout[0].length];
        for(int i = 0; i < layout.length;i++){
            for (int j = 0 ; j < layout[i].length;j++){
                if(layout[i][j] == 'A'){
                    resultLayout[i][j] = 'A';
                }
                if(layout[i][j] == '#'){
                    resultLayout[i][j] = '#';
                }
                if(layout[i][j] == '.'){
                    resultLayout[i][j] = '.';
                }
            }
        }
        return resultLayout;
    }

    /**
     * Given a layout say that if its valid or not
     * @param layaout the layout to check
     * @return true if it's valid, false it's not
     */
    public static boolean isInvalid(char[][] layaout){
        if(layaout == null){
            return false;
        }
        for(int i = 0; i < layaout.length-1;i++){
            if(layaout[i].length != layaout[i+1].length){
                return false;
            }
        }
        for (char[] chars : layaout) {
            for (char aChar : chars) {
                if (aChar != '.' && aChar != 'A') {
                    return false;
                }
            }
        }
        return true;
    }


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
        if (!isInvalid(layout)){
            throw new IllegalArgumentException("The layout is invalid");
        }

        for(int i = 0; i < layout.length;i++){
            for (int j = 0; j < layout[0].length;j++){
                if(layout[i][j] == 'A'){
                    layout[i][j] = '#';
                }
            }
        }
        char [][] resultLayout;
        resultLayout = copyArray(layout);
       boolean stop = false;
       while (!stop ){



            for (int i = 0; i < layout.length;i++){
                for (int j = 0; j < layout[i].length;j++){
                    if(layout[i][j] == '#'){
                        int numStundents = 0;
                        int z = i-1;
                        boolean found = false;
                        while(z < (i-1) +3 && !found){
                            if(z >= 0 && z < layout.length){
                                int y = j-1;
                                while (y < (j-1) +3 && !found ){
                                    if(y >= 0 && y < layout[i].length){
                                        if(layout[z][y] == '#' && (z != i || j != y)){
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
                            resultLayout[i][j] = 'A';
                        }
                    }
                }
            }

            /*
            stop es true para que si en caso de que al comprobar si son iguales las matrices entonces termine el bucle while
            en caso de que no, stop sigue false y copia el contenido de la matriz resultLayout a layout
             */
            stop = true;
            for(int i = 0; i < layout.length;i++){
                for (int j = 0;j < layout[i].length;j++){
                    if (layout[i][j] != resultLayout[i][j]) {
                        stop = false;
                        break;
                    }
                }
            }
            if(!stop){
                layout = copyArray(resultLayout);
            }



            for(int i = 0; i< layout.length;i++ ){
                for(int j = 0; j < layout[i].length;j++){
                    if(layout[i][j] == 'A'){
                        int z = i-1;
                        boolean found = false;
                        while(z < (i-1) +3 && !found){
                            if(z >= 0 && z < layout.length){
                                int y = j-1;
                                while (y < (j-1) +3 && !found ){
                                    if(y >= 0 && y < layout[i].length){
                                        if(layout[z][y] == '#'){
                                            found = true;
                                        }
                                    }
                                    y++;
                                }
                            }
                            z++;

                        }
                        if(!found){
                            resultLayout[i][j] = '#';
                        }
                    }
                }
            }
            layout = copyArray(resultLayout);
        }


        return layout;
    }




}
