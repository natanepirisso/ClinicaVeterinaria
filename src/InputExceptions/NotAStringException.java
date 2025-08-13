package InputExceptions;

public class NotAStringException extends RuntimeException {
    public NotAStringException(String message) {
        super(message);
    }
}
