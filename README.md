# Android-Overview-Development

1) What is software?

   Software is a set of instructions, data or programs used to operate computers
   and execute specific tasks. Software is a generic term used to refer to
   applications, scripts and programs that run on a device.


2) What is mobile application?

   A mobile app is a software application developed specifically for use on small,
   wireless computing devices, such as smartphones and tablets, rather than
   desktop or laptop computers.


3) Difference between mobile application and web application 

   Mobile application :

   1) Mobile apps are developed for a specific
      platform, such as iOS for the Apple iPhone or
      Android

   2) They are downloaded and installed via an app
      store such as Google Play Store and Apple Store

   3) Mobile apps may work offline.

   4) Mobile apps are comparatively faster than web
      applications.


   Web application :

   1) Web Apps are accessed via the internet
      browser and will function according to the
      device you’re viewing them on

   2) Web apps are not native to a particular system
      and there is no need to be downloaded or
      installed.

   3) In order to run web apps need an active
      internet connection.

   4) Web applications are comparatively slower.
   
   
4) What is R.java file

   It is an auto generated file 
   Which contain all the resource entries like….
   Layouts, colors , strings, theme etc…
   
5) What is activity and activity lifecycle

   Activity:
   
      An activity provides the window in which the app draws its UI. This window typically fills the screen, 
   but may be smaller than the screen and float on top of other windows. Generally, one activity 
   implements one screen in an app.
   
   Activity Lifecycle is controlled by 7 methods of android .
   
   Method              Description

   onCreate()          called when activity is first created.

   onStart()           called when activity is becoming visible to the user.

   onResume()          called when activity will start interacting with the user.

   onPause()           called when activity is not visible to the user.

   onStop()            called when activity is no longer visible to the user.

   onRestart()         called after your activity is stopped, prior to start.

   onDestroy()         called before the activity is destroyed.

   
   Activity LifeCycle

   ->  onCreate()
   ->  onStar()
   ->  onResume()
   ->  onPause()
   ->  onStop()
   ->  onDestroy()
   ->  onRestar()
 
   ================================
 
   when application - activity launch :
 
   onCreate()
   onStar()
   onResume()
     
   home button :

   onPause()
   onStop()
         
   re - open application from backend : 

   onRestart()
   onStart()
   onResume()
     
   when back button press :

   onPause()
   onStop()
   onDestroy()       
   
6) What is fragment and fragment to activity

   Fragment:
       Android Fragment is the part of activity, it is also known as sub-activity. There can be more than one 
   fragment in an activity. Fragments represent multiple screen iFragment lifecycle:nside one activity.
   
   Fragment lifecycle:
   
   No.       Method                            Description

   1)        onAttach(Activity)                it is called only once when it is attached with activity.

   2)        onCreate(Bundle)                  It is used to initialize the fragment.

   3)        onCreateView(LayoutInflater,      creates and returns view hierarchy.
               ViewGroup, Bundle)   
                        
   4)        onActivityCreated(Bundle)         It is invoked after the completion of onCreate() method.

   5)        onViewStateRestored(Bundle)       It provides information to the fragment that all the saved state of fragment view hierarchy                                                              has been restored.

   6)        onStart()                         makes the fragment visible.

   7)        onResume()                        makes the fragment interactive.

   8)        onPause()                         is called when fragment is no longer interactive.

   9)        onStop()                          is called when fragment is no longer visible.

   10)       onDestroyView()                   allows the fragment to clean up resources.

   11)       onDestroy()                       allows the fragment to do final clean up of fragment state.

   12)       onDetach()                        It is called immediately prior to the fragment no longer being associated with its activity.





