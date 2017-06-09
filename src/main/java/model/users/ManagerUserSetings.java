package model.users;

import model.ConsoleHelper;
import model.loging.LogerSituations;
import view.ManagerGUIGame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ManagerUserSetings {
    private Properties fileUserSetings;
    private  String pathToSetingFile;
    private ManagerGUIGame managerGUIGame;
    private static LogerSituations loger = new LogerSituations(ManagerUserSetings.class);

    public ManagerUserSetings(ManagerGUIGame managerGUIGame) {
        this.managerGUIGame = managerGUIGame;
        this.fileUserSetings = new Properties();
        pathToSetingFile = ConsoleHelper.getParentPath(ManagerUserSetings.class) + "/setings.properties";
        pathToSetingFile = ConsoleHelper.getFile("setings.properties");
        System.out.println(pathToSetingFile);
        try {
            fileUserSetings.load(new FileReader(pathToSetingFile));
        } catch (IOException e) {
            loger.logError(e);
        }
    }

    public String getSeting(String nameSeting){
        return fileUserSetings.getProperty(nameSeting);
    }

    public void saveSeting(String nameSeting, String newValue){
        fileUserSetings.setProperty(nameSeting, newValue);
        try {
            fileUserSetings.save(new FileOutputStream(pathToSetingFile),null);
        } catch (FileNotFoundException e) {
            loger.logError(e);
        }
    }
}
//        pathToSetingFile = ConsoleHelper.getFile("setings.properties");
//        System.out.println(pathToSetingFile);
//        try {
//            fileUserSetings.load(ConsoleHelper.getBufferedReaderForIntoResources("setings.properties"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    public void saveSeting(String nameSeting, String newValue){
//        fileUserSetings.setProperty(nameSeting, newValue);
//        try {
//            fileUserSetings.save(ConsoleHelper.getFileOutputStream("setings.properties"),null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }