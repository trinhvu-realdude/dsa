package com.travis.hackerrank.problem_solving.basic;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'stringAnagram' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY dictionary
     *  2. STRING_ARRAY query
     */

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        dictionary.forEach(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            int quantity = map.getOrDefault(string, 0) + 1;
            map.put(string, quantity);
        });

        query.forEach(word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            result.add(map.getOrDefault(string, 0));
        });

        return result;
    }

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {
        // Write your code here
        if (!s.contains("u") && !s.contains("e") && !s.contains("o") && !s.contains("a") && !s.contains("i")) {
            return "Not found!";
        }

        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        int max = 0;
        String prevSubstring = "";
        while (index < s.length()) {
            int lastIndex = index + k;
            int vowelQuantity = 0;
            if (lastIndex > s.length()) {
                for (String value : map.keySet()) {
                    return value;
                }
                break;
            }
            String substring = s.substring(index, lastIndex);
            for (int i = 0; i < substring.length(); i++) {
                char c = substring.charAt(i);
                if (c == 'u' || c == 'e' || c == 'o' || c == 'a' || c == 'i') {
                    vowelQuantity++;
                }
            }

            if (vowelQuantity > max) {
                max = vowelQuantity;
                map.put(substring, max);
                map.remove(prevSubstring);
                prevSubstring = substring;
            }
            index++;
        }

        return null;
    }

}

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> query = IntStream.range(0, queryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.stringAnagram(dictionary, query);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
