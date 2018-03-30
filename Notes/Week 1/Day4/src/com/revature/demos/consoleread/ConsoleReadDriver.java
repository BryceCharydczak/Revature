package com.revature.demos.consoleread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {
    public static void main(String[] args){




        /*  BUFFERED READER READ IN INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        try {
            userInput = br.readLine();
        } catch (IOException e){
            userInput = "error";
            e.printStackTrace();
        }
        System.out.println(userInput);


        */


        Scanner scan = new Scanner(System.in);
        String val = scan.nextLine();
        System.out.println(val);
    }


}
