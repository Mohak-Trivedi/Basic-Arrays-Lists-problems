
// Problem: https://www.hackerrank.com/challenges/insertionsort1/problem?h_r=next-challenge&h_v=zen
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
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY arr
     */

    public static void dispArr(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int unsortedEle = arr.get(arr.size() - 1);

        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) > unsortedEle) {
            arr.set(i + 1, arr.get(i));
            dispArr(arr);
            i--;
        }

        arr.set(i + 1, unsortedEle);
        dispArr(arr);
    }

}

// Use class name Solution in HackerRank
public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
