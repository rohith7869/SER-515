package org.example;


import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {
    public static void main(String[] args) {
        String dateTime="1901-01-02T06:01:02.000Z";


        try {
            String formattedDate =
                    new SimpleDateFormat("yyyy-MM-dd")
                            .format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(dateTime));

            //formattedDate="1901-01-02"

            String formattedDate1 =
                    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                            .format(new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate));

            //
            System.out.println(formattedDate1);
        } catch (ParseException e) {

        }
    }
}
