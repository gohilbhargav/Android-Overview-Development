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
   
   No.    Method              Description

   1)     onCreate()          called when activity is first created.

   2)     onStart()           called when activity is becoming visible to the user.

   3)     onResume()          called when activity will start interacting with the user.

   4)     onPause()           called when activity is not visible to the user.

   5)     onStop()            called when activity is no longer visible to the user.

   6)     onRestart()         called after your activity is stopped, prior to start.

   7)     onDestroy()         called before the activity is destroyed.

   
   Activity LifeCycle

   1)  onCreate()
   2)  onStar()
   3)  onResume()
   4)  onPause()
   5)  onStop()
   6)  onDestroy()
   7)  onRestar()
 
   ================================
 
   when application - activity launch :
 
   1) onCreate()
   2) onStar()
   3) onResume()
     
   home button :

   1) onPause()
   2) onStop()
         
   re - open application from backend : 

   1) onRestart()
   2) onStart()
   3) onResume()
     
   when back button press :

   1) onPause()
   2) onStop()
   3) onDestroy()       
   
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



Navigation Component:

Navigation Component is a suite of libraries, tooling and guidance for in-app
navigation.

The compnent centralizes all of the navigation information of your appin a
Navigation graph,providing a robust framework for implementing everything 
from simple button clicks to complex navigation UI patterns


Three Type Of Navigation
1) Navigation Graph
2) NavHost
3) NavController


1)Navigation Graph:

Navigation Graph ia a new xml resource type that defines all possible paths a user can take through an app.
It show visually all the destinations that can be reached from a given destination.

2)NavHost:

The navigation host is an empty container where destinations are swapped in and out as a user
navigates through your app. A navigation host must derive from NavHost.
The Navigation components defualt NavHost implementation, NavHostFragmet, handles swapping
fragment destinations.


3)NavController:

NavController manages app navigation whithin a NavHost.
Apps will generally obtain a controller directly from a host, or by using one of the utility methods on
the navigation class rather than create a controller directly.
NavController swapping of destination content in the navHost as users move throughout app. 




