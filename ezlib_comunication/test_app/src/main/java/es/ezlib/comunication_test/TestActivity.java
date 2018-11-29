package es.ezlib.comunication_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ezlib.comunication.EzlibComunicationInstance;

public class TestActivity extends AppCompatActivity {

    private final int CHANNEL_1 = 1;
    private final int CHANNEL_2 = 2;

    private final int COMUNICATOR_1 = 1;
    private final int COMUNICATOR_2 = 2;
    private final int COMUNICATOR_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        EzlibComunicationInstance.init();

        EzlibComunicationInstance.createChannel(CHANNEL_1);
        EzlibComunicationInstance.createChannel(CHANNEL_2);

        TestComunicator comunicator_1 = new TestComunicator("Comunicator 1");
        TestComunicator comunicator_2 = new TestComunicator("Comunicator 2");
        TestComunicator comunicator_3 = new TestComunicator("Comunicator 3");

        TestMessage message_1 = new TestMessage("Message 1");
        TestMessage message_2 = new TestMessage("Message 2");
        TestMessage message_3 = new TestMessage("Message 3");
        TestMessage message_4 = new TestMessage("Message 4");

        EzlibComunicationInstance.addComunicator(COMUNICATOR_1, comunicator_1);
        EzlibComunicationInstance.suscribeNewComunicatorToChannel(CHANNEL_1, COMUNICATOR_2, comunicator_2);
        EzlibComunicationInstance.suscribeComunicatorToChannel(CHANNEL_2, COMUNICATOR_2);
        EzlibComunicationInstance.suscribeNewComunicatorToChannel(CHANNEL_2, COMUNICATOR_3, comunicator_3);

        EzlibComunicationInstance.sendMessageToAll(message_1);
        EzlibComunicationInstance.sendMessageToChannel(CHANNEL_1, message_2);
        EzlibComunicationInstance.sendMessageToChannel(CHANNEL_2, message_3);
        EzlibComunicationInstance.sendMessageToComunicator(COMUNICATOR_2, message_4);
    }
}
