package guessNumber;

/**
 * Created by User on 01.04.2016.
 */
public class Game {
    public static void main(String[] args) {
        ComputerSecretKeeper secretKeeper = new ComputerSecretKeeper(0, 100);
        ComputerSecretBreaker secretBreaker = new ComputerSecretBreaker(0, 100);

        new GameKeeper().startGame(secretKeeper, secretBreaker);

        /*new GameKeeper().startGame(new HumanSecretKeeper(0, 100), new HumanSecretBreaker(0, 100));*/
    }
}
