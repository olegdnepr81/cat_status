package org.example;


public class Main {
    public static void main(String[] args) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        int[] codes = new int[]{100, 10_100, 101, 102, 103, 200, 201, 202, 203, 204, 206, 207, 300, 400, 10_000};
        for (int code : codes) {
            String urlBack = httpStatusChecker.getStatusImage(code);
            System.out.println(urlBack);
        }
        System.out.println("-----------------------------");
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        for(int code : codes){
            httpStatusImageDownloader.downloadStatusImage(code);
        }
        System.out.println("-----------------------------");
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
