package xyz.przedszkole.eprzedszkole.Presenter;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.przedszkole.eprzedszkole.Model.Callback.RequestInterface;
import xyz.przedszkole.eprzedszkole.Presenter.Interfaces.ILoginPresenter;
import xyz.przedszkole.eprzedszkole.View.UI.Interfaces.ILoginView;

/**
 * Created by Nadrill on 19.03.2018.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;
    private Retrofit retrofit;

    public LoginPresenter(){

    }

    public LoginPresenter(ILoginView view){
        this.loginView = view;
    }

    @Override
    public void login(String email, String password) {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://przedszkole.xyz/")
                .build();
        RequestInterface loginService = retrofit.create(RequestInterface.class);
        loginService.getLoginToken(email,password).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                String status = jsonObject.get("status").getAsString();
                String message = jsonObject.get("message").getAsString();
                loginView.changeInfo(status + " " + message);
                if(status.equals("ok")){
                    loginView.loginPassed(message);
                }
                else{
                    loginView.changeInfo("DANE NIEPOPRAWNE   " + status + " " + message );
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                loginView.changeInfo(t.getMessage());
                // loginView.loginRejected();
            }
        });
    }
}
