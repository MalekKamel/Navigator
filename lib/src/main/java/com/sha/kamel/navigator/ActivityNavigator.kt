package com.sha.kamel.navigator

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import android.provider.MediaStore
import com.sha.kamel.navigator.model.Flags
import com.sha.kamel.navigator.model.ParcelableInfo

class ActivityNavigator(private val activity: Activity) {
    private val parcelableInfo = ParcelableInfo()
    private var flags = Flags()

    /**
     * Navigate with a class
     * @param clazz type
     */
    fun navigate(clazz: Class<*>) {
        val intent = Intent(activity, clazz)
        navigate(intent)
    }

    /**
     * Navigate with an Intent
     * @param intent instance
     */
    fun navigate(intent: Intent) {
        flags.addToIntent(intent)
        parcelableInfo.addToIntent(intent)
        activity.startActivity(intent)
    }

    /**
     * @param intent instance
     * @param requestCode If >= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    fun startActivityForResult(intent: Intent, requestCode: Int) {
        parcelableInfo.addToIntent(intent)
        flags.addToIntent(intent)
        activity.startActivityForResult(intent, requestCode)
    }

    /**
     * @param clazz class of the activity
     * @param requestCode If >= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    fun startActivityForResult(clazz: Class<*>, requestCode: Int) {
        val intent = Intent(activity, clazz)
        startActivityForResult(intent, requestCode)
    }

    /**
     * Navigate to Google Maps and show route
     * @param route info of the map route
     */
    fun showRouteInGoogleMap(route: MapRoute) {
        showRouteInGoogleMap(
                fromLat = route.fromLat,
                fromLng = route.fromLng,
                toLat = route.toLat,
                toLng = route.toLng
        )
    }

    /**
     * Navigate to Google Maps and show route
     * @param fromLat
     * @param fromLng
     * @param toLat
     * @param toLng
     */
    fun showRouteInGoogleMap(fromLat: Double, fromLng: Double, toLat: Double, toLng: Double) {
        val url = StringBuilder()
                .append("http://maps.google.com/maps?saddr=")
                .append(fromLat)
                .append(",")
                .append(fromLng)
                .append("&daddr=")
                .append(toLat)
                .append(",")
                .append(toLng)
                .toString()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        flags.addToIntent(intent)
        activity.startActivity(intent)
    }

    /**
     * Navigate to system settings
     */
    fun navigateToSystemSettings() {
        val intent = Intent(android.provider.Settings.ACTION_SETTINGS)
        flags.addToIntent(intent)
        activity.startActivity(intent)
    }


    /**
     * Open Camera app
     * @param requestCode If >= 0, this code will be returned in
     *                    onActivityResult() when the activity exits.
     */
    fun openCameraApp(requestCode: Int) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        flags.addToIntent(intent)
        activity.startActivityForResult(intent, requestCode)
    }

    /**
     * Open app in Google Play
     * @param packageName app's package
     */
    @JvmOverloads
    fun openInGooglePlay(packageName: String = activity.packageName) {
        val intent = Intent("android.intent.action.VIEW")
        intent.data = Uri.parse("market://details?id=$packageName")
        flags.newTask()
        navigate(intent)
    }

    /**
     * Pass Parcelable with the intent
     * @param parcelable object
     * @param name key for parcelable
     */
    fun withParcelable(parcelable: Parcelable, name: String): ActivityNavigator {
        this.parcelableInfo.parcelable = parcelable
        this.parcelableInfo.name = name
        return this
    }

    /**
     * add flags
     * @param flags intent flags
     */
    fun withFlags(flags: Flags): ActivityNavigator {
        this.flags = flags
        return this
    }

    /**
     * add flags
     * @param flags intent flags
     */
    fun withFlags(vararg flags: Int): ActivityNavigator {
        this.flags.flags = flags.toMutableList()
        return this
    }

}
