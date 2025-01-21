package com.github.matsik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subscriber {

    private final String name;
    private final List<String> messages;

    private Subscriber(String name, List<String> messages) {
        this.name = name;
        this.messages = messages;
    }

    public static Subscriber create(String name) {
        return new Subscriber(name, new ArrayList<>());
    }

    public void receive(String message) {
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }
}
