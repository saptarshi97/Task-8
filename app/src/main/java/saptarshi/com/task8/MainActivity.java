package saptarshi.com.task8;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<saptarshi.com.task8.version> data;
    private saptarshi.com.task8.DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        saptarshi.com.task8.RequestInterface request = retrofit.create(saptarshi.com.task8.RequestInterface.class);
        Call<saptarshi.com.task8.JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<saptarshi.com.task8.JSONResponse>() {
            @Override
            public void onResponse(Call<saptarshi.com.task8.JSONResponse> call, Response<saptarshi.com.task8.JSONResponse> response) {

                saptarshi.com.task8.JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new saptarshi.com.task8.DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<saptarshi.com.task8.JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context,"Not Connected !", duration);
                toast.show();
            }
        });
    }
}