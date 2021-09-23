package utils.Exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super("\n"+message+"\n");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super("\n"+message+"\n", cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("\n"+message+"\n", cause, enableSuppression, writableStackTrace);
    }
}
