package com.example.nahid.houserent.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nahid.houserent.R;
import com.example.nahid.houserent.model.LoginModel;
import com.example.nahid.houserent.model.RegModel;
import com.example.nahid.houserent.network.ApiClient;
import com.example.nahid.houserent.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText uesrName,uesrPass;
    Button btn_login,btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uesrName = (EditText) findViewById(R.id.uesrName);
        uesrPass = (EditText) findViewById(R.id.uesrPass);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_reg = (Button) findViewById(R.id.btn_reg);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override

        });


    }


    private void login(){


        try {
            ApiService service = ApiClient.getRetrofit().create(ApiService.class);

            Call<LoginModel> call = service.getLoginData(

                    uesrName.getText().toString().toLowerCase(),
                    uesrPass.getText().toString()
            );

            call.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                    Log.e("Reg", response.body().getLoginStatus());

                    if (response.body().getLoginStatus().equals("successful")){

                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AddPostActivity.class);
                        startActivity(intent);

                    }else {

                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                        uesrName.getText().clear();
                        uesrPass.getText().clear();                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    Log.e("Teg", t.getMessage().toString());
                }
            });

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


        }

    }
}
