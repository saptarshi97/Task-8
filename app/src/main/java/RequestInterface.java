package saptarshi.com.task8;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface
{
    @GET("android/jsonandroid")
    Call<saptarshi.com.task8.JSONResponse> getJSON();
}
