package es.ezlib.comunication;

import java.util.List;

public class EzlibComunicationInstance {

    private static EzLibComunicationManager ezLibComunicationManager = null;

    public static void init() {
        ezLibComunicationManager = new EzLibComunicationManager();
    }

    /*=========================================================*/
    /*=======================  CHANNEL  =======================*/
    /*=========================================================*/

    public void createChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.createChannel(channelId);
    }

    public void createChannels(List<Integer> channelIds) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.createChannels(channelIds);
    }

    public void deleteChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteChannel(channelId);
    }

    public void deleteAllChannels() {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteAllChannels();
    }

    public void suscribeNewComunicatorToChannel(int channelId, int comunicatorId, EzlibComunicator comunicator) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.suscribeNewComunicatorToChannel(channelId, comunicatorId, comunicator);
    }

    public void suscribeComunicatorToChannel(int channelId, int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.suscribeComunicatorToChannel(channelId, comunicatorId);
    }

    public void leaveChannel(int channelId, int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.leaveChannel(channelId, comunicatorId);
    }

    public void clearChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.clearChannel(channelId);
    }

    /*==============================================================*/
    /*=======================  COMUNICATOR   =======================*/
    /*==============================================================*/

    public void addComunicator(int comunicatorId, EzlibComunicator comunicator) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.addComunicator(comunicatorId, comunicator);
    }

    public void deleteComunicator(int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteComunicator(comunicatorId);
    }

    /*======================================================*/
    /*=======================  SEND  =======================*/
    /*======================================================*/

    public boolean sendMessageToAll(EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToAll(message);
    }

    public boolean sendMessageToChannel(int channelId, EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToChannel(channelId, message);
    }

    public boolean sendMessageToComunicator(int comunicatorId, EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToComunicator(comunicatorId, message);
    }
}
