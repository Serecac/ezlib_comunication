<img src="https://github.com/Serecac/ezlib_comunication/blob/master/ezlib.png" alt="Ezlib" width="128" height="128">

Ezlib Comunication
=======

This library allows you to create an event bus to send messages to the different components that make up the application.

How to use
-------
Put the .aar file (Ezlib_Comunication_x.y.z.aar) in the folder "Libs" inside the module.

In your project build.gradle. Add the following lines
```
flatDir {
	dirs 'libs'
}
```
```
dependencies {
	implementation(name: 'Ezlib_Comunication_x.y.z', ext: 'aar')
}
```

------------------------------------------------------

There are two ways to access EzlibComunicationManager:
- Accessing directly using EzlibComunicationInstance (recommended)
- Use dagger to inject the dependencies using EzlibComunicationModule
(Both options are exclusive. Only one of the two options should be used to avoid creating more than one EzlibComunicationManager and this will cause problems)

**EzlibComunicationInstance**

First the instance must be initialized (it is not mandatory). It is recommended to do it at the beginning in the Application class.
```
EzlibComunicationInstance.init();
```

Then you can create channels, add your communicators and send messages.
```
EzlibComunicationInstance.addComunicator(<comunicator_id>, <comunicator>);
EzlibComunicationInstance.createChannel(<channel_id>);
EzlibComunicationInstance.sendMessageToChannel(<channel_id>, <message>);
```


**EzlibComunicationModule**

The library provides a module that can be injected directly by dagger into your project.
```
@Provides
@Singleton
EzLibComunicationManager provideEzLibComunicationManager() {
	return new EzLibComunicationManager();
}
```

EzlibComunicator
-------
An EzlibComunicator is an interface that allows other objects to subscribe to the event bus, or some custom channel, to receive messages. 
It is NOT necessary to be an EzlibComunicator to send messages.
An EzlibComunicator can be in more than one active channel.

EzlibChannel
-------
The EzlibChannels allow several EzlibComunicators to be grouped so that if a message is sent to the channel, all the EzlibComunicators that are subscribed to the EzlibChannel will receive it.


------------------------------------------------------

Different Ways to send
-------
- sendMessageToAll(<message>);
- sendMessageToChannel(<channel_id>, <message>);
- sendMessageToComunicator(<comunicator_id>, <message>)


Contribution
=======
You are always welcome to contribute and help us mantain the library. 

<img src="https://github.com/Serecac/ezlib_comunication/blob/master/ezlib.png" alt="Ezlib" width="128" height="128">