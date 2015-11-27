package com.developer.samur.reminder;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Samur on 27.11.2015.
 */

//Сохраняет настройки
public class PreferenceHelper {

    public static final String SPLASH_IS_INVISIBLE = "splash_is_invisible"; // константа ключа

    private static PreferenceHelper instance; // создаем поле

    private Context context;

    private SharedPreferences preferences;

    private PreferenceHelper(){

    }

    public static PreferenceHelper getInstance(){
        if (instance == null){
            instance = new PreferenceHelper(); //создаем объект instance
        }
        return instance;

    }

    public void init(Context context){
        this.context = context;

        preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, boolean value){
        SharedPreferences.Editor editor = preferences.edit(); // для внесения изменения в настройки
        editor.putBoolean(key, value);
        editor.apply();// вызываем метод aplly, чтобы изменения вступили в силу

    }

    public boolean getBoolean(String key){ // аргументом является ключ поля с сохраненной настройкой
        return preferences.getBoolean(key,false);

    }
}
