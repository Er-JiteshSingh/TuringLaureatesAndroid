package com.turinglaureate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.turinglaureate.retrocall.ApiController;
import com.turinglaureate.retrocall.ApiSet;
import com.turinglaureate.retrocall.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        tv=findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processData();
            }
        });
    }

    private void processData() {
        Call<List<ResponseModel>> call = ApiController
                .getInstance()
                .getApi()
                .getData();

        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                List<ResponseModel> data= response.body();
                for (ResponseModel rm:data) {
                    tv.append("Id " + rm.getId());
                    tv.append(" Name "+ rm.getName()+" ");
                    tv.append(" "+ rm.getCountry()+" ");
                    tv.append(" "+ rm.getYear()+" ");
                    tv.append(" "+ rm.getAffiliation()+" ");
                    tv.append(" "+ rm.getDescription()+" ");
//                    Toast.makeText(getApplicationContext(),rm.getName() + rm.getId() + rm.getAffiliation() + rm.getDescription(),Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}