package vn.vnpt.vanquan223.internetjson.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.vnpt.vanquan223.internetjson.R;
import vn.vnpt.vanquan223.internetjson.adapter.ListNewsAdapter;
import vn.vnpt.vanquan223.internetjson.network.APIManager;
import vn.vnpt.vanquan223.internetjson.newsmodel.ListNewsModel;

public class ListNewsActivity extends AppCompatActivity {

    ListView lvListNews;
    List<ListNewsModel> listNewsModels = new ArrayList<>();
    ListNewsAdapter listNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        lvListNews = findViewById(R.id.lvListNews);
        parserListNews();
    }

    /*
    * Sử dụng ListView hiển thị nhiều dữ liệu lấy từ API
    * */
    private void parserListNews() {
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
                listNewsAdapter = new ListNewsAdapter(listNewsModels, ListNewsActivity.this);
                lvListNews.setAdapter(listNewsAdapter);

                lvListNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ListNewsModel model = listNewsModels.get(position);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<ListNewsModel>> call, Throwable t) {
                String a = "";
            }
        });

    }
}
