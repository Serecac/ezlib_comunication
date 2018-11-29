package es.ezlib.comunication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class EzlibComunicationModule {

    @Provides
    @Singleton
    EzLibComunicationManager provideEzLibComunicationManager() {
        return new EzLibComunicationManager();
    }
}
