package com.example.baikiemtra3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.ImageView;

public class TacPham_profile extends AppCompatActivity {

    ImageView img;
    TextView name, textView;
    Button button;
    EditText editText;
    String getString;

    public static  final  String SHARED_PREF = "shared";
    public static  final  String TEXT = "text";
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        img=findViewById(R.id.profileimage);
        name=findViewById(R.id.username);
        button = findViewById(R.id.save);
        editText = findViewById(R.id.editTextTextSave);
        textView = findViewById(R.id.savetext);

        Intent intent=this.getIntent();

        String username=intent.getStringExtra("name");
        int imageid=intent.getIntExtra("image",R.drawable.tohuu);

        name.setText(username);
        img.setImageResource(imageid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getString = editText.getText().toString();
                textView.setText(getString);

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEXT,textView.getText().toString());
                editor.apply();
            }
        });
        update();

    }

    private void update(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
        textView.setText(text);
    }
}