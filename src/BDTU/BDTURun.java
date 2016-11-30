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

        String name = "testName";

        BDTUArchival test = new BDTUArchival("test", "test", 20);
        BDTUArchival secondTest = new BDTUArchival("secondTest", "teststestst", 5000);


        test.putInArchive(name,test);
        test.putInArchive("blah",secondTest);
        System.out.println(BDTUArchival.archival.toString());


    }
}
