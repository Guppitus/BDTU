package BDTU;

import java.io.*;
import java.util.HashMap;


/**
 * Handles the storage of archival and Session Data Structures
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUSerialization {


    public static void serialize(HashMap archival){

        try {
            FileOutputStream fileOut = new FileOutputStream("archive.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(archival);
            out.close();
            System.out.printf("Serialized data is saved in");

        } catch (IOException i){
            i.printStackTrace();
        }
    }

    public static void deserialize(){

        try
        {
            FileInputStream fileIn = new FileInputStream("archive.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BDTUArchival.archival = (HashMap) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i)
        {
            i.printStackTrace();
        } catch (ClassNotFoundException c)
        {
            c.printStackTrace();
        }
    }



}
