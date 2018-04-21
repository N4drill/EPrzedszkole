package xyz.przedszkole.eprzedszkole.View.UI.Interfaces;

import java.util.ArrayList;

import xyz.przedszkole.eprzedszkole.Model.ChildModel;

/**
 * Created by Marcin on 20.03.2018.
 */

public interface IHomePanelView {
     void childClick();
     void showChilds(String token,String name, String surname, String pesel);
     void showChilds(String token, ArrayList<ChildModel> childModels);
     void showChildsRejected(String toastMessage);

    //TODO public void showChilds(String token, ChildModel child);


}
