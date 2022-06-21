package com.turinglaureate.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.turinglaureate.R;
import com.turinglaureate.adapters.CustomAdapter;
import com.turinglaureate.retrocall.ApiController;
import com.turinglaureate.retrocall.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaureatesActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laureates);


        recyclerView
                = (RecyclerView) findViewById(
                R.id.recyci);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        String[] mDataList={ "Jeffrey","David","Ullman"};
        CustomAdapter myDataAdapter=new CustomAdapter(this,mDataList);
        recyclerView.setAdapter(myDataAdapter);

        btn = findViewById(R.id.btn);
//        tv=findViewById(R.id.textView);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                processData();
//            }
//        });
    }

    private void processData() {
        Call<List<ResponseModel>> call = ApiController
                .getInstance()
                .getApi()
                .getData();

        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                List<ResponseModel> data = response.body();
                for (ResponseModel rm : data) {
                    tv.append("Id " + rm.getId());
                    tv.append(" Name " + rm.getName() + " ");
                    tv.append(" " + rm.getCountry() + " ");
                    tv.append(" " + rm.getYear() + " ");
                    tv.append(" " + rm.getAffiliation() + " ");
                    tv.append(" " + rm.getDescription() + " ");
//                    Toast.makeText(getApplicationContext(),rm.getName() + rm.getId() + rm.getAffiliation() + rm.getDescription(),Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}