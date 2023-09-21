package com.travis.hackerrank.problem_solving;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int sum = 0;
        for (Integer num : ar) {
            sum += num;
        }

        return sum;
    }

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int pointAlice = 0;
        int pointBob = 0;
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < 3) {
            if (a.get(i) > b.get(i)) {
                pointAlice++;
            }

            if (a.get(i) < b.get(i)) {
                pointBob++;
            }

            i++;
        }
        result.add(pointAlice);
        result.add(pointBob);
        return result;
    }

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int firstSum = 0;
        int secondSum = 0;

        int i = 0;
        int j = 0;
        while (i < arr.size()) {
            firstSum += arr.get(i).get(j);
            j++;
            i++;
        }

        i = 0;
        j = arr.size() - 1;
        while (i < arr.size()) {
            secondSum += arr.get(i).get(j);
            j--;
            i++;
        }

        return Math.abs(firstSum - secondSum);
    }

    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (Integer num : arr) {
            if (num > 0) {
                positive++;
            }
            if (num < 0) {
                negative++;
            }
            if (num == 0) {
                zero++;
            }
        }

        System.out.println(getSixDigitsDecimal((double) positive / arr.size()));
        System.out.println(getSixDigitsDecimal((double) negative / arr.size()));
        System.out.println(getSixDigitsDecimal((double) zero / arr.size()));
    }

    public static double getSixDigitsDecimal(double n) {
        return Math.round(n * Math.pow(10, 6)) / Math.pow(10, 6);
    }

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void staircase(int n) {
        // Write your code here
        int k = 0;
        int j = 1;
        while (k < n) {
            int blank = n - j;
            int sharp = n - blank;
            for (int i = 0; i < blank; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < sharp; i++) {
                System.out.print("#");
            }
            System.out.println();
            j++;
            k++;
        }
    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long sum = 0;
        for (Integer num : arr) {
            sum += num;
        }

        long min = 0;
        long max = 0;

        int i = 0;
        while (i < arr.size()) {
            long secondSum = sum - arr.get(i);
            if (min == 0 && max == 0) {
                min = secondSum;
                max = secondSum;
            }
            if (secondSum < min) {
                min = secondSum;
            }

            if (secondSum > max) {
                max = secondSum;
            }
            i++;
        }
        System.out.println(min + " " + max);
    }

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */
    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int max = 0;
        for (Integer candle : candles) {
            if (candle > max) {
                max = candle;
            }
        }

        int count = 0;
        for (Integer candle : candles) {
            if (candle == max) {
                count++;
            }
        }
        return count;
    }

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);

        if (s.contains("PM")) {
            if (hour < 12) {
                hour = hour + 12;
            }
        }

        if (s.contains("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        }

        return hour < 10
                ? ("0" + hour + ":" + time[1] + ":" + time[2]).replace("PM", "").replace("AM", "")
                : (hour + ":" + time[1] + ":" + time[2]).replace("PM", "").replace("AM", "");
    }

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (Integer originalGrade : grades) {
            if (originalGrade > 10) {
                if (originalGrade >= 38) {
                    if (originalGrade % 5 != 0) {
                        int finalGrade = 0;
                        int minus = originalGrade - ((originalGrade / 10) * 10);

                        if (minus > 5) finalGrade = originalGrade + (10 - minus);
                        if (minus < 5) finalGrade = originalGrade + (5 - minus);

                        if (finalGrade - originalGrade < 3) {
                            result.add(finalGrade);
                        } else {
                            result.add(originalGrade);
                        }
                    } else {
                        result.add(originalGrade);
                    }
                } else {
                    result.add(originalGrade);
                }
            } else {
                result.add(originalGrade);
            }
        }
        return result;
    }

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        System.out.println(countFruit(s, t, apples, a));
        System.out.println(countFruit(s, t, oranges, b));
    }

    private static int countFruit(int s, int t, List<Integer> fruits, int tree) {
        int count = 0;

        for (Integer fruit : fruits) {
            int position = fruit + tree;
            if (position >= s && position <= t) {
                count++;
            }
        }
        return count;
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if (x1 == x2) return "YES";

        if ((x1 > x2 && v1 >= v2) || (x2 > x1 && v2 >= v1)) {
            return "NO";
        }

        return kangaroo(x1 + v1, v1, x2 + v2, v2);
    }

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        boolean flagA = false;
        boolean flagB = false;
        int count = 0;
        for (int i = a.get(a.size() - 1); i <= b.get(0); i++) {
            for (Integer integer : a) {
                if (i % integer == 0) {
                    flagA = true;
                } else {
                    flagA = false;
                    break;
                }
            }

            if (flagA) {
                for (Integer integer : b) {
                    if (integer % i == 0) {
                        flagB = true;
                    } else {
                        flagB = false;
                        break;
                    }
                }
                if (flagB) {
                    count++;
                }
            }
        }
        return count;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
