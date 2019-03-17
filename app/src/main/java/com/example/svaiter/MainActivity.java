package com.example.svaiter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button blogin,register ;
    EditText userid,password;
    // ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);
        blogin =  (Button) findViewById(R.id.blogin);
        register = (Button) findViewById(R.id.lregister);
        blogin.setOnClickListener(this);
        register.setOnClickListener(this);
        //   new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    void show()
    {

    }

    void userLogin()
    {

        String email = userid.getText().toString().trim();
        String pass = password.getText().toString().trim();


        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();

            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        // progressDialog.setMessage("login....");
        //progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {if(task.isSuccessful())
            {

                startActivity(new Intent(getApplicationContext(), Welcome.class));
            }
            else
            {
                Toast.makeText(MainActivity.this,"Could not Login Please try again",Toast.LENGTH_SHORT).show();
            }

            }
        });



    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.blogin:
                userLogin();
                break;
                case R.id.lregister:
                startActivity(new Intent(this, Registration.class));
                break;
        }
    }
}
