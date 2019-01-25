/**
 * Created by mtumilowicz on 2019-01-24.
 */
public enum OrderErrorMessages {
    INCOMPLETE("Order should be completed before sending it.");
    public final String message;

    OrderErrorMessages(String message) {
        this.message = message;
    }
}
