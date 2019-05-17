

# Android Navigator

A simple wrapper for Android navigation that saves you a lot of boilerplate code.

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Navigator-green.svg?style=flat )]( https://android-arsenal.com/details/1/6514 )

## Install

#### Gradle:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}

dependencies {
       implementation 'com.github.ShabanKamell:Navigator:1.1.0'
}

```

# Usage

## Fragment

#### Replace Fragment
``` java
 new FragmentNavigator(this).replace(  
        ExampleFragment.newInstance(),  
        true // Add to back stack
 );
```

#### Add Fragment
``` java
 new FragmentNavigator(this, R.id.mainFrame).add(  
        ExampleFragment.newInstance(),  
        false
 );
```
#### Replace Fragment Delayed
``` java
 new FragmentNavigator(this).replaceDelayed(  
        ExampleFragment.newInstance(),  
        true, 
        1000  
 );
```

#### Add Fragment Delayed
``` java
 new FragmentNavigator(this).addDelayed(  
        ExampleFragment.newInstance(),  
        true, 
        1000  
 );
```

#### Show DialogFragment
``` java
 new FragmentNavigator(this)  
        .showDialogFragment(CustomerDialogFragment.newInstance());
```

### Where's FrameLayout's id?
FrameLayout's id can be Provided with:
```java
NavigatorOptions.instance().frameLayoutId = R.id.mainFrame;
```
This id will be used every time you navigate not a fragment unless you specify one at call site.

**Note**: The best approach is to add the id in Application class like this:
```java
public final class MyApp extends Application {  
  
    @Override  
  public void onCreate() {  
      super.onCreate();  
      NavigatorOptions.instance().frameLayoutId = R.id.mainFrame;  
  }  
  
}
```
Also, you can add the id at call site:
```java
 new  FragmentNavigator(this, R.id.mainFrame);
```

## Activity
#### Navigate to Activity
``` java
 new ActivityNavigator(this)  
        .navigate(ExampleActivity.class);
```
#### Navigate to Activity Delayed
``` java
 new ActivityNavigator(this)  
        .navigateDelayed(ExampleActivity.class, 1000);
```

#### Start Activity For Result
``` java
 new ActivityNavigator(this)  
        .startActivityForResult(ExampleActivity.class, 1);
```

#### With Parcelable
``` java
 new ActivityNavigator(this)  
        .withParcelable(Parcels.wrap(new Message("A message")), "message")  
        .navigate(ExampleActivity.class);
```

#### With Flags
``` java
 new ActivityNavigator(this)  
        .withFlags(new Flags().newTask().singleTop())
        .navigate(ExampleActivity.class);
        
        // OR
        
 new ActivityNavigator(this)  
        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_SINGLE_TOP)
        .navigate(ExampleActivity.class);
```

#### Open App In Google Play
``` java
 new ActivityNavigator(this).openInGooglePlay();
```

#### Open Camera
``` java
 new ActivityNavigator(this).openCamera(2);
```

#### Open Settings
``` java
 new ActivityNavigator(this).navigateToSettings();
```

#### Show Route In Google Map
``` java
 new ActivityNavigator(this).showRouteInGoogleMap(  
        25.095549,  // lat1 
        29.644703,  // lng1
        24.457151,  // lat2
        27.184841   // lng2
  );
```

### See 'app' module for the full code.

### License

 Apache license 2.0
