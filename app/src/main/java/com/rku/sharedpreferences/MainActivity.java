package com.rku.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    String prefname="score";
    TextView txtmessage;
    String key ="count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmessage=findViewById(R.id.count_val);
        preferences=getSharedPreferences("score",MODE_PRIVATE);
        editor=preferences.edit();

        //int counter=getPreferenceValue(key);
        updateCounterTextView(key);

    }
    int getPreferenceValue(String keyForPref)
    {
        return preferences.getInt(keyForPref,0);
    }
    void updateCounterTextView(String keyForPref)
    {
        int counter=getPreferenceValue(keyForPref);
        txtmessage.setText(String.valueOf(counter));
    }

    public void IncrementbyOne(View view) {
        int counter=getPreferenceValue(key);
        counter++;
        editor.putInt(key,counter);
        editor.commit();
        updateCounterTextView(key);
    }

    public void resetValue(View view) {
        editor.putInt(key,0);
        editor.commit();
        updateCounterTextView(key);
    }

    public void removeValue(View view) {
        editor.remove(key);
        editor.commit();
        updateCounterTextView(key);
    }
}