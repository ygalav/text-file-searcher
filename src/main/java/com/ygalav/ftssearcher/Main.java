package com.ygalav.ftssearcher;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please type your search phrase or 'exit' to stop");
        while (true) {
            System.out.print("search >>: ");
            String searchPhrase = scanner.nextLine();
            if ("exit".equalsIgnoreCase(searchPhrase)) {
                System.out.println("Thanks for the session,. exiting.");
                break;
            }
        }


    }
}
