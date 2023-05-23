package com.zerocode.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.zerocode.twoactivities.extra.REPLY";
    private TextView text_message;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);
        text_message = findViewById(R.id.text_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        text_message.setText(message);

        Log.d(LOG_TAG, "_____________");
        Log.d(LOG_TAG, "OnCreate");

    }

    public void returnReply(View view) {

        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }

    // CICLO DE VIDA Y ESTADO DE LA ACTIVITY

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "OnDestroy");
    }

}