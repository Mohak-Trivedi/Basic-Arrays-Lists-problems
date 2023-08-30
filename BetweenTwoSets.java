// Problem: https://www.hackerrank.com/challenges/between-two-sets/problem

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
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER_ARRAY b
     */

    // T.C.: O(n) + O(r * n) w/o sorting, where r is number of numbers in the
    // possible Between numbers range.
    // T.C.: O(nlogn) + O(r * n) w/ sorting
    // S.C.: O(1)
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        // w/o sort: Get the range of possible Between Numbers: [Largest in a[],
        // Smallest in b[]]
        // int high = Integer.MAX_VALUE;
        // int low = Integer.MIN_VALUE;
        // for (int i = 0; i < a.size(); i++) {
        // low = Math.max(low, a.get(i));
        // }
        // for (int i = 0; i < b.size(); i++) {
        // high = Math.min(high, b.get(i));
        // }

        // w/ sort: Get the range of possible Between Numbers: [Largest in a[], Smallest
        // in b[]]
        Collections.sort(a);
        Collections.sort(b);
        int low = a.get(a.size() - 1);
        int high = b.get(0);

        // Find total number of Between Numbers out of the entire range.
        int totalNumBetween = 0;
        for (int num = low; num <= high; num++) {
            // check if all a[] ele are factors of num
            boolean allAFactorNum = true;
            for (int i = 0; i < a.size(); i++) {
                if (num % a.get(i) != 0) {
                    allAFactorNum = false;
                    break;
                }
            }

            // check if num is factor of all b[] ele
            boolean numFactAllB = true;
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i) % num != 0) {
                    numFactAllB = false;
                    break;
                }
            }

            // if yes for both, then num is a Between Number
            if (allAFactorNum == true && numFactAllB == true) {
                totalNumBetween++;
            }
        }

        return totalNumBetween;
    }

    // Approach: Using sorting
    // public static int getTotalX(List<Integer> a, List<Integer> b) {
    // // Get the range of possible Between Numbers: [Largest in a[], Smallest in
    // b[]]
    // Collections.sort(a);
    // Collections.sort(b);
    // int low = a.get(a.size() - 1);
    // int high = b.get(0);

    // }
}

// Use class name Solution in HackerRank
public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
