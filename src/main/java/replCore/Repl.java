package replCore;

import java.util.ArrayList;
import java.util.Scanner;
import dudes.Dude;
import hbaseConnector.HBaseTest;

/**
 * Created by paulo on 21/10/16.
 */
public class Repl {
    static String  tableName = "aDudeNetwork";
    static String[] collumn = { "friends", "info" };
    public static void main(String[] args) throws Exception {
        System.out.println("Sup nigga wanna be a dancer ? but you can't cuse you need friends first !");
        HBaseTest.creatTable(tableName, collumn);
        while (true){
            System.out.println("add one ? type add, quit ? type exit ! check errors? type check");
            Scanner mainMenu =  new Scanner(System.in);
            String choice = mainMenu.nextLine();
            System.out.println(choice);
            if(choice.equals("add")){
                addDude();
            }else if(choice.equals("exit")){
                return;
            }else if (choice.equals("check")){
                check();
            }else if (choice.equals("show")){
                show();
            }else{
                System.out.println("k'mon man, 3 choices only ! make up you mind");
            }
        }
    }
    private static void addDude() throws Exception {
        System.out.println("add one ! give me a name dude");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String name = reader.nextLine();
        System.out.println("That's more like it, who's the nigga of that nigga ?");
        String bff = reader.nextLine();
        boolean exit = false;
        ArrayList<String> listoffriends=  new ArrayList<String>();
        ArrayList<String> info=  new ArrayList<String>();
        System.out.println("Any more friends ? write exit to stop");
        while(exit == false){
            String input = reader.nextLine();
            if(input.equals("exit")){
                exit = true;
            }else {
                listoffriends.add(input);
            }
        }
        exit = false;
        System.out.println("Gimme some basic info tho");
        System.out.println("how old ?");
        info.add(reader.nextLine());
        System.out.println("from 0 to me how fun ?");
        info.add(reader.nextLine());

        System.out.println(name +":"+ bff);
        Dude newdude = new Dude(name, bff, listoffriends, info);
        System.out.println("we are going to add the dude !");

        HBaseTest.addRecord(tableName, newdude.getName(), "friends", "bff", newdude.getBff());
        HBaseTest.addRecord(tableName, newdude.getName(), "friends", "friend", newdude.getListodfriends().toString());
        HBaseTest.addRecord(tableName, newdude.getName(), "info", "", newdude.getInfo().toString());
    }
    private static void check(){
        System.out.println("not implemented yet !");
    };
    private static void show(){
        HBaseTest.getAllRecord(tableName);
    };
}
