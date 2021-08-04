package com.example.exerciselistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName,edtPassword;
    Button btnLogin;

    ArrayList<Client> cList = new ArrayList<>();
    public static Client loggedInClient = new Client("","","","");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        fillData();

        btnLogin.setOnClickListener(v -> {
            String userName = edtUserName.getText().toString();
            String password = edtPassword.getText().toString();
            boolean flag = true;
            if(userName.isEmpty()){
                Toast.makeText(this, "Please provide the user name.", Toast.LENGTH_SHORT).show();
                flag = false;
            }else if(password.isEmpty()){
                Toast.makeText(this, "Please provide the password.", Toast.LENGTH_SHORT).show();
                flag = false;
            }
            if(flag){
                if(checkUser(userName,password)){
                    // Code for the next page
                    Toast.makeText(this, "Logged IN", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Provided user name or password is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkUser(String userName, String password){
        for(Client ct: cList){
            if(ct.getUserName().equals(userName) && ct.getPassword().equals(password)){
                loggedInClient = ct;
                return true;
            }
        }
        return false;
    }

    public void fillData(){
        cList.add(new Client("Mani","Gujrat","mani","123"));
        cList.add(new Client("Sarao","Kerla","sarao","345"));
        cList.add(new Client("Mani","Sikkim","mani1","456"));
        cList.add(new Client("Mital","Panjab","mital","678"));
    }
}