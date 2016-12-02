package BDTU;

import java.util.HashMap;


/**
 * Long Term Storage of Backup Files
 * Backup Objects stored in HashMap
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUArchival extends BDTUBackUp {

    /** the name of the backup */
    private String backupName;

    /** HashMap containing all archival backup objects */
    static HashMap archival = new HashMap();

    /** Archival Backup constructor which holds source and destination file paths as strings
     *  and the size of the directory or file being backed up.
     *  @param source filepath of source taken as a String
     *  @param destination filepath of destination taken as a String
     *  @param size size of directory or file taken as a long
     *  */
    public BDTUArchival (String source, String destination, long size){

        super(source, destination, size);
        setName(backupName);
        repOK();
    }


    /** Set name of backup
     * @param newBackupName string of backup name
     * */
    public void setName(String newBackupName){
        backupName = newBackupName;
    }

    /**
     * Get name of backup
     * @return String: name of backup
     * */
    public String getName(){
        return backupName;
    }

    /**
     * Adds Archival backup object to HashMap
     * @param backupName Key: name of backup string
     * @param newArchivalBackup Value: Archival Backup Object
     */
    public void putInArchive(String backupName, BDTUArchival newArchivalBackup){
        archival.put(backupName, newArchivalBackup);
    }

    /**
     * Removes Backup object from HashMap
     * @param backupName Key : name of backup as String
     */
    public void removeFromArchive(String backupName){
        archival.remove(backupName);
    }

    /**
     * check representation
     */
    private void repOK(){

        assert (size < Long.MAX_VALUE);
        assert (size >= 0);

    }
}
