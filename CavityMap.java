// Problem: https://www.hackerrank.com/challenges/cavity-map/problem

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
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    // Approach: Failing 17/23 test cases because did not cover scenario for >1 and
    // 0 cavities in a single row. T.C.: O(n^2)
    // public static List<String> cavityMap(List<String> grid) {
    // // Write your code here
    // List<String> ans = new ArrayList<>();
    // String topBorder = grid.get(0);
    // ans.add(topBorder);

    // for (int row = 1; row < grid.size() - 1; row++) { // ignoring top and bottom
    // borders
    // String currRow = grid.get(row);
    // for (int col = 1; col < currRow.length() - 1; col++) { // ignoring left and
    // right borders
    // int cell = currRow.charAt(col) - '0';
    // int rightCell = currRow.charAt(col + 1) - '0';
    // int leftCell = currRow.charAt(col - 1) - '0';
    // int topCell = grid.get(row - 1).charAt(col) - '0';
    // int bottomCell = grid.get(row + 1).charAt(col) - '0';

    // if ((cell > rightCell) && (cell > leftCell) && (cell > topCell) && (cell >
    // bottomCell)) {
    // String cavityRow = currRow.substring(0, col) + 'X' + currRow.substring(col +
    // 1);
    // ans.add(cavityRow);
    // }
    // }
    // }

    // String bottomBorder = grid.get(grid.size() - 1);
    // ans.add(bottomBorder);
    // return ans;
    // }

    // Alternate approach: Don't think in terms of Rows and Columns, instead in
    // terms of Strings and Characters. T.C.: O(n^2)
    public static List<String> cavityMap(List<String> grid) {
        List<String> ans = new ArrayList<>();
        for (int row = 0; row < grid.size(); row++) {
            String str = grid.get(row);
            if (row == 0 || row == grid.size() - 1) {
                ans.add(str);
            } else {
                String potentialCavityStr = "";
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (j == 0 || j == str.length() - 1) {
                        potentialCavityStr += ch;
                    } else {
                        int cell = ch - '0';
                        int rightCell = str.charAt(j + 1);
                        int leftCell = str.charAt(j - 1);
                        int topCell = grid.get(row - 1).charAt(j);
                        int bottomCell = grid.get(row + 1).charAt(j);

                        if ((cell > rightCell) && (cell > bottomCell) && (cell > leftCell) && (cell > topCell)) {
                            potentialCavityStr += 'X';
                        } else {
                            potentialCavityStr += ch;
                        }
                    }
                }
                ans.add(potentialCavityStr);
            }
        }
        return ans;
    }
}

// Use class name Solution in HackerRank
public class CavityMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
