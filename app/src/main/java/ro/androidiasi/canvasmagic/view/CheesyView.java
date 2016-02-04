package ro.androidiasi.canvasmagic.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by andreiverdes on 2/4/16.
 */
public class CheesyView extends View {

    private Drawable mDrawable;
    private Bitmap mDrawingBitmap;
    private Paint mPaint;

    private int mColumns;
    private int mCount;
    private boolean mStartDrilling;

    public CheesyView(Context context) {
        super(context);
        this.init();
    }

    public CheesyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public CheesyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init(){
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mPaint.setColor(Color.BLUE);
    }

    @Override protected void onDraw(Canvas pCanvas) {
        super.onDraw(pCanvas);
        if(!mStartDrilling){
            return;
        }
        if(mDrawingBitmap == null){
            this.mDrawingBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(mDrawingBitmap);
            RectF rect = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            canvas.drawRoundRect(rect, 30, 30, mPaint);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
//            canvas.drawCircle(getWidth()/2, getHeight()/2, getHeight()/2, mPaint);
            drawCircles(canvas);
        }
        if(mDrawingBitmap != null){
            pCanvas.drawBitmap(mDrawingBitmap, 0, 0, null);
        }
    }

    private void drawCircles(Canvas pCanvas){
        for (int i = 0; i < mCount; i++) {
            int line = i / mColumns;
            int column = i % mColumns;
            float radius = getWidth()/mColumns;
            float cx = .5f * radius + radius * column;
            float cy = .5f * radius + radius * line;
            pCanvas.drawCircle(cx, cy, .4f * radius, mPaint);
        }
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mDrawingBitmap != null && !mDrawingBitmap.isRecycled()) {
            mDrawingBitmap.recycle();
            mDrawingBitmap = null;
        }
    }

    public void drillHoles(int pColumns, int pCount){
        this.mColumns = pColumns;
        this.mCount = pCount;
        this.mStartDrilling = true;
        this.invalidate();
    }
}
