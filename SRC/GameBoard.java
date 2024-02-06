public class GameBoard {

    int[][] matrice;

    public GameBoard(int[][] matrice) {
        this.matrice = matrice;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int[][] matrice) {
        this.matrice = matrice;
    }

    public void matriceGenerator(int width, int heigth){
        for ( int i = 0; i <= heigth; i++){
            for ( int j = 0; j <= width; j++){
                if ((i == 0) || (i == heigth) ){
                    this.matrice[i][j] = 1;
                }
                else if ((j == 0) || (j == width)){
                    this.matrice[i][j] = 1;
                }
                else {
                    this.matrice[i][j] = 0;
                }
            }
        }
    }
}
