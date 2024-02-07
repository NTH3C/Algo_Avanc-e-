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
                    Main.column1 = y;
                    Main.line1 = x;
                    this.matrice[x][y] = 3;
                }
                else if((y == 6) && (x == 6)){
                    Main.column2 = y;
                    Main.line2 = x;
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
                System.out.print(this.matrice[x][y] + " ║ ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param Player
     *this function allow the player to move when the game is started
     *
     * x1 == player one width
     * y1 == player one height
     * x2 == player two width
     * y2 == player two height
     * isgame == is the game started // if false == victory condition
     *
     * matrice is the game board
     */
    public void mouvment(byte Player) {


        while (Main.isgame) {
            displayMatrice();
            if (Player == 1) {
                if ((matrice[Main.column2 - 1][Main.line2] == 0) || (matrice[Main.column2][Main.line2 - 1] == 0) ||
                        (matrice[Main.column2][Main.line2 + 1] == 0) || (matrice[Main.column2 + 1][Main.line2] == 0)) {
                    Scanner scanner = new Scanner(System.in);  // player move input
                    try {
                        String response = scanner.next();
                        switch (response) {
                            case "q":
                                // Move player 2 up by pressing z
                                if (matrice[Main.column2 - 1][Main.line2] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.column2--;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "d":
                                // Move player 2 down by pressing s
                                if (matrice[Main.column2 + 1][Main.line2] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.column2++;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "z":
                                // Move player 2 left by pressing q
                                if (matrice[Main.column2][Main.line2 - 1] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.line2--;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "s":
                                // Move player 2 right by pressing d
                                if (matrice[Main.column2][Main.line2 + 1] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.line2++;
                                    matrice[Main.column2][Main.line2] = 4;
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
                if ((matrice[Main.column1 - 1][Main.line1] == 0) || (matrice[Main.column1][Main.line1 - 1] == 0) ||
                        (matrice[Main.column1][Main.line1 + 1] == 0) || (matrice[Main.column1 + 1][Main.line1] == 0)) {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        String response = scanner.next();
                        switch (response) {
                            case "z":
                                // Move player 2 up by pressing z
                                if (matrice[Main.line1][Main.column1 - 1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.column1--;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "s":
                                // Move player 2 down by pressing s
                                if (matrice[Main.line1][Main.column1 + 1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.column1++;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "q":
                                // Move player 2 left by pressing q
                                if (matrice[Main.line1 - 1][Main.column1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.line1--;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                } else {
                                    System.out.println("This case is used or explosed");
                                }
                                break;
                            case "d":
                                // Move player 2 right by pressing d
                                if (matrice[Main.line1+ 1][Main.column1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.line1++;
                                    matrice[Main.line1][Main.column1] = 3;
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
