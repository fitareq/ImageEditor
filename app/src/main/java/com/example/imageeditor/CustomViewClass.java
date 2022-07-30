package com.example.imageeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

public class CustomViewClass extends View {

    private Bitmap destBitmap;
    private Canvas destCanvas = new Canvas();
    private Paint paint = new Paint();
    private Path destPath = new Path();
    private Matrix matrix = new Matrix();

    private Bitmap bmImage = null;

    private Bitmap bitmap;
    public CustomViewClass(Context context) {
        super(context);
        Log.v("@@@@", "constructor");
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.img_lights);
        destBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        destCanvas.setBitmap(destBitmap);
        destCanvas.drawBitmap(bitmap, 0, 0, null);

        paint.setAlpha(20);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(50);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.v("@@@@", "ondraw");
        destCanvas.drawPath(destPath,paint);
        canvas.drawBitmap(destBitmap, 0,0,null);
        super.onDraw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.v("@@@@", "ACTION_DOWN");
                destPath.moveTo(xPos, yPos);
                //destPath.rewind();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.v("@@@@", "ACTION_MOVE");
                destPath.lineTo(xPos, yPos);
                break;
            default:
                    return false;
        }

        invalidate();
        return  true;
    }


    public void invert(){

    }
}
