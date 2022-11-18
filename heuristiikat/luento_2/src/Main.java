import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task7_14();
        task7_15();
        task7_16();
        task7_17();
        task7_19();
    }

    private static void task7_14() {
        // 7-14.[4] Write a function to find all permutations of the letters in a particular string.
        System.out.printf("Task 2_14%n");
        String str = "abcd";
        System.out.printf("Permutations of %s are:%n", str);
        printPermutations(str, "");
    }

    private static void task7_15() {
        // 7-15. [4] Implement an efficient algorithm for listing all k-element subsets of n items.
        System.out.printf("%nTask 2_15%n");
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.printf("All %d-element subsets of %s are:%n", k, Arrays.toString(arr));
        printSubsets(arr, k, 0, new int[k]);
    }

    private static void task7_16() {
        //7-16.[5] An anagram is a rearrangement of the letters in a given string into a sequence of dictionary words,
        // like Steven Skiena into Vainest Knees. Propose an algorithm to construct all the anagrams of a given string.
        // This algorithm should check if two Strings are anagrams of each other.

        System.out.printf("%nTask 2_16%n");
        String str = "Keko Salata";
        String str2 = "Sakke Aalto";
        System.out.printf("Is %s an anagram of %s? %s%n", str, str2, isAnagram(str, str2));
        str = "Testi Ensimmäinen";
        str2 = "Testi Toinen";
        System.out.printf("Is %s an anagram of %s? %s%n", str, str2, isAnagram(str, str2));
    }

    private static void task7_17() {
        //7-17.[5] Telephone keypads have letters on each numerical key.
        // Write a program that generates all possible words resulting from translating
        // a given digit sequence (e.g., 145345) into letters.

        System.out.printf("%nTask 2_17%n");
        String str = "2345";
        System.out.printf("Possible words for %s are:%n", str);
        printWords(str, "");
    }

    private static void task7_19() {
        //7-19. [4] Use a random number generator (rng04) that generates numbers from {0 ,1, 2, 3, 4} with equal
        // probability to write a random number generator that generates numbers from 0 to 7 (rng07) with equal probability.
        // What are expected number of calls to rng04 per call of rng07?

        System.out.printf("%nTask 2_19%n");
        System.out.printf("Random number from 0 to 7: %d%n%n", rng07().keySet().iterator().next());

        System.out.printf("Test: 1000000 calls to rng07%n");
        int[] arr = new int[8];
        int rng04Calls = 0;
        for (int i = 0; i < 1000000; i++) {
            Map<Integer, Integer> rng07 = rng07();
            int num = rng07.keySet().iterator().next();
            arr[num]++;
            rng04Calls += rng07.get(num);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Amount of %d as the result is %s and percentage is %.2f %% %n" , i, arr[i], (double)arr[i] / 10000);
        }
        System.out.printf("%nExpected number of calls to rng04 per call of rng07 is %.2f%n", (double) rng04Calls / 1000000);
    }

    private static void printSubsets(int[] arr, int k, int i, int[] ints) {
        if (k == 0) {
            System.out.println(Arrays.toString(ints));
            return;
        }
        if (i == arr.length) {
            return;
        }
        ints[k - 1] = arr[i];
        printSubsets(arr, k - 1, i + 1, ints);
        printSubsets(arr, k, i + 1, ints);
    }
    private static Map<Integer, Integer> rng07() {
        int result;
        int rng04Calls = 0;
        do {
            int num1 = rng04();
            int num2 = rng04();
            result = 5 * num1 + num2 ;
            rng04Calls += 2;
        } while (result > 7);
        return Map.of(result, rng04Calls);
    }

    private static Integer rng04() {
        return (int) (Math.random() * 5);
    }

    private static void printWords(String str, String s) {
        if (str.length() == 0) {
            System.out.println(s);
            return;
        }
        char[] chars = getChars(str.charAt(0));
        for (char c : chars) {
            printWords(str.substring(1), s + c);
        }
    }

    private static char[] getChars(char charAt) {
        return switch (charAt) {
            case '1' -> new char[]{'1'};
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            case '0' -> new char[]{'0'};
            default -> new char[]{};
        };
    }

    private static boolean isAnagram(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        char[] chars = str.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        return Arrays.equals(chars, chars2);
    }

    private static void printPermutations(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                printPermutations(rem, prefix + str.charAt(i));
            }
        }
    }
}