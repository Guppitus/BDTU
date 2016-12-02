package BDTU;

import java.io.File;
import java.io.IOException;


import static org.apache.commons.io.FileUtils.*;



/**
 * Handles the reading and writing of file backups
 * Implements CommonIO
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUWrite {


    /**
     * File IO creates and writes a copy of source directory to the destination directory
     * Creates destination directory if it does not exist
     * @param archive Backup object
     */
    public static void writeArchivalBackup(BDTUArchival archive){

        File source = getFile(archive.source);
        File destination = getFile(archive.destination);

        try{
            copyDirectory(source,destination);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * File IO writes backup directory over source directory
     * deletes backup directory
     * @param archive Backup Object
     */
    public static void writeArchivalRestore(BDTUArchival archive){

        File source = getFile(archive.source);
        File destination = getFile(archive.destination);

        try{
            copyDirectory(destination, source);
            forceDelete(destination);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
