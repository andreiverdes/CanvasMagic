package ro.androidiasi.canvasmagic.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by andreiverdes on 2/4/16.
 */
public class ClipPathImageView extends View {

    private Bitmap mImageBitmap;
    private RectF mRectangle;
    private Path mPath;

    public ClipPathImageView(Context context) {
        super(context);
        this.init();
    }

    public ClipPathImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ClipPathImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init(){
        this.setLayerType(LAYER_TYPE_SOFTWARE, null);
        this.mPath = new Path();
    }

    @Override protected void onDraw(Canvas canvas) {
        if(mImageBitmap == null){
            return;
        }
        if(mRectangle == null){
            mRectangle = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        mPath.addRoundRect(mRectangle, 30f, 30f, Path.Direction.CW);
        canvas.clipPath(mPath);
        canvas.drawBitmap(mImageBitmap, 0, 0, null);
        canvas.restore();
    }

    public void setImageBitmap(Bitmap pImageBitmap){
        this.mImageBitmap = pImageBitmap;
        this.invalidate();
    }
}
