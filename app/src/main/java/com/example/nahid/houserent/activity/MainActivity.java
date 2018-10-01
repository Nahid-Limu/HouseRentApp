package com.example.nahid.houserent.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;

import com.example.nahid.houserent.R;
import com.example.nahid.houserent.adapter.RecylarViewAdapter;
import com.example.nahid.houserent.model.UserModel;
import com.example.nahid.houserent.network.ApiClient;
import com.example.nahid.houserent.service.ApiService;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CallListener {

    private LinearLayoutManager LayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserlist();
    }

    private void getUserlist() {

        try {
            ApiService service = ApiClient.getRetrofit().create(ApiService.class);

            retrofit2.Call<List<UserModel>> call = service.getUserData();

            call.enqueue(new Callback<List<UserModel>>() {
                @Override
                public void onResponse(retrofit2.Call<List<UserModel>> call, Response<List<UserModel>> response) {

                    List<UserModel> userModelList = response.body();

                    LayoutManager = new LinearLayoutManager(MainActivity.this);

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

                    recyclerView.setLayoutManager(LayoutManager);

                    RecylarViewAdapter recylarViewAdapter = new RecylarViewAdapter(userModelList, MainActivity.this);

                    recyclerView.setAdapter(recylarViewAdapter);

                }

                @Override
                public void onFailure(retrofit2.Call<List<UserModel>> call, Throwable t) {

                }
            });

        } catch (Exception e) {


        }
    }

    @Override
    public void call(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
}
