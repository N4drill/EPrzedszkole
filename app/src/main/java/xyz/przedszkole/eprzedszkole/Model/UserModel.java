package xyz.przedszkole.eprzedszkole.Model;


/**
 * Created by Marcin on 05.03.2018.
 */

public class UserModel {

    private int uzytkownikID;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adrUlica;
    private String adrMiejsc;
    private String telefon;
    private String email;
    private String haslo;
    private int poziomDost;


    public int getUzytkownikID() {
        return uzytkownikID;
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

    public String getAdrUlica() {
        return adrUlica;
    }

    public String getAdrMiejsc() {
        return adrMiejsc;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getHaslo() {
        return haslo;
    }

    public int getPoziomDost() {
        return poziomDost;
    }
}
