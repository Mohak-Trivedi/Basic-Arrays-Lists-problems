// Problem: https://www.hackerrank.com/challenges/sherlock-and-array/problem

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
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int[] left = new int[arr.size()];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + arr.get(i - 1);
        }

        int[] right = new int[arr.size()];
        right[right.length - 1] = 0;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + arr.get(i + 1);
        }

        for (int i = 0; i < left.length; i++) {
            if (left[i] - right[i] == 0) {
                return "YES";
            }
        }
        return "NO";
    }

}

// Use class name Solution in Hackerrank
public class SherlockAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
