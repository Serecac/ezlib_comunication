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

    public static void createChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.createChannel(channelId);
    }

    public static void createChannels(List<Integer> channelIds) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.createChannels(channelIds);
    }

    public static void deleteChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteChannel(channelId);
    }

    public static void deleteAllChannels() {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteAllChannels();
    }

    public static void suscribeNewComunicatorToChannel(int channelId, int comunicatorId, EzlibComunicator comunicator) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.suscribeNewComunicatorToChannel(channelId, comunicatorId, comunicator);
    }

    public static void suscribeComunicatorToChannel(int channelId, int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.suscribeComunicatorToChannel(channelId, comunicatorId);
    }

    public static void leaveChannel(int channelId, int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.leaveChannel(channelId, comunicatorId);
    }

    public static void clearChannel(int channelId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.clearChannel(channelId);
    }

    /*==============================================================*/
    /*=======================  COMUNICATOR   =======================*/
    /*==============================================================*/

    public static void addComunicator(int comunicatorId, EzlibComunicator comunicator) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.addComunicator(comunicatorId, comunicator);
    }

    public static void deleteComunicator(int comunicatorId) {
        if (ezLibComunicationManager == null)
            init();
        ezLibComunicationManager.deleteComunicator(comunicatorId);
    }

    /*======================================================*/
    /*=======================  SEND  =======================*/
    /*======================================================*/

    public static boolean sendMessageToAll(EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToAll(message);
    }

    public static boolean sendMessageToChannel(int channelId, EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToChannel(channelId, message);
    }

    public static boolean sendMessageToComunicator(int comunicatorId, EzLibMessage message) {
        if (ezLibComunicationManager == null)
            init();
        return ezLibComunicationManager.sendMessageToComunicator(comunicatorId, message);
    }
}
