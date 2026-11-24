// UNCHECKED custom exception: extends RuntimeException,
// so the compiler does NOT force callers to catch or declare it.
public class InvalidMarksException extends RuntimeException {
    public InvalidMarksException(String message) {
        super(message);
    }
}