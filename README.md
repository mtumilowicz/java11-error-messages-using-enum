# java11-error-messages-using-enum
Simple implementation of error messages handling using enum.

# preface
Creating enum with error messages is very handy practice
when you try to write your code without exceptions (by 
using `Either` for example). For Either basics you should refer
my other github repo: https://github.com/mtumilowicz/java11-vavr-either

# project description
Suppose we have `Sender` class:
```
public class Sender {
    public Either<String, Send> send(Order order) {
        if (!order.isComplete()) {
            return Either.left(OrderErrorMessages.INCOMPLETE.message);
        }
        
        return Either.right(new Send(order));
    }
}
```
* when the order is complete - sends it
* when the order is incomplete - message

We could model it in two different ways:
1. by throwing exception
1. by returning `Either`

In each case error messages contained in enum is a good approach
but when it comes to `Either` - it is very natural.

```
public enum OrderErrorMessages {
    INCOMPLETE("Order should be completed before sending it.");
    public final String message;

    OrderErrorMessages(String message) {
        this.message = message;
    }
}
```

Order and Send are as simple as they can be:
```
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
```

# tests
```
def "test send complete order"() {
    given:
    def sender = new Sender()
    def order = Order.complete()

    when:
    def send = sender.send(order)

    then:
    send.isRight()
    send.get().order == order
}

def "test send incomplete order"() {
    given:
    def sender = new Sender()
    def order = Order.incomplete()

    when:
    def send = sender.send(order)

    then:
    send.isLeft()
    send.getLeft() == "Order should be completed before sending it."
}
```