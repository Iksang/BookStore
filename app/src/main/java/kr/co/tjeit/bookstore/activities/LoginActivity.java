package kr.co.tjeit.bookstore.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.co.tjeit.bookstore.R;

public class LoginActivity extends AppCompatActivity {

    private EditText idEdt;
    private EditText pwEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idEdt.getText().toString().equals("admin")
                        && pwEdt.getText().toString().equals("12341234")){
                    Log.d("IS","메인액티비티 이동");
                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,
                            "로그인에 실패했습니다. \n아이디와 비번을 확인해주세요!.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void bindViews(){
        idEdt = (EditText)findViewById(R.id.idEdt);
        pwEdt = (EditText)findViewById(R.id.pwEdt);
        loginBtn = (Button)findViewById(R.id.loginBtn);
    }



}
