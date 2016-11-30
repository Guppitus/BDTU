package BDTU;

import java.util.HashMap;


/**
 * Long Term Storage of Backup Files
 * Backup Objects stored in HashMap
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUArchival extends BDTUBackUp {

    private String backupName;

    static HashMap archival = new HashMap();

    public BDTUArchival (String source, String destination, long size){

        super(source, destination, size);
        setName(backupName);
    }

    public void setName(String newBackupName){
        backupName = newBackupName;
    }

    public String getName(){
        return backupName;
    }


    public void putInArchive(String backupName, BDTUArchival newArchivalBackup){
        archival.put(backupName, newArchivalBackup);
    }

    public void removeArchive(String backupName){
//        // TODO: iterate by name and remove from hashmap
    }

}
