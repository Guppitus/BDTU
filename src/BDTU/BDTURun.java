package BDTU;

import java.io.IOException;


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

                BDTUArchival test = new BDTUArchival(BDTUConsoleCommand.consoleSource(), BDTUConsoleCommand.consoleDestination(), 20);
                //BDTUArchival secondTest = new BDTUArchival("secondTest", "teststestst", 5000);


                test.putInArchive(name, test);
               // test.putInArchive("blah", secondTest);
        }
        System.out.println(BDTUArchival.archival.toString());
        BDTUSerialization.serialize(BDTUArchival.archival);

    }
}
