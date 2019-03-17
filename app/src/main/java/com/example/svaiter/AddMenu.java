package com.example.svaiter;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuth;


public class AddMenu extends AppCompatActivity implements View.OnClickListener {
    String itemName;
    String itemPrice;
    EditText price, menu;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    Button btnaddmenu, btnaddprice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_menu);
        menu = (EditText) findViewById(R.id.AddMen);
        btnaddmenu = (Button) findViewById(R.id.AddMenu2);
        price = (EditText) findViewById(R.id.price);
        btnaddmenu.setOnClickListener(this);

    }
   /* void  login()
    {
        startActivity(new Intent(this,MainActivity.class));
    }
    public void updatemenu() {
        itemName = menu.getText().toString().trim();
        itemPrice= price.getText().toString().trim();
        if (TextUtils.isEmpty(itemName)) {
            Toast.makeText(this, "please enter name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(itemPrice)) {
            Toast.makeText(this, "please enter price", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Updating Menu...");
        progressDialog.show();

        Task<AuthResult> authResultTask;
        authResultTask = firebaseAuth.createUserWithEmailAndPassword(menu, price).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(AddMenu.this, "Add Successifully...", Toast.LENGTH_SHORT).show();
                    login();
                    return;
                } else login();
                {
                    Toast.makeText(AddMenu.this, "Could not update. Please try again", Toast.LENGTH_SHORT).show();
                    login();
                    return;
                }
            }
        });
        {
        }
    }*/

    @Override
    public void onClick(View view) {
        if (btnaddmenu == view) {
         //   updatemenu();
        }
    }
}
