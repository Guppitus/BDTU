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
public class BDTUReadWrite {


    public static void writeArchivalBackup(BDTUArchival archive){

        File source = getFile(archive.source);
        File destination = getFile(archive.destination);

        try{
            copyDirectory(source,destination);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }


}
