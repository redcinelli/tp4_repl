package dudes;

import java.util.ArrayList;

/**
 * Created by paulo on 24/10/16.
 */
public class Dude {
    String name ;
    String bff;
    ArrayList<String> info;
    ArrayList<String> listodfriends;

    public Dude(String name,String bff, ArrayList<String> listoffriends,ArrayList<String> info ) {
        this.name = name;
        this.bff = bff;
        this.info = info;
        this.listodfriends = listoffriends;
    }

    public String getBff() {
        return bff;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getInfo(){ return info;}

    public ArrayList<String> getListodfriends(){ return listodfriends;}

}
