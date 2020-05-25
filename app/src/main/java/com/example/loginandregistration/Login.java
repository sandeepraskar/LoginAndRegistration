package com.example.loginandregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Button _btnLog;
    EditText _txtUsername, _txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _btnLog=findViewById(R.id.btnLog);
        _txtUsername=findViewById(R.id.txtUsername);
        _txtPassword=findViewById(R.id.txtPassword);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Login Form");
        _btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name=_txtUsername.getText().toString();
                String pass_word=_txtPassword.getText().toString();
                String type="login";
                BackgroundTask backgroundTask= new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, user_name, pass_word);

            }
        });
    }
}
