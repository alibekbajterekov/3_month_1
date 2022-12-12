package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editTheme;
    private EditText editMessage;
    private AppCompatButton btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail = findViewById(R.id.edit_email);
        editTheme = findViewById(R.id.edit_themes);
        editMessage = findViewById(R.id.edit_message);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(view -> {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{editEmail.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, editTheme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, editMessage.getText().toString());
                startActivity(intent);

        });
    }
}