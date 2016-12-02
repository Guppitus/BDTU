package BDTU;

import java.io.Serializable;
import java.util.Date;

/**
 *  Parent Backup Structure
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public abstract class BDTUBackUp implements Serializable {

    /** source filepath */
    public String source;
    /** destination filepath */
    public String destination;
    /** size of directory or file */
    public long size;

//---------------------------------------------------
    /** TODO Move to Session class */

//  TODO 7zip and network
    private boolean encrytpion;
    private boolean network;

//  TODO session backup
    private String netDesitination;
    private Date creationDate;
    private Date modificationDate;
    private Date sesssionLength;
    private boolean recurring;
    private int recurringValue;

//----------------------------------------------------


    /**
     * constructor of backup object
     * @param source file path of source as String
     * @param destination file path of destination as String
     * @param size size of directory or file
     */
    public BDTUBackUp(String source, String destination, long size) {

        System.out.println("creating backup record");
        this.source = source;
        this.destination = destination;
        this.size = size;

    }

    /**
     * creates a string of backup object information : Source, Destination, Size
     * @return String String long as string
     */
    public String toString() {
        return source + " " + destination + " " + size;
    }

    /**
     * gets source file path
     * @return String of source filepath
     */
    public String getSource() {
        return source;
    }

    /**
     * get destination file path
     * @return string of destination filepath
     */
    public String getDestination() {
        return destination;
    }

    /**
     * get size
     * @return size of directory as long
     */
    public long getSize() {
        return size;
    }

    /**
     * sets size
     * @param newSize directory size as long
     */
    public void setSize(long newSize) {
        size = newSize;
    }

    /**
     * set source string
     * @param newSource filepath of source directory as String
     */
    public void setSource(String newSource) {
        source = newSource;
    }

    /**
     * set destination string
     * @param newDestination filepath of destination directory as String
     */
    public void setDestination(String newDestination) {
        destination = newDestination;
    }
}
