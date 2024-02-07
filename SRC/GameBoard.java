import java.util.InputMismatchException;
import java.util.Scanner;

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
                else if((y == 5) && (x == 6)){
                    Main.y1 = y;
                    Main.x1 = x;
                    this.matrice[x][y] = 3;
                }
                else if((y == 6) && (x == 6)){
                    Main.y2 = y;
                    Main.x2 = x;
                    this.matrice[x][y] = 4;
                }
                else
                    {
                    this.matrice[x][y] = 0;
                }
            }
        }
    }


    /**
     * Display the map with border
     */
    public void displayMatrice() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                System.out.print(this.matrice[x][y] + " | ");
            }
            System.out.println();
        }
    }

    /*
    *
    * */
    public void mouvment(byte Player) {

        while (Main.isgame) {
            displayMatrice();
            if (Player == 1) {
                if ((matrice[Main.y2 - 1][Main.x2] == 0) || (matrice[Main.y2][Main.x2 - 1] == 0) ||
                        (matrice[Main.y2][Main.x2 + 1] == 0) || (matrice[Main.y2 + 1][Main.x2] == 0)) {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        String response = scanner.next();
                        switch (response) {
                            case "z":
                                if (matrice[Main.y2 - 1][Main.x2] == 0) {
                                    matrice[Main.y2][Main.x2] = 0;
                                    Main.y2--;
                                    matrice[Main.y2][Main.x2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "s":
                                if (matrice[Main.y2 + 1][Main.x2] == 0) {
                                    matrice[Main.y2][Main.x2] = 0;
                                    Main.y2++;
                                    matrice[Main.y2][Main.x2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "q":
                                if (matrice[Main.y2][Main.x2 - 1] == 0) {
                                    matrice[Main.y2][Main.x2] = 0;
                                    Main.x2--;
                                    matrice[Main.y2][Main.x2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "d":
                                if (matrice[Main.y2][Main.x2 + 1] == 0) {
                                    matrice[Main.y2][Main.x2] = 0;
                                    Main.x2++;
                                    matrice[Main.y2][Main.x2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            default:
                                System.out.println("Not this time Clément...");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a VALID character !");
                    }
                } else {
                    System.out.println("Player 1 win");
                    Main.isgame = false;
                }
            }

            else if (Player == 0) {
                if ((matrice[Main.y1 - 1][Main.x1] == 0) || (matrice[Main.y1][Main.x1 - 1] == 0) ||
                        (matrice[Main.y1][Main.x1 + 1] == 0) || (matrice[Main.y1 + 1][Main.x1] == 0)) {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        String response = scanner.next();
                        switch (response) {
                            case "z":
                                if (matrice[Main.y1 - 1][Main.x1] == 0) {
                                    matrice[Main.y1][Main.x1] = 0;
                                    Main.y1--;
                                    matrice[Main.y1][Main.x1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "s":
                                if (matrice[Main.y1 + 1][Main.x1] == 0) {
                                    matrice[Main.y1][Main.x1] = 0;
                                    Main.y1++;
                                    matrice[Main.y1][Main.x1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "q":
                                if (matrice[Main.y1][Main.x1 - 1] == 0) {
                                    matrice[Main.y1][Main.x1] = 0;
                                    Main.x1--;
                                    matrice[Main.y1][Main.x1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "d":
                                if (matrice[Main.y1][Main.x1 + 1] == 0) {
                                    matrice[Main.y1][Main.x1] = 0;
                                    Main.x1++;
                                    matrice[Main.y1][Main.x1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            default:
                                System.out.println("Not this time Clément...");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a VALID character !");
                    }
                } else {
                    System.out.println("Player 2 win");
                    Main.isgame = false;
                }
            }
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
