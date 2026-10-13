package com.siddhartha.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("vpn");
    }

    public native String cppMessage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText(cppMessage());
        textView.setTextSize(24);

        setContentView(textView);
    }
}
