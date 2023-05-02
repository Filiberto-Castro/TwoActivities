package com.zerocode.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.codezero.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mReplyHeadTextView;
    private TextView mReplyMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyMessageTextView = findViewById(R.id.text_message_reply);

    }

    public void launchSecondActivity(View view) {

        Log.d(LOG_TAG, "Button clicked!");

        String message = mMessageEditText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        // Se lanza la actividad secundaria y se espera una respuesta
        startActivityForResult(intent, TEXT_REQUEST);
    }

    // Este método se llama cuando se recibe una respuesta de la actividad secundaria
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Se verifica que se reciba una respuesta de la actividad secundaria y que el código de solicitud coincida
        if (requestCode == TEXT_REQUEST){
            // Se verifica que la actividad secundaria haya finalizado correctamente
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyMessageTextView.setText(reply);
                mReplyMessageTextView.setVisibility(View.VISIBLE);
            }
        }

    }
}