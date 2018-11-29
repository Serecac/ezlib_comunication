package es.ezlib.comunication_test;

import es.ezlib.comunication.EzlibMessage;

public class TestMessage implements EzlibMessage<String> {

    private String name;

    public TestMessage(String name) {
        this.name = name;
    }

    @Override
    public String getMessageInfo() {
        return name;
    }
}
