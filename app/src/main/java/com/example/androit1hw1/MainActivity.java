package com.example.androit1hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    private ImageView imageCar;
    private EditText email, password;
    private Button go;
    private TextView forgotPassword;
    private String url = "http://i.imgur.com/DvpvklR.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pasword);
        go = findViewById(R.id.button_go);
        forgotPassword = findViewById(R.id.forgetpassword);
        imageCar= findViewById(R.id.image_car);
        initListeners();

//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(image_car);



        Picasso.get().load(url).into(imageCar);

    }
    private void initListeners() {
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() < 6) {
                    go.setEnabled(false);
                    showToast("техсе не должен быт менше 6 ти символов");
                } else {
                    go.setEnabled(true);
                }
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("GO");
            }
        });

        forgotPassword.setOnClickListener(v -> {
            showToast("забыл парол");
        });

    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}