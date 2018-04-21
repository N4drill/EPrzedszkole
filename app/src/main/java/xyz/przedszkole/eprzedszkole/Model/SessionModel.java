package xyz.przedszkole.eprzedszkole.Model;

import java.util.Date;

/**
 * Created by Marcin on 05.03.2018.
 */

public class SessionModel {

    private int uzytkownikID;
    private int token;
    private String adresIP;
    private Date dataWygas;

    public int getUzytkownikID() {
        return uzytkownikID;
    }

    public int getToken() {
        return token;
    }

    public String getAdresIP() {
        return adresIP;
    }

    public Date getDataWygas() {
        return dataWygas;
    }
}
