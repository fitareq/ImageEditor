package com.example.imageeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainContainer;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = findViewById(R.id.mainContainer);
        button = findViewById(R.id.invert);


        CustomViewClass customViewClass = new CustomViewClass(this);
        mainContainer.addView(customViewClass);
        button.setOnClickListener(view -> {
            customViewClass.invert();
        });

    }
}