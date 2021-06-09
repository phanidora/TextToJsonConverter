package exceptions;

/**
 * class to handle exceptions
 */
public class InvalidConfigEntry extends Exception {

    /**
     * constructor of the class to call the constructor of Exception class
     */
    public InvalidConfigEntry() {
        super();
    }

    /**
     * setting the exception to string
     * @param message which is caught exception
     */
    public InvalidConfigEntry(String message) {
        super(message);
    }

    /**
     * custom exception
     * @param message
     * @param innerException
     */
    public InvalidConfigEntry(String message, Exception innerException) {
        super(message, innerException);
    }
}
