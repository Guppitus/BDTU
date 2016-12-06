package BDTU;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.sizeOfDirectory;


/**
 * Initial Run class for BDTU program
 * Contains Main Function
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTURun {

    /**
     * Backup run method : backs up source directory to backup directory while
     *                     creating archive record, storing record in hash table
     *                     and updating archive.ser
     * @param backupName backup name taken as a String
     * @param source source file path taken as a String
     * @param destination destination filepath taken as a String
     */

    public static void archiveBackup(String backupName, String source, String destination){

        //get source file size
        File sourceFile = new File(source);
        long size = sizeOfDirectory(sourceFile);

        //create archive backup record
        BDTUArchival archiveBackup = new BDTUArchival(source, destination, size);

        //add archive backup record to archive hash table
        archiveBackup.putInArchive(backupName, archiveBackup);

        //perform copy and write operation on backup
        BDTUWrite.writeArchivalBackup(archiveBackup);

        //update .ser file with updated archive hash table
        BDTUSerialization.serialize(BDTUArchival.archivalTable);
    }

    /**
     * Restore Run method: restores backup file to source file
     * @param backupName name of backup taken as a String
     */
    public static void restore(String backupName){

        //get backup record from archive hash table
        BDTUArchival getBackup = (BDTUArchival)BDTUArchival.archivalTable.get(backupName);

        //perform copy and write restoration operation on backup
        BDTUWrite.writeArchivalRestore(getBackup);

        //remove archive backup record from archive hash table
        BDTUArchival.removeFromArchive(backupName);

        //update .ser file with updated archive hash table
        BDTUSerialization.serialize(BDTUArchival.archivalTable);


    }

  /* public static void main(String[] args) throws IOException {

        BDTUSerialization.deserialize();
        while(true) {

                String name = BDTUConsoleCommand.consoleName();
                if ( name.equals("quit"))
                    break;
                String source = "./test";
                String destination = "./test2";
                //String destination = BDTUConsoleCommand.consoleDestination();
                File sourceFile = new File(source);
                long size = sizeOfDirectory(sourceFile);
                BDTUArchival test = new BDTUArchival(source, destination, size );


                test.putInArchive(name, test);
                BDTUWrite.writeArchivalBackup(test);
        }
        System.out.println(BDTUArchival.archivalTable.toString());
        BDTUSerialization.serialize(BDTUArchival.archivalTable);

    }
    */
}
