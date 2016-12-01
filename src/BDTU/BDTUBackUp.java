package BDTU;

import java.io.Serializable;
import java.util.Date;

/**
 * Super Class containing Parent Backup Structure
 *
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public abstract class BDTUBackUp implements Serializable {

    public String source;
    public String destination;
    public long size;

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


    public BDTUBackUp(String source, String destination, long size) {

        System.out.println("creating backup record");
        this.source = source;
        this.destination = destination;
        this.size = size;

    }

    public String toString() {
        return source + " " + destination + " " + size;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long newSize) {
        size = newSize;
    }

    public void setSource(String newSource) {
        source = newSource;
    }

    public void setDestination(String newDestination) {
        destination = newDestination;
    }
}
