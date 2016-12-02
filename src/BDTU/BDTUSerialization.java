package BDTU;

import java.io.*;
import java.util.HashMap;


/**
 * Handles the storage of archivalTable and Session Data Structures
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUSerialization {


    /**
     * Serialize Archival Hash Map to .ser file
     * @param archival HashMap containing archivalTable backup objects.
     */
    public static void serialize(HashMap archival){

        try {
            FileOutputStream fileOut = new FileOutputStream("archive.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(archival);
            out.close();
            System.out.println("Serialized data is saved in archive.ser");

        } catch (IOException i){
            i.printStackTrace();
        }
    }

    /**
     * Deserialize Archival HashMap saved in .ser file
     */
    public static void deserialize(){

        try
        {
            FileInputStream fileIn = new FileInputStream("archive.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BDTUArchival.archivalTable = (HashMap) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Serialized data loaded from archive.ser");
        } catch (FileNotFoundException i)
        {
            System.out.println("No saved data found");
        } catch (ClassNotFoundException c)
        {
            c.printStackTrace();
        } catch (IOException t)
        {
            t.printStackTrace();
        }
    }



}
