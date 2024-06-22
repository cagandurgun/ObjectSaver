/*
 * This code was written by Çağan Durgun.
 */

/**
 * The NotSerializableException class is a type of exception used by the ObjectRecord class.
 * It is thrown when the class intended to be saved has not implemented the Serializable interface.
 */
public class NotSerializableException extends Exception {

    /**
     * Creates a NotSerializableException object.
     *
     * @param message detailed description of the exception
     */
    public NotSerializableException(String message) {
        super(message);
    }
}