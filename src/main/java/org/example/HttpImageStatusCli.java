package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus(){
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter HTTP status code: ");
            int code = in.nextInt();
            HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
            httpStatusChecker.getStatusImage(code);
            HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
            httpStatusImageDownloader.downloadStatusImage(code);
            in.close();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Please enter valid number");
        }
    }
}
