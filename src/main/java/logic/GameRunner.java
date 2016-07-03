package logic;

public class GameRunner {

    public static void main(String[] args) {
        Game3x3For2PlayersBuilder builder = new Game3x3For2PlayersBuilder();
        Game game = builder.build();
        game.play();
    }

}
