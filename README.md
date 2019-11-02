

# Android Navigator

A simple wrapper for Android navigation that helps you get rid of a lot of boilerplate code.

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Navigator-green.svg?style=flat )]( https://android-arsenal.com/details/1/6514 ) [![](https://jitpack.io/v/ShabanKamell/Navigator.svg)](https://jitpack.io/#ShabanKamell/Navigator)

<img src="https://github.com/ShabanKamell/Navigator/blob/master/blob/raw/logo.png" height="250">

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
       implementation 'com.github.ShabanKamell:Navigator:x.y.z'
}

```
(Please replace x, y and z with the latest version numbers:  [![](https://jitpack.io/v/ShabanKamell/Navigator.svg)](https://jitpack.io/#ShabanKamell/Navigator))


# Usage

## Modular Navigation

Navigator supports Fragment/Activity navigation

#### Activity
```kotlin
// Declare Addresable Activity
object Profile: AddressableActivity {
     override val className: String = "com.sha.navigator.profile.ProfileActivity"
}
// start Activity
ActivityModuleNavigator(this, packageName).navigate(Profile)
```

#### Fragment

```kotlin
// Declare Addresable Fragment
object Profile: AddressableFragment {
     override val className: String = "com.sha.navigator.profile.ProfileFragment"
}
// Add Fragment
FragmentModuleNavigator(this).add(Profile)
// OR Replace Fragment
FragmentModuleNavigator(this).replace(Profile)
```

## Fragment Navigation

#### Replace Fragment
``` java
 FragmentNavigator(this).replace(ExampleFragment.newInstance()
```

#### Add Fragment
``` java
 FragmentNavigator(this).add(ExampleFragment.newInstance())
```

#### Show DialogFragment
``` java
 FragmentNavigator(this).showDialogFragment(CustomerDialogFragment.newInstance())
```

### Where's FrameLayout's id?
FrameLayout's id can be Provided with 2 ways:
#### 1- Pass in FragmentNavigator Contstructor

```java
   FragmentNavigator(this, R.id.mainFrame)
```

#### 2- Provide only once  in Application class or anywhere

```java
class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NavigatorOptions.frameLayoutId = R.id.mainFrame
    }
}
```

## Activity Navigation
#### Navigate to Activity
``` java
 new ActivityNavigator(this)  
        .navigate(ExampleActivity.class);
```

#### Start Activity For Result
``` java
 ActivityNavigator(this).navigate(ExampleActivity::class.java)
```

#### With Parcelable
``` java
ActivityNavigator(this)
                    .withParcelable(Parcels.wrap(Message("Navigated Immediately")), "message")
                    .navigate(ExampleActivity::class.java)
```

#### With Flags
``` java
  ActivityNavigator(this)  
        .withFlags(new Flags().newTask().singleTop())
        .navigate(ExampleActivity.class)
        
        // OR
        
  ActivityNavigator(this)  
        .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_SINGLE_TOP)
        .navigate(ExampleActivity.class)
```

#### Open App In Google Play
``` java
  ActivityNavigator(this).openInGooglePlay()
```

#### Open Camera
``` java
  ActivityNavigator(this).openCamera(2)
```

#### Open Settings
``` java
  ActivityNavigator(this).navigateToSettings()
```

#### Show Route In Google Map
``` java
 new ActivityNavigator(this).showRouteInGoogleMap(  
        25.095549,  // from lat
        29.644703,  // from lng
        24.457151,  // to lat
        27.184841   // to lng
  );
```

### See 'sample' module for the full code.

## Credit
[Plaid](https://github.com/android/plaid) Modular Navigation

## License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
