package xyz.przedszkole.eprzedszkole.View.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.przedszkole.eprzedszkole.Model.ChildModel;
import xyz.przedszkole.eprzedszkole.Presenter.HomePanelPresenter;
import xyz.przedszkole.eprzedszkole.R;
import xyz.przedszkole.eprzedszkole.View.Adapter.ChildAdapter;

/**
 * Created by Nadrill on 12.03.2018.
 */

public class ChildPanelActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ChildAdapter childAdapter;
    private HomePanelPresenter homePanelPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_recyclerview);
        String list = getIntent().getStringExtra("CHILDLIST");
        Gson gson = new Gson();
        Type type = new TypeToken<List<ChildModel>>(){}.getType();
        List<ChildModel> childModelList = gson.fromJson(list,type);


        Log.d("TEST",""+childModelList.size());
        for(ChildModel childModel: childModelList){
            Log.d("TEST", childModel.toString());
        }

        recyclerView = (RecyclerView) findViewById(R.id.child_recyclerview);
        childAdapter = new ChildAdapter(childModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(childAdapter);
    }
}
