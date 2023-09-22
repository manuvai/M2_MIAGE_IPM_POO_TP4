package res.exceptions;

public class InvalidEntryException extends NoStackTraceRuntimeException {
    public InvalidEntryException() {
        super("Les paramètres ne sont pas valides.");
    }
}
