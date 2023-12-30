import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple")); // Ex 1
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println();
        System.out.println(stringTransform("hello")); // Ex 2
        System.out.println(stringTransform("bookkeeper"));
        System.out.println();
        System.out.println(doesBlockFit(1, 3, 5, 4, 5)); // Ex 3
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println();
        System.out.println(numCheck(243)); // Ex 4
        System.out.println(numCheck(52));
        System.out.println();
        int[] arr1 = {1, -3, 2};
        System.out.println(countRoots(arr1)); // Ex 5
        int[] arr2 = {2, 5, 2};
        System.out.println(countRoots(arr2));
        int[] arr3 = {1, -6, 9};
        System.out.println(countRoots(arr3));
        System.out.println(); // Ex 6
        String[][] arr4 = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Banana", "Shop2", "Shop3", "Shop4"}, {"Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}};
        System.out.println(salesData(arr4));
        String[][] arr5 = {{"Fridge", "Shop2", "Shop3"}, {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, {"Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        System.out.println(salesData(arr5));
        System.out.println();
        System.out.println(validSplit("apple eagle egg goat")); // Ex 7
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println();
        int[] arr6 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(arr6)); // Ex 8
        int[] arr7 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(arr7));
        int[] arr8 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(arr8));
        System.out.println();
        System.out.println(commonVovel("Hello world")); // Ex 9
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println();
        int[][] matrix1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {5, 5, 5, 5, 5}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}}; // Ex 10
        System.out.println(Arrays.deepToString(dataScience(matrix1)));
        int[][] matrix2 = {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}};
        System.out.println(Arrays.deepToString(dataScience(matrix2)));
    }

    public static String replaceVovels(String text){ // Ex 1
        String[] vovels = {"a", "e", "y", "u", "o", "i", "A", "E", "Y", "U", "I", "O"};
        for (String vovel : vovels) {
            text = text.replace(vovel, "*");
        }
        return text;
    }

    public static String stringTransform(String str){ // Ex 2
        String x = str;
        for (int i = 0; i < x.length()-1; i++) {
            if (x.charAt(i) == x.charAt(i+1)) {
                str = str.replaceFirst(x.substring(i, i+2), "Double"+x.substring(i, i+1).toUpperCase());
            }
        }
        return str;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h){ // Ex 3
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return arr[0] * arr[1] <= w * h;
    }

    public static boolean numCheck(int num){ // Ex 4
        int numx = num;
        int sum = 0;
        while (numx >= 1){
            sum += (int) pow(numx % 10, 2);
            numx /= 10;
        }
        return sum % 2 == num % 2;
    }

    public static int countRoots(int[] arr){ // Ex 5
        int discr = arr[1]*arr[1] - 4 * arr[0] * arr[2];
        if (discr < 0) return 0;
        double x1 = (-arr[1] + sqrt(discr)) / (2 * arr[0]);
        double x2 = (-arr[1] - sqrt(discr)) / (2 * arr[0]);
        int ans = 0;
        if (x1 == (int)x1 && x1 == x2) return 1;
        if (x1 == (int)x1) ans++;
        if (x2 == (int)x2) ans++;
        return ans;
    }

    public static List<String> salesData(String[][] arr){ // Ex 6
        Arrays.sort(arr, (a1, a2) -> Integer.compare(a2.length, a1.length));
        int maxLen = arr[0].length;
        List<String> maxSales = new ArrayList<>();
        for (String[] strings : arr) {
            if (strings.length == maxLen) {
                maxSales.add(strings[0]);
            }
        }
        return maxSales;
    }

    public static boolean validSplit(String str){ // Ex 7
        String[] words = str.split(" ");
        for (int i=0; i < words.length-1; i++){
            if(words[i].charAt(words[i].length()-1) != words[i+1].charAt(0)) return false;
        }
        return true;
    }

    public static boolean waveForm(int[] arr){ // Ex 8
        boolean incr;
        if (arr[0] > arr[1]){
            incr = true;
        }else if (arr[0] < arr[1]){
            incr = false;
        }else{
            return false;
        }
        for (int i=1; i<arr.length-1; i++){
            if (incr){
                if (arr[i] > arr[i+1]) return false;
            }else{
                if (arr[i] < arr[i+1]) return false;
            }
            incr = !incr;
        }
        return true;
    }

    public static String commonVovel(String str){ // Ex 9
        String vovels = "aeyuio";
        str = str.replace(" ", "").toLowerCase();
        String maxVovel = "";
        int maxLen = 0;
        int counter;
        for (int i=0; i<vovels.length(); i++){
            counter = 0;
            for (int j=0; j<str.length(); j++){
                if (str.charAt(j) == vovels.charAt(i)) counter++;
            }
            if (counter > maxLen){
                maxLen = counter;
                maxVovel = String.valueOf(vovels.charAt(i));
            }
        }
        return maxVovel;
    }

    public static int[][] dataScience(int[][] matrix){ // Ex 10
        for (int j=0; j<matrix.length; j++){
            int sum = 0;
            for (int i=0; i<matrix.length; i++){
                if (i == j) continue;
                sum += matrix[i][j];
            }
            matrix[j][j] = Math.round((float) sum / (matrix.length - 1));
        }
        return matrix;
    }
}