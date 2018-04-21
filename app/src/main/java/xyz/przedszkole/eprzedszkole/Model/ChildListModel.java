package xyz.przedszkole.eprzedszkole.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nadrill on 09.04.2018.
 */

public class ChildListModel {
    @SerializedName("message")
    @Expose
    private ArrayList<ChildModel> childModels = null;

    public ArrayList<ChildModel> getChildModels() {
        return childModels;
    }

    public void setChildModels(ArrayList<ChildModel> childModels) {
        this.childModels = childModels;
    }
}
