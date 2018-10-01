package com.example.nahid.houserent.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nahid.houserent.R;
import com.example.nahid.houserent.adapter.RecylarViewAdapter;
import com.example.nahid.houserent.model.RegModel;
import com.example.nahid.houserent.model.UserModel;
import com.example.nahid.houserent.network.ApiClient;
import com.example.nahid.houserent.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {

    EditText un_input, up_input,phn_input;
    Button signUp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        un_input = (EditText) findViewById(R.id.un_input);
        up_input = (EditText) findViewById(R.id.up_input);
        phn_input = (EditText) findViewById(R.id.phn_input);
        signUp_btn = (Button) findViewById(R.id.btn_signUp);

        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reg();

            }
        });

    }

    private void reg(){


        try {
            ApiService service = ApiClient.getRetrofit().create(ApiService.class);

            Call<RegModel> call = service.getRegData(un_input.getText().toString().toLowerCase(), up_input.getText().toString(), phn_input.getText().toString());
            call.enqueue(new Callback<RegModel>() {
                @Override
                public void onResponse(Call<RegModel> call, Response<RegModel> response) {

                    Log.e("Reg", response.body().getRegStatus());

                    if (response.body().getRegStatus().equals("successful")){

                        Toast.makeText(getApplicationContext(),"Reg Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                        startActivity(intent);

                    }else {

                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RegModel> call, Throwable t) {
                    Log.e("Teg", t.getMessage().toString());
                }
            });

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


        }

    }
}
