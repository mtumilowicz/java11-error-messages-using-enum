import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2019-01-25.
 */
class SenderTest extends Specification {
    
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
}
