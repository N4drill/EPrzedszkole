package xyz.przedszkole.eprzedszkole.Model.Callback;

import android.graphics.Bitmap;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import xyz.przedszkole.eprzedszkole.Model.ChildListModel;
import xyz.przedszkole.eprzedszkole.Model.ChildModel;

/**
 * Created by Marcin on 05.03.2018.
 */

public interface RequestInterface {

    @FormUrlEncoded
    @POST("api/logowanie/email/{email}")
    Call<JsonObject> getLoginToken(@Path("email") String email, @Field("haslo") String haslo);

    @GET("api/bachory/token/{token}/czyje/{czyje}/limit/{limit}/przesuniecie/{przesuniecie}")
    Call<ChildListModel> getChildModels(@Path ("token") String token, @Path("czyje") String czyje, @Path("limit") int limit, @Path ("przesuniecie") int przesuniecie);

    @GET("api/obraz/token/{token}/image/{imageID}")
    Call<Bitmap> getImage(@Path ("token") String token, @Path("imageID") int imageID);

    @GET("api/heartbeat/token/{token}")
    Call<JsonObject> refreshToken(@Path("token") String token);

}
