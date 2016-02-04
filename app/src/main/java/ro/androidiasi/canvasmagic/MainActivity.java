package ro.androidiasi.canvasmagic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.androidiasi.canvasmagic.drawable.CircleDrawable;
import ro.androidiasi.canvasmagic.drawable.ClipPathRoundedCornersDrawable;
import ro.androidiasi.canvasmagic.drawable.RoundedCornersRectangleDrawable;
import ro.androidiasi.canvasmagic.view.CheesyView;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button1) Button mButton1;
    @Bind(R.id.button2) Button mButton2;
    @Bind(R.id.button3) Button mButton3;
    @Bind(R.id.button4) Button mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.afterBind();
    }

    private void afterBind(){
        this.mButton1.setText(splitCamelCase(ClipPathRoundedCornersDrawable.class.getSimpleName()));
        this.mButton2.setText(splitCamelCase(RoundedCornersRectangleDrawable.class.getSimpleName()));
        this.mButton3.setText(splitCamelCase(CircleDrawable.class.getSimpleName()));
        this.mButton4.setText(splitCamelCase(CheesyView.class.getSimpleName()));
    }

    @OnClick(R.id.button1) public void onButton1Clicked(){
        ClipPathActivity.start(this);
    }

    @OnClick(R.id.button2) public void onButton2Clicked(){
        RoundedRectangleActivity.start(this);
    }

    @OnClick(R.id.button3) public void onButton3Clicked(){
        CircleActivity.start(this);
    }

    @OnClick(R.id.button4) public void onButton4Clicked(){
        CheesyActivity.start(this);
    }

    private String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }
}
