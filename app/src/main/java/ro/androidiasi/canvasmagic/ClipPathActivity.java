package ro.androidiasi.canvasmagic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import ro.androidiasi.canvasmagic.drawable.ClipPathRoundedCornersDrawable;

public class ClipPathActivity extends AppCompatActivity {

    @Bind(R.id.image) ImageView mImageView;

    public static void start(Context pContext){
        Intent intent = new Intent(pContext, ClipPathActivity.class);
        pContext.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        this.loadImage(R.drawable.kylo_ren);
    }

    private void loadImage(int pDrawableId){
        InputStream resource = getResources().openRawResource(pDrawableId);
        Bitmap bitmap = BitmapFactory.decodeStream(resource);
        mImageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mImageView.setBackgroundDrawable(new ClipPathRoundedCornersDrawable(bitmap));
    }
}
