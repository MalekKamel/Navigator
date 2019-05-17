package com.sha.kamel.navigator;

import android.os.Handler;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


/**
 * Created by Sha on 4/1/17.
 */

public class FragmentNavigator {
    public static final String DEFAULT_PARCELABLE_NAME = "default_intent_parcelable";


    private FragmentActivity activity;
    private int frameResourceId;

    public FragmentNavigator(@NonNull FragmentActivity activity) {
        this.activity = activity;
    }

    public FragmentNavigator(@NonNull FragmentActivity activity, @IdRes int frameResourceId) {
        this.activity = activity;
        this.frameResourceId = frameResourceId;
    }

    /**
     * Add a fragment to Frame
     * @param fragment instance
     * @param addToBackStack flag
     */
    public void add(Fragment fragment, boolean addToBackStack) {
        navigate(fragment, addToBackStack, TransactionBehavior.ADD);
    }

    /**
     * Add a fragment to Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     */
    public void addDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                null,
                TransactionBehavior.ADD
        );
    }

    /**
     * Add a fragment to Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     * @param callbackAfterNavigation will be called after submitting navigation
     */
    public void addDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis,
            Procedure callbackAfterNavigation
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                callbackAfterNavigation,
                TransactionBehavior.ADD
        );
    }

    /**
     * Replace a fragment in Frame
     * @param fragment instance
     * @param addToBackStack flag
     */
    public void replace(Fragment fragment, boolean addToBackStack) {
        navigate(fragment, addToBackStack, TransactionBehavior.REPLACE);
    }

    /**
     * Replace a fragment in Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     */
    public void replaceDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                null,
                TransactionBehavior.REPLACE
        );
    }

    /**
     * Replace a fragment in Frame after delay time
     * @param fragment instance
     * @param addToBackStack flag
     * @param delayMillis time to delay
     * @param callbackAfterNavigation will be called after submitting navigation
     */
    public void replaceDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis,
            Procedure callbackAfterNavigation
    ) {
        navigateDelayed(
                fragment,
                addToBackStack,
                delayMillis,
                callbackAfterNavigation,
                TransactionBehavior.REPLACE
        );
    }

    private void navigateDelayed(
            Fragment fragment,
            boolean addToBackStack,
            long delayMillis,
            Procedure callbackAfterNavigation,
            TransactionBehavior transactionBehavior
    ) {
        new Handler().postDelayed(
                () -> {
                    navigate(fragment, addToBackStack, transactionBehavior);

                    if (callbackAfterNavigation != null)
                        callbackAfterNavigation.run();
                },
                delayMillis);
    }

    /**
     * Remove the Fragment
     * @param fragment instance
     */
    public void remove(Fragment fragment) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }

    /**
     * Show a DialogFragment with a tag equal to the name of its class
     * @param dialog instance
     */
    public void showDialogFragment(DialogFragment dialog){
        dialog.show(
                activity.getSupportFragmentManager(),
                dialog.getClass().getSimpleName()
        );
    }

    private void navigate(
            Fragment fragment,
            boolean addToBackStack,
            TransactionBehavior transactionBehavior
    ) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();

        switch (transactionBehavior) {
            case ADD:
                ft.add(
                        getFrameResourceId(),
                        fragment,
                        fragment.getClass().getSimpleName()
                );
                break;

            case REPLACE:
                ft.replace(
                        getFrameResourceId(),
                        fragment,
                        fragment.getClass().getSimpleName()
                );
                break;
        }

        if (addToBackStack)
            ft.addToBackStack(fragment.getClass().getSimpleName());

        ft.commitAllowingStateLoss();
    }

    private int getFrameResourceId(){
        if (frameResourceId > 0) return frameResourceId;

        if (NavigatorOptions.instance().frameLayoutId > 0)
            return NavigatorOptions.instance().frameLayoutId;

        throw new RuntimeException("FrameLayout resource id must be provided.");
    }


    private enum TransactionBehavior {
        REPLACE,
        ADD
    }
}
