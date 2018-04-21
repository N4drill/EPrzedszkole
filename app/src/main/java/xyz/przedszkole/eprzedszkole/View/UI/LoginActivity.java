package xyz.przedszkole.eprzedszkole.View.UI;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.przedszkole.eprzedszkole.Presenter.Interfaces.ILoginPresenter;
import xyz.przedszkole.eprzedszkole.Presenter.LoginPresenter;
import xyz.przedszkole.eprzedszkole.R;
import xyz.przedszkole.eprzedszkole.View.UI.Interfaces.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private ILoginPresenter iLoginPresenter;
    //region Butterknife Bind Declaration
    @BindView(R.id.infoTextView) TextView BinfoTextView;
    @BindView(R.id.emailEditText) EditText BemailEditText;
    @BindView(R.id.passwordEditText) EditText BpasswordEditText;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iLoginPresenter = new LoginPresenter(this);
    }


    @OnClick(R.id.loginButton)
    @Override
    public void login() {
        String email = BemailEditText.getText().toString();
        String password = BpasswordEditText.getText().toString();
        iLoginPresenter.login(email, password);
    }

    @Override
    public void changeInfo(String info) {
        BinfoTextView.setText(info);
    }

    @Override
    public void loginPassed(String token) {
        Intent intent = new Intent(this, HomePanelActivity.class);
        intent.putExtra("TOKEN", token);
        startActivity(intent);
    }

    @Override
    public void loginRejected() { //TODO

    }

}
