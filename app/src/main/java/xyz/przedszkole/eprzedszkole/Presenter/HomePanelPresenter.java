package xyz.przedszkole.eprzedszkole.Presenter;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.przedszkole.eprzedszkole.Model.Callback.RequestInterface;
import xyz.przedszkole.eprzedszkole.Model.Callback.RetrofitClient;
import xyz.przedszkole.eprzedszkole.Model.ChildListModel;
import xyz.przedszkole.eprzedszkole.Model.ChildModel;
import xyz.przedszkole.eprzedszkole.Presenter.Interfaces.IHomePanelPresenter;
import xyz.przedszkole.eprzedszkole.View.Adapter.ChildAdapter;
import xyz.przedszkole.eprzedszkole.View.UI.Interfaces.IHomePanelView;

/**
 * Created by Marcin on 20.03.2018.
 */

public class HomePanelPresenter implements IHomePanelPresenter {

    private IHomePanelView iHomePanelView;
    private Retrofit retrofit;
    private String TOKEN;
    private ArrayList<ChildModel> childList;
    private ChildAdapter childAdapter;
    private RecyclerView recyclerView;


    public HomePanelPresenter(IHomePanelView iHomePanelView){
        this.iHomePanelView = iHomePanelView;
    }


//    @Override
//    public void childClick(String token) {
//        TOKEN = token;
//        retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://przedszkole.xyz/")
//                .build();
//        RequestInterface service = retrofit.create(RequestInterface.class);
//        service.getChildModels(token, "wszystkie",  5, 0).enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//
//                JsonObject jsonObject = response.body();
//                String status = jsonObject.get("status").getAsString();
//                Log.d("LOGCHECK", "childClick: IM HERE "+status);
//                //TODO tutaj program sie wysypuje i dostaje status ERROR  ----!!!!
//
//                if(status.equals("ok")) {
//                    JsonArray kids = jsonObject.get("message").getAsJsonArray();
//                    for(Object o: kids){
//                        Log.d("LOGX", o.toString());
//                    }
//                    JsonObject kid = kids.get(0).getAsJsonObject();
//
//                /*TODO : tutaj do zrobienia opakowanie tych danych w formie ChildModel
//                  ChildModel child = new ChildModel(params....)
//                 */
//                    //Na razie daje sztywno, zeby sie zmienialo
//                    String name = kid.get("Imie").getAsString();
//                    String surname = kid.get("Nazwisko").getAsString();
//                    String pesel = kid.get("Pesel").getAsString();
//                    Log.d("LOGCHECK", "childClick: IM HERE 6");
//                    iHomePanelView.showChilds(TOKEN, name, surname,pesel);
//                    //TODO iHomePanelView.showChilds(TOKEN,child);
//                }
//            }
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                iHomePanelView.showChildsRejected(t.getMessage()); //TODO zmienic to
//            }
//        });
//
//    }


    @Override
    public void childClick(String token) {
        TOKEN = token;
        RequestInterface api = RetrofitClient.getApiService();
        Call<ChildListModel> call = api.getChildModels(token, "wszystkie", 5, 0);
        call.enqueue(new Callback<ChildListModel>() {
            @Override
            public void onResponse(Call<ChildListModel> call, Response<ChildListModel> response) {
                childList = response.body().getChildModels();
                Log.d("TEST", response.message().toString()+"hehehe");
                iHomePanelView.showChilds(TOKEN, childList);
            }

            @Override
            public void onFailure(Call<ChildListModel> call, Throwable t) {
                Log.d("TEST", t.getMessage());
            }
        });
    }
}
