// Problem: https://www.hackerrank.com/challenges/simple-array-sum

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleArraySum {
    public static void main(String args[]) {

        Scanner scn = new Scanner(System.in);
        int n;
        int[] arr;
        int sum = 0;
        n = scn.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
