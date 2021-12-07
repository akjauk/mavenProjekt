package de.hfu;

import java.util.Scanner;

/**
 * @author akjau
 *	Class that includes the main for TextScanner
 */
public class App 
{
    /**
     * @param args
     * main method for scanning user input and returning it in upper case
     */
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);  
	    System.out.println("Enter a message: ");

	    String message = sc.nextLine().toUpperCase();  
	    System.out.println("Your message: \n" + message);
    }
}
