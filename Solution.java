import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
    String result = "Possible";
     HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int col = 0; col < container.length; col++) {
      int sum = 0;
      for (int row = 0; row < container.length; row++) {
        sum += container[row][col];
      }
 
      hm.put(col, sum);
 
      System.out.println("organizingContainers <<< hm: " + hm.toString());
    }
 
    for (int row = 0; row < container.length; row++) {
 
      int sum = 0;
      for (int col = 0; col < container.length; col++)
        sum += container[row][col];
 
      if (hm.containsValue(sum)) {
 
        hm.values().remove(sum);
 
        System.out.println("organizingContainers <<< hm: " + hm.toString());
      } else {
        result = "Impossible";
        break;
      }
    }
 
    return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
