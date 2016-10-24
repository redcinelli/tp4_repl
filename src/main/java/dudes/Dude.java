package dudes;

import java.util.ArrayList;

/**
 * Created by paulo on 24/10/16.
 */
public class Dude {
    String name ;
    String bff;
    ArrayList<String> info;

    public Dude(String name,String bff ) {
        this.name = name;
        this.bff = bff;
    }

    public String getBff() {
        return bff;
    }

    public String getName() {
        return name;
    }

}
