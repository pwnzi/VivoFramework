package vivo.util;

import android.annotation.VivoHook;
import android.annotation.VivoHook.VivoHookType;
import android.content.Context;
import android.provider.Settings.System;

@VivoHook(hookType = VivoHookType.PUBLIC_API_CLASS)
public class FtFindPhoneLockUtil {
    private static final String TAG = "FtFindPhoneLockUtil";

    public static boolean isFindPhoneLocked(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "FindPhoneLocked", 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setFindPhoneUnlocked(Context context) {
        System.putInt(context.getContentResolver(), "FindPhoneLocked", 0);
    }
}
