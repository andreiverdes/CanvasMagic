package ro.androidiasi.canvasmagic.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by andreiverdes on 2/4/16.
 */
public class ClipPathRoundedCornersDrawable extends Drawable {

    private Path mPath;
    private Bitmap mBitmap;

    public ClipPathRoundedCornersDrawable(Bitmap pBitmap){
        mBitmap = pBitmap;
        mPath = new Path();
    }

    @Override public void draw(Canvas canvas) {
        int height = getBounds().height();
        int width = getBounds().width();
        RectF rect = new RectF(0.0f, 0.0f, width, height);
        mPath.addRoundRect(rect, 30f, 30f, Path.Direction.CW);
        canvas.clipPath(mPath);
        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    @Override public void setAlpha(int alpha) {

    }

    @Override public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
