package dev.wardrobeapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.wardrobeapp.camera.CameraActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent getGameScreenIntent = new Intent(this, CameraActivity.class);
        startActivity(getGameScreenIntent);
    }
}
