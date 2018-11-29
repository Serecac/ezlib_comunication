package es.ezlib.comunication;

import android.util.SparseArray;

public class EzlibChannel {

    private SparseArray<EzlibComunicator> subcribedComunicators;

    public EzlibChannel() {
        subcribedComunicators = new SparseArray<>();
    }

    public SparseArray<EzlibComunicator> getSubcribeComunicators() {
        return subcribedComunicators;
    }

    public void setSubcribeComunicators(SparseArray<EzlibComunicator> subcribedComunicators) {
        this.subcribedComunicators = subcribedComunicators;
    }

    public void addComunicator(int id, EzlibComunicator comunicator) {
        if (subcribedComunicators != null) {
            subcribedComunicators.put(id, comunicator);
        }
    }

    public void deleteComunicator(int id) {
        if (subcribedComunicators != null && subcribedComunicators.indexOfKey(id) > 0) {
            subcribedComunicators.remove(id);
        }
    }

    public void clearChannel(){
        if (subcribedComunicators != null)
            subcribedComunicators.clear();
    }

    public void sendMessageToAll(EzLibMessage message) {
        if (subcribedComunicators != null) {
            for (int i = 0; i < subcribedComunicators.size(); i++) {
                EzlibComunicator comunicator = subcribedComunicators.get(subcribedComunicators.keyAt(i));
                comunicator.receiveMessage(message);
            }
        }
    }
}
