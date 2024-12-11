package dateConversion;

import java.text.*;
import java.util.*;

public class DateConversion {
    public static void main(String[] args) {
        // Define an array of date strings
        String[] dates = {
            "10/29/99", "12/5/01", "1/15/99", "4/23/02", "7/4/00", 
            "8/9/01", "3/30/03", "11/12/99", "5/17/01", "9/8/00"
        };

        // Create an array to store the converted dates
        for (String dateStr : dates) {
            convertAndPrintDate(dateStr);
        }
    }

    // Method to convert and print the date in "day month year" format
    public static void convertAndPrintDate(String dateStr) {
        try {
            // Define the input date format
            SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yy");
            Date date = inputFormat.parse(dateStr);

            // Define the output date format (for full month name and year with century)
            SimpleDateFormat outputFormat = new SimpleDateFormat("d MMMM yyyy");
            String formattedDate = outputFormat.format(date);

            // Adding suffix to the day
            String day = formattedDate.split(" ")[0];
            String suffix = getDaySuffix(Integer.parseInt(day));
            formattedDate = formattedDate.replace(day, day + suffix);

            System.out.println(formattedDate);
        } catch (ParseException e) {
            System.out.println("Error parsing the date: " + dateStr);
        }
    }

    // Method to get the suffix for the day (st, nd, rd, th)
    public static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }

        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }
}


