### Service
This is a demo app on how to implement Service.

### Key Points of Service:

* In Android, a Service is an application component that can perform long-running operations in the background on the UI thread. By background, it means that it doesn’t have a user interface. A Service runs on the main thread of the calling Component’s process by default (and hence can degrade responsiveness and cause ANRs), hence you should create a new Thread to perform long running operations. A Service can also be made to run in a completely different process.
* You cannot directly call public methods in a Service from an Activity without using a Binder. The Binder is used to create a connection between the Activity and the Service, allowing the Activity to communicate with the Service and call its public methods.

### Start service

```
val intent = Intent(this, MyService::class.java)
intent.putExtra("myKey", "myValue")
startService(intent)
```

### Stop service

* Calling stopService() does not stop the service immediately. When stopService() is called, the service is marked for termination and its onDestroy() method is called. However, the system may not immediately destroy the service, as there may still be ongoing work being done in the service.
* The system will destroy the service as soon as it is no longer in use (i.e., all clients have called unbindService() if the service was bound, and there are no pending start requests if the service was started with startService()).


