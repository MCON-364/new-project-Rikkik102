package mcon364.las.touro.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static Optional<String> getUserName(String envVarName) {
        return Optional.ofNullable(System.getenv(envVarName));
    }
    public static String getGreeting(String envVarName) {
        Optional<String> user = getUserName(envVarName);
        StringBuilder greeting = new StringBuilder();
        greeting.append("Hello, ");
           if (user.isPresent()) {
               greeting.append(user.get());
           }
           else {
               greeting.append("World");
           }

        return greeting.toString();
    }

    public static int processValues(List<List<Integer>> data) {
        int processedValues = 0;
        outer:
        for (List<Integer> list : data) {
            inner:
            for (Integer integer : list) {
                if (integer == 0) {
                    continue outer;
                }
                else if (integer == 99) {
                    break outer;
                }
                else processedValues++;
            }
        }
        return processedValues;
    }

    public static void main(String[] args) {
        System.out.println(getGreeting("USERNAME"));
        System.out.println(getGreeting("NO_SUCH_VAR"));
        List<List<Integer>> data = List.of(List.of(1, 2, 3), // processes 3
                List.of(0, 5, 6), // processes none here
                List.of(9, 5, 6), // processes 3 here
                List.of(7, 99, 9), // processes 1 here
                List.of(8, 2, 5)); // does not process here, already broke out
        // 3 + 3 + 1 = 7

        System.out.println(processValues(data) + " processed values"); // should be 7
    }
}