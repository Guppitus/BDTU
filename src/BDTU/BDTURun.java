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

        boolean loopy = true;
        while(loopy) {

                String name = BDTUConsoleCommand.readConsole();
                if (name == "quit") {
                    loopy = false;
                }

                BDTUArchival test = new BDTUArchival("test", "test", 20);
                //BDTUArchival secondTest = new BDTUArchival("secondTest", "teststestst", 5000);


                test.putInArchive(name, test);
               // test.putInArchive("blah", secondTest);
            System.out.println(BDTUArchival.archival.toString());

        }

    }
}
