package com.github.matsik;

import java.util.HashMap;
import java.util.Map;

public class Publisher {

    private final Map<String, Subscriber> subscribers;

    public Publisher() {
        this.subscribers = new HashMap<>();
    }

    public void publish(String message) {
        subscribers.values()
                .forEach(subscriber -> subscriber.receive(message));
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getName(), subscriber);
    }

    public void removeSubscriber(String name) {
        subscribers.remove(name);
    }

}
