package com.example.svaiter;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    Button register;
    EditText name;
    EditText userid;
    EditText password;
    EditText age;
    TextView textview1;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        progressDialog  = new ProgressDialog(this);
        firebaseAuth =FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);
        register = (Button)findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        userid = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);
        age = (EditText) findViewById(R.id.age);
        register.setOnClickListener(this);

    }
    public void sendEmailVerification() {
        // [START send_email_verification]
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
        // [END send_email_verification]
    }
    void  login()
    {
        startActivity(new Intent(this,MainActivity.class));
    }
    public void registerUser() {
        String uname = name.getText().toString().trim();
        final String email = userid.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String age1 = age.getText().toString().trim();
        if (TextUtils.isEmpty(uname)) {
            Toast.makeText(this, "please enter name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(age1)) {
            Toast.makeText(this, "please enter age ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "please enter password ", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registring User.....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            { progressDialog.dismiss();
                if (task.isSuccessful())
                {
                    firebaseAuth.getCurrentUser().sendEmailVerification()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Registration.this, "Registration Successful. " +
                                        "Check email for verification", Toast.LENGTH_SHORT).show();

                                login();
                                return;
                            }
                            else{
                                Toast.makeText(Registration.this, "Registration Unsuccessful.", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }else {
                    Toast.makeText(Registration.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();

                }

            }
        });
        {
        }
    }



    @Override
    public void onClick (View view)
    {if (register == view)
    {
        registerUser();
    }




    }
}

