package com.jsstech.gmaildemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText to, sub, msg;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = (EditText) findViewById(R.id.to);
        sub = (EditText) findViewById(R.id.sub);
        msg = (EditText) findViewById(R.id.msg);
        button = (Button) findViewById(R.id.btnSend);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String TO = to.getText().toString().trim();
        String SUB = sub.getText().toString().trim();
        String MSG = msg.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TO});
        intent.putExtra(Intent.EXTRA_SUBJECT, SUB);
        intent.putExtra(Intent.EXTRA_TEXT, MSG);
        intent.setType("text/plain");
        try {
            startActivity(Intent.createChooser(intent, "Choose Mail"));
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

//    A Uri object is usually used to tell a ContentProvider what we want to access by reference.
//        It is an immutable one-to-one mapping to a resource or data. The method Uri. parse creates
//        a new Uri object from a properly formated String


