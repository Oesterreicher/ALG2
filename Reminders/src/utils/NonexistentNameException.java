package utils;

/**
 *
 * @author Jan Österreicher
 */
public class NonexistentNameException extends IllegalArgumentException {

    public NonexistentNameException(String message) {
        super(message);
    }
}