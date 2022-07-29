package com.example.imageeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = findViewById(R.id.mainContainer);
        CustomViewClass customViewClass = new CustomViewClass(this);
        mainContainer.addView(customViewClass);

    }
}