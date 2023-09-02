// Problem: https://www.hackerrank.com/challenges/cut-the-sticks/problem

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
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    // failing for :
    // 6
    // 5 4 4 2 2 8
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        ArrayList<Integer> sticksRemaining = new ArrayList<Integer>();

        while (arr.size() > 0) {
            // Store current number of sticks remaining
            sticksRemaining.add(arr.size());

            // Find smallest stick in current iteration
            int smallest = Integer.MAX_VALUE;
            for (int i = 0; i < arr.size(); i++) {
                int currStick = arr.get(i);
                smallest = Math.min(smallest, currStick);
            }

            for (int i = 0; i < arr.size(); i++) {
                int currStick = arr.get(i);

                // cut the current stick
                currStick -= smallest;
                arr.set(i, currStick);

                // discard the current smallest stick i.e. stick which got totally cut (0) after
                // cutting
                if (currStick == 0) {
                    arr.remove(i);

                    i--; // to avoid skipping next stick
                }
            }
        }

        return sticksRemaining;
    }

}

// Use class name Solution in HackerRank
public class CutTheSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
