import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by mtumilowicz on 2019-01-24.
 */
public class Sender {
    public Either<String, Send> send(Order order) {
        if (!order.isComplete()) {
            return Either.left(OrderErrorMessages.INCOMPLETE.message);
        }
        
        return Either.right(new Send(order));
    }
}

@Value
class Send {
    Order order;
}

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Order {
    boolean complete;
    
    static Order incomplete() {
        return new Order(false);
    }
    
    static Order complete() {
        return new Order(true);
    }
}
