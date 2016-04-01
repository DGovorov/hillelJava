package guessNumber;

/**
 * Created by User on 01.04.2016.
 */
public class GameKeeper {
    public void startGame(SecretKeeper computerSecretKeeper, SecretBreaker computerSecretBreaker){
        int assumedNumber = computerSecretBreaker.assumeNumber();
        int result = computerSecretKeeper.checkNumber(assumedNumber);

        while (result != 0){
            assumedNumber = computerSecretBreaker.assumeNumber(result);
            result = computerSecretKeeper.checkNumber(assumedNumber);
        }

        System.out.println("secret number was: " + assumedNumber);

    }

}
