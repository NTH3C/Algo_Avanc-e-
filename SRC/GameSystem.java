import java.util.Scanner;

public class GameSystem {

    /**
     *
     * @return
     */
    public static byte randomStart(){
        return (byte) (Math.random() *((3 - 1) ));
    }

    public static boolean winPlayer1() {
        if ((GameBoard.matrice[Main.column2 - 1][Main.line2] == 0) || (GameBoard.matrice[Main.column2][Main.line2 - 1] == 0) ||
                (GameBoard.matrice[Main.column2][Main.line2 + 1] == 0) || (GameBoard.matrice[Main.column2 + 1][Main.line2] == 0)) {
            return true;
        }
       else {
            System.out.println("Player 1 win");
            return false;
        }
    }
    public static boolean winPlayer2() {
        if ((GameBoard.matrice[Main.column1 - 1][Main.line1] == 0) || (GameBoard.matrice[Main.column1][Main.line1 - 1] == 0) ||
                (GameBoard.matrice[Main.column1][Main.line1 + 1] == 0) || (GameBoard.matrice[Main.column1 + 1][Main.line1] == 0)) {
            return true;
        }else {
            System.out.println("Player 2 win");
            return false;
        }
    }

    public static String choosePseudo() {
        System.out.println("Choose a pseudo between 2 and 10 character");
        Scanner scannerpseudo = new Scanner(System.in); //Pseudo input
        String pseudo = scannerpseudo.next();
        if ((pseudo.length() <= 10) && (pseudo.length() >= 2)) {
            return pseudo;
        } else {
            System.out.println("Do it the right way Please");
            return choosePseudo();
        }
    }
}


