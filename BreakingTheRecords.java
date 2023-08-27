// Problem:
// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int maxScore = scores.get(0);
        int minScore = scores.get(0);
        int maxCnt = 0, minCnt = 0;

        for (int i = 0; i < scores.size(); i++) {
            int curScore = scores.get(i);
            if (curScore > maxScore) {
                maxScore = curScore;
                maxCnt++;
            }
            if (curScore < minScore) {
                minScore = curScore;
                minCnt++;
            }
        }

        // List<Integer> freq = new ArrayList<>(2);
        // freq.add(maxCnt);
        // freq.add(minCnt);
        List<Integer> freq = Arrays.asList(maxCnt, minCnt); // this replaces above three lines

        return freq;
    }
}

// Use class name Solution in HackerRank
public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
