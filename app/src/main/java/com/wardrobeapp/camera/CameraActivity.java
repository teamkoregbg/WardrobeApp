package com.wardrobeapp.camera;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wardrobeapp.R;

/**
 * Created by Jonathan Köre on 2018-03-26.
 */

public class CameraActivity extends FragmentActivity {

    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_main);
        setFrag(new EditItemFragment());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void selectFrag(View view) {
        System.out.println("yo");
        Fragment fr = null;

        if(view == findViewById(R.id.addButton))
            fr = new AddItemFragment();
        else if (view == findViewById(R.id.editButton))
            fr = new EditItemFragment();

        setFrag(fr);
    }

    private void setFrag(Fragment fr) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fr);
        ft.commit();
    }

    public void onCapturePhoto(View view) {
        dispatchTakePictureIntent();
    }

    public void onSaveImage(View view) {

    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                //File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File path = Environment.getExternalStorageDirectory();
                File storageDir = new File(path.getAbsolutePath() + "/wardrobe_images");
                if(!storageDir.exists()) {
                    storageDir.mkdir();
                }
                String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                photoFile = ImageCreator.createImageFile(storageDir, fileName);
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.wardrobeapp",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    /*private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }*/
}
