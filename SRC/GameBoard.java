import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {

    static int[][] matrice;
    int width;
    int height;

    /**
     * constructor of the matrice with widht and height parameter's
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
        // Print column numbers outside the frame
        System.out.print("    ");
        for (int x = 0; x < this.width; x++) {
            if (x < 10)
                System.out.print(" " + x + "  ");
            else
                System.out.print(" " + x + " ");
        }
        System.out.println();

        for (int y = 0; y < this.height; y++) {
            // Print the top border of the row
            System.out.print("   ");
            for (int x = 0; x < this.width; x++) {
                System.out.print("╔═══");
            }
            System.out.println("╗");

            // Print the line number
            if (y < 10)
                System.out.print(" " + y + " ");
            else
                System.out.print(y + " ");

            for (int x = 0; x < this.width; x++) {
                // Print the left border of the cell
                System.out.print("║ " + this.matrice[x][y] + " ");
            }
            // Print the right border of the last cell
            System.out.println("║");

            // Print the middle separator if not the last row
            if (y != this.height - 1) {
                System.out.print("   ");
                for (int x = 0; x < this.width; x++) {
                    System.out.print("╠═══");
                }
                System.out.println("╣");
            }
        }

        // Print the bottom border of the matrix
        System.out.print("   ");
        for (int x = 0; x < this.width; x++) {
            System.out.print("╚═══");
        }
        System.out.println("╝");
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
                if ((GameSystem.winPlayer1()) && (GameSystem.winPlayer2())) {
                    Scanner scanner = new Scanner(System.in);  // player move input
                    try {
                        System.out.println(Main.pseudo2 + "'s Turn");
                        String response = scanner.next();
                        switch (response) {
                            case "q":
                                // Move player 2 up by pressing z
                                if (matrice[Main.column2 - 1][Main.line2] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.column2--;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                    destroy();
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
                                    destroy();
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
                                    destroy();
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
                                    destroy();
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
                }else {
                    Main.isgame=false;
                }
            }

            else if (Player == 0) {
                if ((GameSystem.winPlayer1()) && (GameSystem.winPlayer2())) {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        System.out.println(Main.pseudo2 + "'s Turn");
                        String response = scanner.next();
                        switch (response) {
                            case "z":
                                // Move player 2 up by pressing z
                                if (matrice[Main.line1][Main.column1 - 1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.column1--;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                    destroy();
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
                                    destroy();
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
                                    destroy();
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
                                    destroy();
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
                }else {
                    Main.isgame=false;
                }
            }
        }
    }

    /**
     * read user's inputs and destroy the associate case
     */
    public void destroy(){
        Scanner scannerDestroy = new Scanner(System.in);
        try {
            System.out.println("Enter the column you want to aim at :");
            int column = scannerDestroy.nextInt();
            if ((column >= 1) && (column <= 12)) {
                try {
                    System.out.println("Enter the line you want to aim at :");
                    int line = scannerDestroy.nextInt();
                    if ((line >= 1) && (line <= 11) && (matrice[column][line] == 0)) {
                        matrice[column][line] = 1;
                    }else {
                        System.out.println("Not this time clément");
                        destroy();}
                } catch (InputMismatchException e) {
                    System.out.println("Not this time clément");
                    destroy();
                }
            }else {
                System.out.println("Not this time clément");
                destroy();
            }
        } catch (InputMismatchException e) {
            System.out.println("Not this time clément");
            destroy();
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



