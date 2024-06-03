package com.student.application.student_application.service;

import java.util.Scanner;

public class DaysInMonth {

    public static void main(String args[]) {

        int month;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter any month number between 1 & 12");
        month = s.nextInt();

        switch (month) {
            case 2:
                System.out.println("Month 2 contains 28 or 29 days");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Month " + month + " contains 31 days");
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Month " + month + " contains 30 days");
                break;
            default:
                System.out.println("Please enter valid month number between 1 & 12");

        }

    }
}
