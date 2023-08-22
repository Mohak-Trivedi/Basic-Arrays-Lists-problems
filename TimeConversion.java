// Problem: https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    // without String methods except charAt() and without Integer.parseInt()
    public static String timeConversion(String s) {
        int hh = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        String hrStr = "";
        hrStr = (hh < 10) ? ("0" + hh) : ("" + hh);
        int mm = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        String minStr = "";
        minStr = (mm < 10) ? ("0" + mm) : ("" + mm);
        int ss = (s.charAt(6) - '0') * 10 + (s.charAt(7) - '0');
        String secStr = "";
        secStr = (ss < 10) ? ("0" + ss) : ("" + ss);

        if (s.charAt(8) == 'A') {
            if (hh == 12) {
                return "00" + ":" + minStr + ":" + secStr;
            } else {
                return hrStr + ":" + minStr + ":" + secStr;
            }
        } else {
            if (hh == 12) {
                return hrStr + ":" + minStr + ":" + secStr;
            } else {
                hh += 12;
                return "" + hh + ":" + minStr + ":" + secStr;
            }
        }
    }

    // Alternate Approach: With String methods:
    // public static String timeConversion(String s) {
    // // Write your code here
    // // if AM -> 1 - 11 -> as it is, 12 -> 00
    // // if PM -> 12 -> as it is, 1 - 11 -> 13 - 23
    // String ampm = s.substring(s.length() - 2, s.length());
    // System.out.println(ampm);
    // if (ampm.equals("AM")) { // NOTE: Don't use ampm=="AM" as it will check for
    // reference of String objects instead of string values
    // String hh = s.substring(0, 2);
    // int hours = Integer.parseInt(hh);
    // if (hours == 12) {
    // hh = "00";
    // return hh + s.substring(2, s.length() - 2);
    // } else {
    // return s.substring(0, s.length() - 2);
    // }
    // } else {
    // String hh = s.substring(0, 2);
    // int hours = Integer.parseInt(hh);
    // if (hours == 12) {
    // return s.substring(0, s.length() - 2);
    // } else {
    // hours += 12;
    // return "" + hours + s.substring(2, s.length() - 2);
    // }
    // }
    // }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
