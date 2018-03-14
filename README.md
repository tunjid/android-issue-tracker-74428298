# android-issue-tracker-74428298
A repository reproducing Issue 74428298 in the Android Issue Tracker with showing quick settings

Android Accessibility services have the ability to perform global actions, some of witch include GLOBAL_ACTION_NOTIFICATIONS and GLOBAL_ACTION_QUICK_SETTINGS.

The issue however is if the notification bar is already showing, but not expanded to show quick settings, calling GLOBAL_ACTION_QUICK_SETTINGS has no effect for about 6 seconds. Then all of a sudden, the quick settings are abruptly shown with no animation.

This is of issue to me because I have an app in the Play Store that uses the FingerprintGestureController.FingerprintGestureCallback api introduced in Android O to perform actions when the user swipes the finger print sensor.

User's are already beholden to the default gesture on the Google Pixel phones which let's you swipe down once for notifications, and swipe down again for quick settings. This is not possible at the moment due to the issue above. The current work around is to use the AccessibilityNodeInfo API to tap the expand quick settings icon in the notification shade to improve the user experience.

Android P however, removes the expand quick settings button from the notification shade. 

It would be nice if the framework resolved this issue for Android P as the current workaround is no longer valid.

Thanks.
