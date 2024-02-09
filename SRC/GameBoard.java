import java.util.InputMismatchException;
import java.util.Objects;
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
     *
     * cellvalue is the value in the matrix
     */
    public void displayMatrice() {
        // Print column numbers
        System.out.print("  ");
        for (int x = 0; x < this.width; x++) {
            if (x < 10)
                System.out.print(x + "|");
            else
                System.out.print(x + "|");
        }
        System.out.println();

        for (int y = 0; y < this.height; y++) {
            // Print row number
            if (y < 10)
                System.out.print(" " + y + " ");
            else
                System.out.print(y + " ");

            for (int x = 0; x < this.width; x++) {
                int cellValue = this.matrice[x][y];
                switch (cellValue) {
                    case 0:
                        System.out.print("\u001B[47m  \u001B[0m"); // White square
                        break;
                    case 1:
                        System.out.print("\u001B[41m  \u001B[0m"); // Red square
                        break;
                    case 3:
                        System.out.print("\u001B[44m  \u001B[0m"); // Blue square
                        break;
                    case 4:
                        System.out.print("\u001B[43m  \u001B[0m"); // Yellow square
                        break;
                    default:
                        System.out.print(" " + cellValue + " ");
                }
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
                if ((GameSystem.winPlayer1()) && (GameSystem.winPlayer2())) {
                    Scanner scanner = new Scanner(System.in);  // player move input
                    try {
                        System.out.println(Main.pseudo2 + "'s Turn");
                        System.out.println("You are the yellow player");
                        System.out.println("-z : move to top");
                        System.out.println("-d : move to right");
                        System.out.println("-s : move to down");
                        System.out.println("-q : move to left");
                        String response = scanner.next();
                        switch (response) {
                            case "q":
                                // Move player 2 up by pressing z
                                if (matrice[Main.column2 - 1][Main.line2] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.column2--;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo1);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "d":
                                // Move player 2 down by pressing s
                                if (matrice[Main.column2 + 1][Main.line2] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.column2++;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo1);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "z":
                                // Move player 2 left by pressing q
                                if (matrice[Main.column2][Main.line2 - 1] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.line2--;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo1);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "s":
                                // Move player 2 right by pressing d
                                if (matrice[Main.column2][Main.line2 + 1] == 0) {
                                    matrice[Main.column2][Main.line2] = 0;
                                    Main.line2++;
                                    matrice[Main.column2][Main.line2] = 4;
                                    Player = 0;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo1);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            //use the konami code to reverse the map (Secret input)
                            case "uuddlrlrba":
                                EasterEgg.konamiCode();
                                Player = 0;
                                break;
                            default:
                                System.out.println("Not this time Clément...");
                                AudioPlayer.playAudio("sound/error.wav",1000);
                                break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a VALID character !");
                    }
                }else {
                    GameSystem.saveScores("score.txt");
                    Main.isgame=false;
                }
            }
            //We don't know why even after checking a lot but the second player need to reverse matrice parameters, so we had to rewrite the code....
            else if (Player == 0) {
                if ((GameSystem.winPlayer2()) && (GameSystem.winPlayer1())) {
                    Scanner scanner = new Scanner(System.in);
                    try {
                        System.out.println(Main.pseudo2 + "'s Turn");
                        System.out.println("You are the blue player");
                        System.out.println("-z : move to top");
                        System.out.println("-d : move to right");
                        System.out.println("-s : move to down");
                        System.out.println("-q : move to left");
                        String response = scanner.next();
                        switch (response) {
                            case "z":
                                // Move player 2 up by pressing z
                                if (matrice[Main.line1][Main.column1 - 1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.column1--;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo2);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "s":
                                // Move player 2 down by pressing s
                                if (matrice[Main.line1][Main.column1 + 1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.column1++;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo2);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "q":
                                // Move player 2 left by pressing q
                                if (matrice[Main.line1 - 1][Main.column1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.line1--;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo2);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);
                                }
                                break;
                            case "d":
                                // Move player 2 right by pressing d
                                if (matrice[Main.line1+ 1][Main.column1] == 0) {
                                    matrice[Main.line1][Main.column1] = 0;
                                    Main.line1++;
                                    matrice[Main.line1][Main.column1] = 3;
                                    Player = 1;
                                    AudioPlayer.playAudio("sound/move.wav",250);
                                    displayMatrice();
                                    destroy(Main.pseudo2);
                                } else {
                                    System.out.println("This case is used or explosed");
                                    AudioPlayer.playAudio("sound/collision.wav",250);

                                }
                                break;
                            case "uuddlrlrba":
                                //use the konami code to reverse the map (Secret input)
                                EasterEgg.konamiCode();
                                Player = 1;
                                break;
                            default:
                                System.out.println("Not this time Clément...");
                                AudioPlayer.playAudio("sound/error.wav",1000);
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a VALID character !");
                    }
                }else {
                    GameSystem.saveScores("score.txt");
                    Main.isgame=false;
                }
            }
        }
    }

    /**
     * read user's inputs and destroy the associate case
     */
    public void destroy(String pseudo){
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
                        AudioPlayer.playAudio("sound/explosion.wav",500);
                    }else {
                        System.out.println("Not this time clément");
                        AudioPlayer.playAudio("sound/error.wav",1000);
                        destroy(pseudo);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Not this time clément");
                    AudioPlayer.playAudio("sound/error.wav",1000);
                    destroy(pseudo);
                }
            }else {
                System.out.println("Not this time clément");
                AudioPlayer.playAudio("sound/error.wav",1000);
                destroy(pseudo);
            }
        } catch (InputMismatchException e) {
            System.out.println("Not this time clément");
            AudioPlayer.playAudio("sound/error.wav",1000);
            destroy(pseudo);
        }
    }

}



