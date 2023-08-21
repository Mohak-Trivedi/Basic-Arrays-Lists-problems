// Problem: https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true

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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code
        // Optimized approach : O(n)
        long totalSum = 0;
        int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            totalSum += arr.get(i);

            minNum = Math.min(minNum, arr.get(i));
            maxNum = Math.max(maxNum, arr.get(i));
        }
        long minSum = totalSum - maxNum, maxSum = totalSum - minNum;
        System.out.print(minSum + " " + maxSum);

        // Below approach fails for 3 test cases. O(2n)
        // long totalSum = 0;
        // for(int i = 0;i < arr.size();i++) {
        // totalSum += arr.get(i);
        // }

        // long maxSum = Integer.MIN_VALUE;
        // long minSum = Integer.MAX_VALUE;
        // for(int i = 0;i < arr.size();i++) {
        // long num = arr.get(i);

        // long currSum = totalSum - num;
        // maxSum = Math.max(currSum, maxSum);
        // minSum = Math.min(currSum, minSum);
        // }

        // System.out.print(minSum + " " + maxSum);
    }

}

// Use class name Solution in HackerRank
public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
