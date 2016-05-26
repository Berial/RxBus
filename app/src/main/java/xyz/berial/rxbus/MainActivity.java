package xyz.berial.rxbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import rx.functions.Action1;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NextActivity.class));
            }
        });

        RxBus.postSticky("1", "2", "3");

        RxBus.getSticky(Integer.class).subscribe(new Action1<Integer>() {

            @Override
            public void call(Integer integer) {
                Log.d(TAG, integer.toString());
            }
        });
    }
}
