package BDTU;

import java.util.Scanner;

/**
 * ConsoleCommand handles non GUI interaction with BDTU
 * via command line.
 *
 * Created by Seth K. Lunn on 11/30/2016.
 */
public class BDTUConsoleCommand {

    public static String consoleName(){

        System.out.println("enter name");

        Scanner s = new Scanner(System.in);

        String input = (s.nextLine());


        return input;
    }

    public static String consoleSource() {

        Scanner s = new Scanner(System.in);

        System.out.println("enter source");

        String input = (s.nextLine());

        return input;
    }

    public static String consoleDestination(){

        Scanner s = new Scanner(System.in);

        System.out.println("enter destination");

        String input = (s.nextLine());

        return input;
    }


}
