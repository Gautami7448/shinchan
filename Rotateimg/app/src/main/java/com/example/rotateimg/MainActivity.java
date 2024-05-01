package com.example.rotateimg;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton rotateButton;
    private boolean isRotating = false;
    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        rotateButton = findViewById(R.id.rotateButton);

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRotating) {
                    startRotation();
                    isRotating = true;
                } else {
                    stopRotation();
                    isRotating = false;
                }
            }
        });
    }

    private void startRotation() {
        rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(1000); // Adjust duration as needed
        imageView.startAnimation(rotateAnimation);
    }

    private void stopRotation() {
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopRotation();
    }
}
