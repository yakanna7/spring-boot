package com.student.application.student_application.controller;

import java.util.Scanner;

/*




result = "2th1i5sisas2im4plet7extmess5age"

public String compute(String s1, String s2) { }



 */



public class Test {
    public static void main(String args[]) {
        String s1 ="2152475";

        String s2 = "Thisisasimpletextmessage";

        }


    public String compute(String s1, String s2) {

        StringBuilder result = new StringBuilder();

        int accChars = 0;
        String strArr[] = s1.split("");
        for(int i = 0 ; i< strArr.length;  i++){
            int length = Integer.parseInt(strArr[i]);

            result.append(strArr[i]);
            result.append(s2.substring(accChars, accChars+length));


            accChars = accChars + length;
        }

        return result.toString();

    }

}
