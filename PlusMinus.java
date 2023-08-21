// Problem: https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true

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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int pos = 0, neg = 0, z = 0;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);

            if (num == 0) {
                z++;
            } else if (num < 0) {
                neg++;
            } else {
                pos++;
            }
        }

        double posRatio = pos / (arr.size() * 1.0);
        double negRatio = neg / (arr.size() * 1.0);
        double zeroRatio = z / (arr.size() * 1.0);

        System.out.println(String.format("%.6f", posRatio));
        System.out.println(String.format("%.6f", negRatio));
        System.out.println(String.format("%.6f", zeroRatio));

        // alternate approach: after for loop:
        // double posRatio = pos / (arr.size() * 1.0);
        // posRatio = Math.round(posRatio * 1000000) / 1000000.0;
        // double negRatio = neg / (arr.size() * 1.0);
        // negRatio = Math.round(negRatio * 1000000) / 1000000.0;
        // double zeroRatio = z / (arr.size() * 1.0);
        // zeroRatio = Math.round(zeroRatio * 1000000) / 1000000.0;
        // System.out.println(posRatio);
        // System.out.println(negRatio);
        // System.out.println(zeroRatio);
    }

}

// Use class name Solution when using in HackerRank.
public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
