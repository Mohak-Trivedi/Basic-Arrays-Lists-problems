// Problem: https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true

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
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int pdsum = 0; // Primary diagonal sum
        for (int i = 0, j = 0; i < arr.size(); i++, j++) {
            pdsum += arr.get(i).get(j);
        }

        int sdsum = 0; // Secondary diagonal sum
        for (int i = 0, j = arr.size() - 1; i < arr.size(); i++, j--) {
            sdsum += arr.get(i).get(j);
        }

        return Math.abs(pdsum - sdsum);
    }

    // Alternate Approach:
    // public static int diagonalDifference(List<List<Integer>> arr) {
    // // Write your code here
    // int pdsum = 0, sdsum = 0;
    // for (int i = 0; i < arr.size(); i++) {
    // for (int j = 0; j < arr.size(); j++) {
    // if (i == j) {
    // pdsum += arr.get(i).get(j);
    // } else if ((i + j) == (arr.size() - 1)) {
    // sdsum += arr.get(i).get(j);
    // }
    // }
    // }

    // return Math.abs(pdsum - sdsum);
    // }

}

// Use class name Solution when using in Hackerrank
public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
