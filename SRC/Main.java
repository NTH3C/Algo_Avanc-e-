import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    static int line1;  // Player 1 width
    static int column1;  // Player 1 height
    static int line2;  // Player 2 width
    static int column2;  // Player 2 height
    static boolean isgame;  // is true while playing
    static String pseudo1;
    static String pseudo2;
    static String[] pseudos = new String[0];

    static int[] scores = new int[0];
    static  boolean existingPseudo = true;

    public static void main(String[] args) throws IOException {
        GameSystem.loadScores("score.txt");
        MainMenu.displayMainMenu();

    }
}