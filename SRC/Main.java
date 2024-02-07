public class Main {
    public static void main(String[] args) {

        MainMenu.displayMainMenu();
        int width = 12;
        int height = 13;
        int[][] loadingMap = new int[width][height];
        GameBoard map = new GameBoard(loadingMap, width, height);
        map.matriceGenerator();
        map.displayMatrice();
    }
}