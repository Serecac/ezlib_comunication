package es.ezlib.comunication;

import android.util.SparseArray;

class EzlibChannel {

    private SparseArray<EzlibComunicator> subcribedComunicators;

    EzlibChannel() {
        subcribedComunicators = new SparseArray<>();
    }

    SparseArray<EzlibComunicator> getSubcribeComunicators() {
        return subcribedComunicators;
    }

    void setSubcribeComunicators(SparseArray<EzlibComunicator> subcribedComunicators) {
        this.subcribedComunicators = subcribedComunicators;
    }

    void addComunicator(int id, EzlibComunicator comunicator) {
        if (subcribedComunicators != null) {
            subcribedComunicators.put(id, comunicator);
        }
    }

    void deleteComunicator(int id) {
        if (subcribedComunicators != null && subcribedComunicators.indexOfKey(id) > 0) {
            subcribedComunicators.remove(id);
        }
    }

    void clearChannel(){
        if (subcribedComunicators != null)
            subcribedComunicators.clear();
    }

    void sendMessageToAll(EzlibMessage message) {
        if (subcribedComunicators != null) {
            for (int i = 0; i < subcribedComunicators.size(); i++) {
                EzlibComunicator comunicator = subcribedComunicators.get(subcribedComunicators.keyAt(i));
                comunicator.receiveMessage(message);
            }
        }
    }
}
