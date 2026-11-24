// CHECKED custom exception: extends Exception,
// so the compiler FORCES callers to catch it or declare "throws".
public class AttendanceShortageException extends Exception {
    public AttendanceShortageException(String message) {
        super(message);
    }
}