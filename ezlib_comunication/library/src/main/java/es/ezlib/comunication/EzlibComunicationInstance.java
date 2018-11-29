package es.ezlib.comunication;

import java.util.List;

public class EzlibComunicationInstance {

    private static EzlibComunicationManager ezlibComunicationManager = null;

    public static void init() {
        ezlibComunicationManager = new EzlibComunicationManager();
    }

    /*=========================================================*/
    /*=======================  CHANNEL  =======================*/
    /*=========================================================*/

    public static void createChannel(int channelId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.createChannel(channelId);
    }

    public static void createChannels(List<Integer> channelIds) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.createChannels(channelIds);
    }

    public static void deleteChannel(int channelId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.deleteChannel(channelId);
    }

    public static void deleteAllChannels() {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.deleteAllChannels();
    }

    public static void suscribeNewComunicatorToChannel(int channelId, int comunicatorId, EzlibComunicator comunicator) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.suscribeNewComunicatorToChannel(channelId, comunicatorId, comunicator);
    }

    public static void suscribeComunicatorToChannel(int channelId, int comunicatorId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.suscribeComunicatorToChannel(channelId, comunicatorId);
    }

    public static void leaveChannel(int channelId, int comunicatorId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.leaveChannel(channelId, comunicatorId);
    }

    public static void clearChannel(int channelId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.clearChannel(channelId);
    }

    /*==============================================================*/
    /*=======================  COMUNICATOR   =======================*/
    /*==============================================================*/

    public static void addComunicator(int comunicatorId, EzlibComunicator comunicator) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.addComunicator(comunicatorId, comunicator);
    }

    public static void deleteComunicator(int comunicatorId) {
        if (ezlibComunicationManager == null)
            init();
        ezlibComunicationManager.deleteComunicator(comunicatorId);
    }

    /*======================================================*/
    /*=======================  SEND  =======================*/
    /*======================================================*/

    public static boolean sendMessageToAll(EzlibMessage message) {
        if (ezlibComunicationManager == null)
            init();
        return ezlibComunicationManager.sendMessageToAll(message);
    }

    public static boolean sendMessageToChannel(int channelId, EzlibMessage message) {
        if (ezlibComunicationManager == null)
            init();
        return ezlibComunicationManager.sendMessageToChannel(channelId, message);
    }

    public static boolean sendMessageToComunicator(int comunicatorId, EzlibMessage message) {
        if (ezlibComunicationManager == null)
            init();
        return ezlibComunicationManager.sendMessageToComunicator(comunicatorId, message);
    }
}
