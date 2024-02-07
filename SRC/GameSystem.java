import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
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


    /**
     * add a new pseudo and score entry to the scorees or updates the score if the pseudo already exists
     *
     * @param pseudos    Array storing the pseudos
     * @param scores     Array storing the scores
     * @param pseudo     The pseudo to be added or updated
     * @param score      The score associated with the pseudo
     */
    public static void addOrUpdatePseudoScore(String[] pseudos, int[] scores, String pseudo, int score) {
        int existingIndex = searchPseudoIndex(pseudos, pseudo);

        if (existingIndex != -1) {
            // Pseudo already exists update the score
            scores[existingIndex] += score;
        } else {
            // does not exist add a new pseudo
            int newIndex = pseudos.length; // New index for the pseudo
            pseudos = resizeArrayStr(pseudos, newIndex + 1);
            scores = resizeArrayInt(scores, newIndex + 1);
            pseudos[newIndex] = pseudo;
            scores[newIndex] = score;
        }
    }

    /**
     * Search for the index of a specified pseudo in the array
     *
     * @param pseudos      Array storing the pseudo
     * @param targetPseudo The pseudo to search
     * @return index of the target pseudo if found, or -1 if not found
     */
    public static int searchPseudoIndex(String[] pseudos, String targetPseudo) {
        for (int i = 0; i < pseudos.length; i++) {
            if (pseudos[i].equals(targetPseudo)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Resize the str array to the new length
     *
     * @param array     The array to resize.
     * @param newLength The new length of the array.
     * @return The resized array of strings.
     */
    private static String[] resizeArrayStr(String[] array, int newLength) {
        // Create a new array with the specified length
        String[] newArray = new String[newLength];

        // Copy elements from the original array to the new array
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newLength));

        // Return the resized array of strings
        return newArray;
    }

    /**
     * Resize the int array to the new length
     *
     * @param array     The array to resize
     * @param newLength The new length of the array
     * @return The resized array of integers
     */
    private static int[] resizeArrayInt(int[] array, int newLength) {
        // Create a new array with the specified length
        int[] newArray = new int[newLength];

        // Copy elements from the original array to the new array
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newLength));

        // Return the resized array of integers
        return newArray;
    }


    public static void printPseudosAndScores() {
        // Print the pseudos and scores
        for (int i = 0; i < Main.pseudos.length; i++) {
            System.out.println("Pseudo: " + Main.pseudos[i] + ", Score: " + Main.scores[i]);
        }
    }

}



