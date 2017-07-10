package test.route.com.weekdemo1.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by my301s on 2017/6/16.
 */

public class New {
    private OkHttpClient httpClient;
    private New(){
        httpClient=new OkHttpClient.Builder().build();
    }
    private static New aNew;
    public static New getInstance(){
        if(aNew==null){
            synchronized (New.class){
                if(aNew==null){
                    aNew=new New();
                }
            }
        }
        return aNew;
    }
    public static void get(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
    }
}
