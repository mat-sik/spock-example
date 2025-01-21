package com.github.matsik

import spock.lang.Specification

class PublisherSpec extends Specification {

    def "should pass each published messages to subscribers"() {
        given:
        Subscriber subscriberOne = Mock {
            1 * getName() >> "one"
        }
        Subscriber subscriberTwo = Mock {
            1 * getName() >> "two"
        }

        def publisher = new Publisher()
        publisher.addSubscriber(subscriberOne)
        publisher.addSubscriber(subscriberTwo)

        when:
        expectedMessages.forEach {
            publisher.publish(it)
        }

        then:
        expectedMessages.forEach {
            1 * subscriberOne.receive(it)
            1 * subscriberTwo.receive(it)
        }
        0 * _

        where:
        expectedMessages << [
                ["one", "two", "three"],
                ["one"],
                []
        ]
    }

    def "should not publish message to removed subscriber"() {
        given:
        def message = "foo"

        def toRemoveSubscriberName = "one"
        Subscriber toRemoveSubscriber = Mock {
            1 * getName() >> toRemoveSubscriberName
        }

        Subscriber subscriber = Mock {
            1 * getName() >> "two"
        }

        def publisher = new Publisher()
        publisher.addSubscriber(toRemoveSubscriber)
        publisher.addSubscriber(subscriber)

        when:
        publisher.removeSubscriber(toRemoveSubscriberName)
        publisher.publish(message)

        then:
        1 * subscriber.receive(message)
        0 * _
    }

    def "should properly handle publish if there are no subscribers"() {
        given:
        def publisher = new Publisher()

        when:
        publisher.publish("foo")

        then:
        0 * _

        noExceptionThrown()
    }

}
