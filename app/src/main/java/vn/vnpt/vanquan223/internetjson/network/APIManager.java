package vn.vnpt.vanquan223.internetjson.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.vnpt.vanquan223.internetjson.newsmodel.ListNewsModel;

public interface APIManager {
/*
    String SERVER_URL = "http://tommyprivateguide.com";
    @GET("/data.json")
    Call<NewsModel> getNews();
*/

//https://newsapi.org/v2/top-headlines?sources=abc-news&apiKey=91bc3d8973554ce0a7450e63e3bf1f88
 /*   String SERVER_URL_ABC = "https://newsapi.org";
    @GET("/v2/top-headlines")
    Call<ABCNewsModel> getABCNews(@Query("sources") String sources, @Query("apiKey") String apiKey);*/

    //http://tommyprivateguide.com/wp-json/wp/v2/posts?page=1&per_page=50
    String SERVER_URL_LISTNEWS = "http://tommyprivateguide.com";
    @GET("/wp-json/wp/v2/posts")
    Call<List<ListNewsModel>> getListNews(@Query("page") String page, @Query("per_page") String per_page);
}
