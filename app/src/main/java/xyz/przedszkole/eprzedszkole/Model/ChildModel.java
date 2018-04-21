package xyz.przedszkole.eprzedszkole.Model;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Marcin on 05.03.2018.
 */

public class ChildModel {
    @SerializedName("IdD")
    @Expose
    private int dzieckoID;
    @SerializedName("Imie")
    @Expose
    private String imie;
    @SerializedName("Nazwisko")
    @Expose
    private String nazwisko;
    @SerializedName("Pesel")
    @Expose
    private String pesel;
    @SerializedName("DataUr")
    @Expose
    private String dataUr;
    @SerializedName("AdrUlica")
    @Expose
    private String adrUlica;
    @SerializedName("AdrMiejsc")
    @Expose
    private String adrMiejsc;
    @SerializedName("IdOp1")
    @Expose
    private int opiekun1ID;
    @SerializedName("IdOp2")
    @Expose
    private int opiekun2ID;
    @SerializedName("IdGr")
    @Expose
    private int grupaID;
    @SerializedName("Zdjecie")
    @Expose
    private int zdjecie;


    public int getDzieckoID() {
        return dzieckoID;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getDataUr() {
        return dataUr;
    }

    public String getAdrUlica() {
        return adrUlica;
    }

    public String getAdrMiejsc() {
        return adrMiejsc;
    }

    public int getIDOp1() {
        return opiekun1ID;
    }

    public int getIDOp2() {
        return opiekun2ID;
    }

    public int getIdGr() {
        return grupaID;
    }

    public int getZdjecie(){return zdjecie;}


}
