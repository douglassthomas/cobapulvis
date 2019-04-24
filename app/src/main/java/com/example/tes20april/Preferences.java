package com.example.tes20april;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    private static final String KEY_SEDANG_LOGIN = "logged in";

    public static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getKeySedangLogin() {
        return KEY_SEDANG_LOGIN;
    }


}
