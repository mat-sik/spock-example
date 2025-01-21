package com.github.matsik

import spock.lang.Specification

class SubscriberSpec extends Specification {

    def "should create subscriber with expected name"() {
        given:
        def subscriberName = "foo"

        expect:
        def subscriber = Subscriber.create(subscriberName)
        subscriber.getName() == subscriberName
    }

    def "should receive expected messages"() {
        given:
        def subscriber = Subscriber.create("foo");
        def expectedMessages = ["one", "two"]

        when:
        expectedMessages.forEach { subscriber.receive(it) }

        then:
        subscriber.getMessages() == expectedMessages
    }

    def "should handle receiving no messages gracefully"() {
        given:
        def subscriber = Subscriber.create("foo");

        expect:
        subscriber.messages.isEmpty()
    }

    def "should not allow modifying messages view"() {
        given:
        def subscriber = Subscriber.create("foo");
        ["one", "two"].forEach { subscriber.receive(it) }

        when:
        def messagesView = subscriber.getMessages()
        messagesView.add("three")

        then:
        UnsupportedOperationException ex = thrown()
    }

}
