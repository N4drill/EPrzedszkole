package xyz.przedszkole.eprzedszkole.View.UI.Interfaces;

/**
 * Created by Nadrill on 19.03.2018.
 */

public interface ILoginView {
    void login();
    void changeInfo(String info);
    void loginPassed(String token);
    void loginRejected();
}
