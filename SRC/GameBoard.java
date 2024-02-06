public class GameBoard {

    int[][] matrice;
    int width;
    int height;

    /**
     *
     * @param matrice
     * @param widht
     * @param height
     */
    public GameBoard(int[][] matrice, int widht, int height) {
        this.matrice = matrice;
        this.width = widht;
        this.height = height;
    }

    /**
     * Generate a map where case have for value 0 and border have the value 1
     */
    public void matriceGenerator(){
        int y; //height
        int x; //width
        for (y = 0; y < this.height; y++){
            for (x = 0; x < this.width; x++){
                if ((y == 0) || (y == this.height-1) ){
                    this.matrice[x][y] = 1;
                }
                else if ((x == 0) || (x == this.width-1)){
                    this.matrice[x][y] = 1;
                }
                else
                    {
                    this.matrice[x][y] = 0;
                }
            }
        }
    }

    public int[][] displayMatrice(int height, int width){
        if ((height == 12) && (width == 11)){
            return;
        }
        else if (width == 11){
            height++;
            return matrice[width][height] + displayMatrice(height, 0) + "\n";
        }
        else {
            return matrice[width][height] + displayMatrice(height, width + 1);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }
}
