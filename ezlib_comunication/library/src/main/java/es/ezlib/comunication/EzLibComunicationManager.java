package es.ezlib.comunication;

import android.util.SparseArray;

import java.util.List;

public class EzlibComunicationManager {

    private SparseArray<EzlibChannel> channels;
    private SparseArray<EzlibComunicator> comunicators;

    public EzlibComunicationManager() {
        channels = new SparseArray<>();
        comunicators = new SparseArray<>();
    }

    /*=========================================================*/
    /*=======================  CHANNEL  =======================*/
    /*=========================================================*/

    public void createChannel(int channelId) {
        if (channels != null)
            channels.put(channelId, new EzlibChannel());
    }

    public void createChannels(List<Integer> channelIds) {
        if (channels != null && channelIds != null) {
            for (int channelId : channelIds)
                channels.put(channelId, new EzlibChannel());
        }
    }

    public void deleteChannel(int channelId) {
        if (channels != null && channels.indexOfKey(channelId) >= 0)
            channels.remove(channelId);
    }

    public void deleteAllChannels() {
        if (channels != null)
            channels.clear();
    }

    public void suscribeNewComunicatorToChannel(int channelId, int comunicatorId, EzlibComunicator comunicator) {
        if (channels != null && channels.indexOfKey(channelId) >= 0) {
            channels.get(channelId).addComunicator(comunicatorId, comunicator);
            comunicators.put(comunicatorId, comunicator);
        }
    }

    public void suscribeComunicatorToChannel(int channelId, int comunicatorId) {
        if (channels != null && channels.indexOfKey(channelId) >= 0 && comunicators != null && comunicators.indexOfKey(comunicatorId) >= 0)
            channels.get(channelId).addComunicator(comunicatorId, comunicators.get(comunicatorId));
    }

    public void leaveChannel(int channelId, int comunicatorId) {
        if (channels != null && channels.indexOfKey(channelId) >= 0)
            channels.get(channelId).deleteComunicator(comunicatorId);
    }

    public void clearChannel(int channelId) {
        if (channels != null && channels.indexOfKey(channelId) >= 0)
            channels.get(channelId).clearChannel();
    }

    /*==============================================================*/
    /*=======================  COMUNICATOR   =======================*/
    /*==============================================================*/

    public void addComunicator(int comunicatorId, EzlibComunicator comunicator){
        if (comunicator != null)
            comunicators.put(comunicatorId,comunicator);
    }

    public void deleteComunicator(int comunicatorId){
        if (comunicators != null && comunicators.indexOfKey(comunicatorId) >= 0)
            comunicators.remove(comunicatorId);

        //Also delete comunicator from all channels
        if (channels != null){
            for(int i = 0; i < channels.size(); i++) {
                EzlibChannel channel = channels.get(channels.keyAt(i));
                channel.deleteComunicator(comunicatorId);
            }
        }
    }

    /*======================================================*/
    /*=======================  SEND  =======================*/
    /*======================================================*/

    public boolean sendMessageToAll(EzlibMessage message){
        boolean returnStatus = false;
        if (comunicators != null){
            for(int i = 0; i < comunicators.size(); i++)
                comunicators.get(comunicators.keyAt(i)).receiveMessage(message);
            returnStatus = true;
        }
        return returnStatus;
    }

    public boolean sendMessageToChannel(int channelId, EzlibMessage message) {
        boolean returnStatus = false;
        if (channels != null && channels.indexOfKey(channelId) >= 0){
            channels.get(channelId).sendMessageToAll(message);
            returnStatus = true;
        }
        return returnStatus;
    }

    public boolean sendMessageToComunicator(int comunicatorId, EzlibMessage message) {
        boolean returnStatus = false;
        if (comunicators != null && comunicators.indexOfKey(comunicatorId) >= 0){
                comunicators.get(comunicatorId).receiveMessage(message);
            returnStatus = true;
        }
        return returnStatus;
    }
}
