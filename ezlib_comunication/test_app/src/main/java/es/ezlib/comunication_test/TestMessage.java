package es.ezlib.comunication_test;

import es.ezlib.comunication.EzLibMessage;

public class TestMessage implements EzLibMessage<String> {

    private String name;

    public TestMessage(String name) {
        this.name = name;
    }

    @Override
    public String getMessageInfo() {
        return name;
    }
}
