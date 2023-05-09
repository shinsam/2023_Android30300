package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 이벤트
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
                //아이디(5)와 패스워드(9~12) 자릿수 체크
                //아이디 : 30000 ,
                EditText userid, passwd;
                userid = findViewById(R.id.userid);
                passwd = findViewById(R.id.passwd);
                String str_userid = userid.getText().toString();
                String str_passwd = passwd.getText().toString();
                Log.d("MSG", str_userid);
                Log.d("MSG", str_passwd);

                //길이체크
                if (str_userid.length() != 5) {
                    Toast.makeText(MainActivity.this, "아이디는 5자리로 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                } else if (str_passwd.length() < 9 || str_passwd.length() > 12) {//패스워드(9~12) 자릿수 체크
                    Toast.makeText(MainActivity.this, "비밀번호는 9~12자리입니다.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (str_userid.equals("30300") && str_passwd.equals("123456789")) {
                    Toast.makeText(MainActivity.this, str_userid + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                    //다음화면으로 이동
                } else {
                    Toast.makeText(MainActivity.this, "아이디 또는 패스워드를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //간략하게 가기
        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ){
            case R.id.btn_info:
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_guide:
                break;
            case R.id.btn_call:
                break;
            case R.id.btn_shop:
                break;

        }
    }
}