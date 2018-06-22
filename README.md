# android-navigator
[![Bintray Download](https://api.bintray.com/packages/shabankamel/android/navigator/images/download.svg) ](https://bintray.com/shabankamel/android/navigator/_latestVersion) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Navigator-green.svg?style=flat )]( https://android-arsenal.com/details/1/6514 )

##### Android navigation has many boilerplate code. But Navigator will help you get rid of all this boilerplate.
##### For example: 
##### 
```java
new Navigator(this).navigateToFragment(new MyFragment(), true);
```
##### It's trivial!


# Installation

```gradle
dependencies {
    compile 'com.sha.kamel:navigator:1.0.0@aar'
}
```

# Usage:

```java
 public void onClick(View v) {

        Navigator navigator =  new Navigator(this);

        switch (v.getId()) {

            case R.id.btn_a1:
                navigator.navigateToActivity(Activity1.class);
                break;

            case R.id.btn_a2:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .navigateToActivity(Activity2.class);
                break;

            case R.id.btn_a3:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .parcelableName("my_parcel")
                        .navigateToActivity(Activity3.class);
                break;

            case R.id.btn_a4:
                navigator
                        .noHistory()
                        .navigateToActivity(Activity4.class);
                break;

            case R.id.btn_a5:
                navigator.startActivityForResult(Activity5.class);
                break;

            case R.id.btn_a6:
                navigator
                        .requestCode(3)
                        .startActivityForResult(Activity6.class);
                break;

            case R.id.btn_a7:
                navigator.startActivityForResult(Activity7.class, 3);
                break;

            case R.id.btn_a8:
                navigator.navigateToFragment(new Fragment1(), true); // FrameLayout id is provided in Application class
                break;

            case R.id.btn_a9:
                navigator
                        .fragmentData(new ClientInfo())
                        .navigateToFragment(new Fragment2(), true); // FrameLayout id is provided in Application class
                break;

            case R.id.btn_a10:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .navigateToFragment(new Fragment3(), true); // FrameLayout id is provided in Application class

                break;

            case R.id.btn_a11:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .parcelableName("my_parcelable")
                        .navigateToFragment(new Fragment4(), true); // FrameLayout id is provided in Application class
                break;

            case R.id.btn_a12:
                navigator
                        .frameResource(R.id.anotherFrame)
                        .navigateToFragment(new Fragment5(), true);
                break;

            case R.id.btn_a13:
                navigator.navigateToFragment(new Fragment6(), R.id.anotherFrame,true);
                break;

            case R.id.btn_a14:
                navigator
                        .fragmentData(new ClientInfo())
                        .showDialogFragment(new ClientInfoDialogFragment());
                break;

            case R.id.btn_a15:
                navigator
                        .parcelable(Parcels.wrap(new ClientInfo()))
                        .showDialogFragment(new ClientInfoDialogFragment());
                break;
        }
    }
```

```java
// You can optionally put FrameLayout resource id in Applicaction class to replace fragemts to.
// This enables you replace fragments without specifying the resource id each time.
public final class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NavigatorOptions.instance().frameLayoutResource = R.id.mainFrame;
    }
}
```

### See 'app' module for the full code.

# License

## Apache license 2.0
