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

To declare a Service in your AndroidManifest.xml file, you can use the <service> element. Here is an example:
```
<service
android:name=".MyService"
android:enabled="true"
android:exported="false" />
```

* The android:enabled attribute is used to indicate whether the Service is enabled or not. When android:enabled is set to true, the Service is enabled and can be started or bound to by other components in the application or by other applications. 
* If android:enabled is set to false, the Service is disabled and cannot be started or bound to by other components or applications. This is useful when you want to temporarily disable a Service without removing it from the manifest file.
* By default, the android:enabled attribute is set to true. If you do not explicitly set the attribute in your manifest file, it will default to true.
* When android:exported is set to "false", it means that the component is not available for use by other applications or components. This is the default value for this attribute, and it is generally a good practice to keep it set to "false" for components that do not need to be accessed by other applications or components.

### Stop service

* Calling stopService() does not stop the service immediately. When stopService() is called, the service is marked for termination and its onDestroy() method is called. However, the system may not immediately destroy the service, as there may still be ongoing work being done in the service.
* The system will destroy the service as soon as it is no longer in use (i.e., all clients have called unbindService() if the service was bound, and there are no pending start requests if the service was started with startService()).

### Note

* Starting from Android 11 (API level 30), when an app is in the background and its processes are no longer in use, the system may stop the app's background services. This means that if the app has no running components or if its running components are no longer being used by the user, the system may decide to stop the app's processes in order to free up system resources and improve performance.


