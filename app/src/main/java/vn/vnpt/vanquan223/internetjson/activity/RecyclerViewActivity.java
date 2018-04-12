package vn.vnpt.vanquan223.internetjson.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.vnpt.vanquan223.internetjson.R;
import vn.vnpt.vanquan223.internetjson.adapter.ListNewsAdapter;
import vn.vnpt.vanquan223.internetjson.adapter.RecyclerViewAdapter;
import vn.vnpt.vanquan223.internetjson.network.APIManager;
import vn.vnpt.vanquan223.internetjson.newsmodel.ListNewsModel;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvRecyclerList;
    List<ListNewsModel> listNewsModels = new ArrayList<>();
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rvRecyclerList = findViewById(R.id.rvRecyclerList);
        parserRecyclerView();
    }


    /*
     * Sử dụng ListView hiển thị nhiều dữ liệu lấy từ API
     * */
    private void parserRecyclerView() {
        String page = "1";
        String per_page = "50";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL_LISTNEWS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager manager = retrofit.create(APIManager.class);
        manager.getListNews(page, per_page).enqueue(new Callback<List<ListNewsModel>>() {
            @Override
            public void onResponse(Call<List<ListNewsModel>> call, Response<List<ListNewsModel>> response) {
                List<ListNewsModel> list = response.body();
                listNewsModels = list;
                adapter = new RecyclerViewAdapter(RecyclerViewActivity.this, listNewsModels);


                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.HORIZONTAL, false);
//                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RecyclerViewActivity.this, 2);
                rvRecyclerList.setLayoutManager(layoutManager);
                rvRecyclerList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ListNewsModel>> call, Throwable t) {
            }
        });

    }
}
