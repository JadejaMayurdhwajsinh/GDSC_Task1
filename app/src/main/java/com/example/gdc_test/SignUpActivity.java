package com.example.gdc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView tvLogin = findViewById(R.id.tv_login);
        Button btn1=findViewById(R.id.btn_sign_up);

        String fullText = "Already have an account? Login";
        SpannableString spannableString = new SpannableString(fullText);

        ClickableSpan loginClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#007bff"));
                ds.setUnderlineText(true);
            }
        };

        // Set the span for "Login"
        int start = fullText.indexOf("Login");
        int end = start + "Login".length();
        spannableString.setSpan(loginClickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvLogin.setText(spannableString);
        tvLogin.setMovementMethod(LinkMovementMethod.getInstance());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

}