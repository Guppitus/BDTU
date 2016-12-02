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



    public static void main(String[] args) throws IOException {

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
}
