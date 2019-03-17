package com.example.svaiter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button logout;
    EditText name,userid,password,age;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        logout = (Button) findViewById(R.id.logout);
        name = (EditText) findViewById(R.id.name);
        userid = (EditText) findViewById(R.id.userid);
        age = (EditText) findViewById(R.id.age);
        logout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.logout:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.register :
                startActivity(new Intent(this,Registerhotel.class));
                break;
            case R.id.AddMenu:
                startActivity(new Intent(this,AddMenu.class));
                break;


        }


    }

}
