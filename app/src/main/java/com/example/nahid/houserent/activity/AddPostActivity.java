package com.example.nahid.houserent.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nahid.houserent.R;
import com.example.nahid.houserent.model.PostModel;
import com.example.nahid.houserent.network.ApiClient;
import com.example.nahid.houserent.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostActivity extends AppCompatActivity {

    Spinner sp_houseType, sp_bed, sp_drawing, sp_dinning, sp_kitchen, sp_bathroom;
    EditText rent, phn, address, date;
    Button btn_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        sp_houseType = (Spinner) findViewById(R.id.spinner_houseType);
        sp_bed = (Spinner) findViewById(R.id.sp_bed);
        sp_drawing = (Spinner) findViewById(R.id.sp_drawing);
        sp_dinning = (Spinner) findViewById(R.id.sp_dinning);
        sp_kitchen = (Spinner) findViewById(R.id.sp_kitchen);
        sp_bathroom = (Spinner) findViewById(R.id.sp_bathroom);

        rent = (EditText) findViewById(R.id.rent);
        phn = (EditText) findViewById(R.id.phn);
        address = (EditText) findViewById(R.id.address);
        date = (EditText) findViewById(R.id.date);


        btn_post = (Button) findViewById(R.id.btn_post);


        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });

        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        break;

                    case 1:

                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

    }


    private void addPost(){


        try {
            ApiService service = ApiClient.getRetrofit().create(ApiService.class);

            Call<PostModel> call = service.getPostData(

                    sp_houseType.getSelectedItem().toString(),
                    rent.getText().toString(),


                    //details
                            "No Of Bed: "+sp_bed.getSelectedItem().toString()+"\n"+
                            "No Of DrawingRoom: "+sp_drawing.getSelectedItem().toString()+"\n"+
                            "No Of Dining: "+sp_dinning.getSelectedItem().toString()+"\n"+
                            "No Of Kitchen: "+sp_kitchen.getSelectedItem().toString()+"\n"+
                            "No Of BathRoom: "+sp_bathroom.getSelectedItem().toString()+"\n",

                    phn.getText().toString(),
                    address.getText().toString(),
                    date.getText().toString()

            );
            call.enqueue(new Callback<PostModel>() {
                @Override
                public void onResponse(Call<PostModel> call, Response<PostModel> response) {

                    Log.e("Reg", response.body().getPostStatus());

                    if (response.body().getPostStatus().equals("successful")){

                        Toast.makeText(getApplicationContext(),"Post Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddPostActivity.this, HomeActivity.class);
                        startActivity(intent);

                    }else {

                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PostModel> call, Throwable t) {
                    Log.e("Teg", t.getMessage().toString());
                }
            });

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


        }

    }
}
