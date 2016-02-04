package ro.androidiasi.canvasmagic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import ro.androidiasi.canvasmagic.view.CheesyView;

public class CheesyActivity extends AppCompatActivity {

    @Bind(R.id.cheesy_view) CheesyView mCheesyView;

    public static void start(Context pContext){
        Intent intent = new Intent(pContext, CheesyActivity.class);
        pContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheesy);
        ButterKnife.bind(this);
        this.afterBind();
    }

    private void afterBind() {
        this.mCheesyView.drillHoles(7,100);
    }
}
