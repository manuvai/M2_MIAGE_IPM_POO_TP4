package res.exceptions;

public class StockPriceAlreadyRegisteredException extends NoStackTraceRuntimeException {
    public StockPriceAlreadyRegisteredException() {
        super("Le cours de cet action a déjà été enregistré pour cette date");
    }
}
