package com.wardrobeapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class StartView extends View {
    private Activity mMainActivity;
    private Bitmap mBitmapWardrobe;
    private float mWidth;
    private float mHeight;


    public StartView(Context context, AttributeSet attrib)
    {
        super(context, attrib);
        mMainActivity = (MainActivity)context;
    }

    private void initBitmapWardobe()
    {
        mBitmapWardrobe = BitmapFactory.decodeResource(getResources(), com.wardrobeapp.R.drawable.wardrobe_liten);
        mBitmapWardrobe = Bitmap.createScaledBitmap(mBitmapWardrobe, (int)mWidth, (int)mHeight, true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //mScreenWidth = canvas.getWidth();
        mHeight = canvas.getHeight();
        /*if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE || (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            if (mMainActivity.getOrientation() == 2)
            {
                mWidth = mScreenWidth / 1.3f;
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }
        }
        else
        {
            mWidth = canvas.getWidth();
        }*/
        mWidth = canvas.getWidth();
        initBitmapWardobe();
        //canvas.drawBitmap(mBitmapWardrobe, getXposition(), 0, null);
        canvas.drawBitmap(mBitmapWardrobe, 0, 0, null);

    }



}
