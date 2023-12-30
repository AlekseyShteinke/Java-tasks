import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.abs;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald")); // Ex 1
        System.out.println(duplicateChars("Orange"));
        System.out.println();
        System.out.println(getInitials("Ryan Gosling")); // Ex 2
        System.out.println(getInitials("Barak Obama"));
        System.out.println();
        int[] arr1 = {44, 32, 86, 19}; // Ex 3
        System.out.println(differenceEvenOdd(arr1));
        int[] arr2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(arr2));
        System.out.println();
        int[] arr3 = {1, 2, 3, 4, 5}; // Ex 4
        System.out.println(equalToAvg(arr3));
        int[] arr4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(arr4));
        System.out.println();
        int[] arr5 = {1, 2, 3};
        System.out.println(Arrays.toString(indexMult(arr5))); // Ex 5
        int[] arr6 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(arr6)));
        System.out.println();
        System.out.println(reverse("Hello World")); // Ex 6
        System.out.println(reverse("The quick brown fox."));
        System.out.println();
        System.out.println(tribonacci(7)); // Ex 7
        System.out.println(tribonacci(11));
        System.out.println();
        System.out.println(pseudoHash()); // Ex 8
        System.out.println(pseudoHash());
        System.out.println();
        System.out.println(botHelper("Hello, I’m under the water, please help me")); // Ex 9
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println();
        System.out.println(isAnagram("listen", "silent")); // Ex 10
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String word){ // Ex 1
        word = word.toLowerCase();
        for (int i=0; i<word.length()-1; i++){
            int dupIndex = word.indexOf(word.charAt(i), i+1);
            if (dupIndex != -1){
                return true;
            }
        }
        return false;
    }

    public static String getInitials(String fullName){ // Ex 2
        String[] name = fullName.split(" ");
        return Character.toString(name[0].charAt(0)) + name[1].charAt(0);
    }

    public static int differenceEvenOdd(int[] arr){ // Ex 3
        int evenSum = 0, oddSum = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                evenSum += j;
            } else {
                oddSum += j;
            }
        }
        return abs(evenSum - oddSum);
    }

    public static boolean equalToAvg(int[] arr){ // Ex 4
        float avg = 0;
        for (int i : arr){
            avg += i;
        }
        avg /= arr.length;
        for (int i : arr){
            if (i == avg) return true;
        }
        return false;
    }

    public static int[] indexMult(int[] arr){ // Ex 5
        for (int i=0; i<arr.length; i++){
            arr[i] = arr[i] * i;
        }
        return arr;
    }

    public static String reverse(String str){ // Ex 6
        String newStr = "";
        for (int i=str.length()-1; i>=0; i--){
            newStr += str.charAt(i);
        }
        return newStr;
    }

    public static int tribonacci(int n){ // Ex 7
        if (n == 1 || n == 2) return 0;
        if (n == 3) return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static String pseudoHash(){ // Ex 8
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Random rand = new Random();
        String hash = "";
        char[] alphabet = "abcdef".toCharArray();
        for (int i = 0; i<len; i++) {
            int x = rand.nextInt(2);
            if (x % 2 == 0){
                hash += rand.nextInt(10);
            } else {
                hash += alphabet[rand.nextInt(6)];
            }
        }
        return hash;
    }

    public static String botHelper(String message){ // Ex 9
        for (String i : message.toLowerCase().split(" "))
            if (i.equals("help")){
                return "Calling for a staff member";
            }
        return "Keep waiting";
    }

    public static boolean isAnagram(String word1, String word2){ // Ex 10
        char[] str1 = word1.replaceAll(" ", "").toCharArray();
        char[] str2 = word2.replaceAll(" ", "").toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}