package utils.Exceptions;

public class EntityMustUseUpdateInsteadOfSave extends Exception{
    public EntityMustUseUpdateInsteadOfSave() {
        super();
    }

    public EntityMustUseUpdateInsteadOfSave(String message) {
        super("\n"+message+"\n");
    }

    public EntityMustUseUpdateInsteadOfSave(String message, Throwable cause) {
        super("\n"+message+"\n", cause);
    }

    public EntityMustUseUpdateInsteadOfSave(Throwable cause) {
        super(cause);
    }

    protected EntityMustUseUpdateInsteadOfSave(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("\n"+message+"\n", cause, enableSuppression, writableStackTrace);
    }
}
