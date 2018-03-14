package com.tunjid.quicksettingsbug;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.view.accessibility.AccessibilityEvent;


public class GestureService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        FingerprintGestureController gestureController = getFingerprintGestureController();
        gestureController.registerFingerprintGestureCallback(new FingerprintGestureController.FingerprintGestureCallback() {
            @Override
            public void onGestureDetected(int gesture) {
                performGlobalAction(GLOBAL_ACTION_QUICK_SETTINGS);
            }
        }, null);
    }
}
