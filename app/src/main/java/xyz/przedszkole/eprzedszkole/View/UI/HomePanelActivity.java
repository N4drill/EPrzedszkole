package xyz.przedszkole.eprzedszkole.View.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.przedszkole.eprzedszkole.Model.ChildModel;
import xyz.przedszkole.eprzedszkole.Presenter.HomePanelPresenter;
import xyz.przedszkole.eprzedszkole.Presenter.Interfaces.IHomePanelPresenter;
import xyz.przedszkole.eprzedszkole.R;
import xyz.przedszkole.eprzedszkole.Model.Callback.RequestInterface;
import xyz.przedszkole.eprzedszkole.View.UI.Interfaces.IHomePanelView;

public class HomePanelActivity extends AppCompatActivity implements IHomePanelView{

    @BindView(R.id.childGrid) CardView BchildGrid;
    private String actualToken;
    private Intent fromIntent;
    private IHomePanelPresenter iHomePanelPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);
        ButterKnife.bind(this);
        fromIntent = getIntent();
        actualToken = fromIntent.getStringExtra("TOKEN");
        this.iHomePanelPresenter = new HomePanelPresenter(this);
    }

    @OnClick(R.id.childGrid)
    @Override
    public void childClick(){
        Toast.makeText(this,"KLIK", Toast.LENGTH_SHORT).show();
        iHomePanelPresenter.childClick(actualToken);
    }

    @Override
    public void showChilds(String token,String name, String surname, String pesel) {
        Toast.makeText(this, "Dzieci", Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, ChildPanelActivity.class);
        intent.putExtra("TOKEN", token);
        intent.putExtra("NAME", name);
        intent.putExtra("SURNAME", surname);
        intent.putExtra("PESEL", pesel);
        startActivity(intent);
    }

    @Override
    public void showChilds(String token, ArrayList<ChildModel> childModels) {
        Gson gson = new Gson();
        String jsonChild = gson.toJson(childModels);
        Intent intent = new Intent(this, ChildPanelActivity.class);
        intent.putExtra("CHILDLIST", jsonChild);
        startActivity(intent);
    }

    @Override
    public void showChildsRejected(String toastMessage) {
        Toast.makeText(this, toastMessage,Toast.LENGTH_LONG);
    }


}
