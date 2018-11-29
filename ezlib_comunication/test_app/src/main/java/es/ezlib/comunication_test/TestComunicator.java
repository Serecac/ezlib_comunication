package es.ezlib.comunication_test;

import android.util.Log;

import es.ezlib.comunication.EzLibMessage;
import es.ezlib.comunication.EzlibComunicator;

public class TestComunicator implements EzlibComunicator {

    private String name;

    public TestComunicator(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(EzLibMessage message) {
        if (message instanceof TestMessage)
            Log.i("TestComunicator", name + " has received => " + ((TestMessage) message).getMessageInfo());
    }
}
