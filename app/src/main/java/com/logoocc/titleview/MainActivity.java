package com.logoocc.titleview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.logoocc.titleview.views.TitleView;

public class MainActivity extends Activity {

    private TitleView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TitleView) findViewById(R.id.main_title);
//        tv.setLeftImage(R.mipmap.mm);
        tv.setOnLeftClickListener(clickLis);
        tv.setOnRightClickListener(clickLis);
    }

private View.OnClickListener clickLis =new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.title_left:
                    Toast.makeText(getApplicationContext(),"click left",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.title_right:
                    Toast.makeText(getApplicationContext(),"click right",Toast.LENGTH_SHORT).show();
                    break;
            }
    }
};
}
