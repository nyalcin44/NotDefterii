package com.neslihan.notuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMail;
    EditText edtSifre;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMail=findViewById(R.id.edt_mail);
        edtSifre=findViewById(R.id.edt_sifre);

        btnLogin=findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eMail=edtMail.getText().toString();
                String sifre=edtSifre.getText().toString();

                if (TextUtils.isEmpty(eMail)||TextUtils.isEmpty(sifre)){

                    Toast.makeText(MainActivity.this,"Lütfen bütün alanları doldurun...",Toast.LENGTH_LONG).show();
                }
                else if(eMail.equals("neslihan@gmail.com")&&sifre.equals("123456")){
                    //Toast.makeText(MainActivity.this,"Tebrikler veriler doğre...",Toast.LENGTH_LONG).show();
                    Intent anaSayfayaGit=new Intent(MainActivity.this,Anasayfa.class);
                    anaSayfayaGit.putExtra("mail",eMail);
                    startActivity(anaSayfayaGit);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "E-mail veya şifre yanlış...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}