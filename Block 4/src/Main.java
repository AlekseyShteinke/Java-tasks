import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println();
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println();
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println();
        System.out.println(alphOrder("aaabbcdd"));
        System.out.println(alphOrder("vvvvaajaaaaa"));
        System.out.println();
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println();
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println();
        System.out.println(shortestWay(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}}));
        System.out.println(shortestWay(new int[][] {{2,7,3}, {1,4,8}, {4,5,9}}));
        System.out.println();
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println();
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }


    public static String nonRepeatable(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.lastIndexOf(str.charAt(i)) != i){
                str = nonRepeatable(str.substring(0, str.lastIndexOf(str.charAt(i))) + str.substring(str.lastIndexOf(str.charAt(i))+1));
            }
        }
        return str;
    } // Ex 1


    public static List<String> generateBrackets(int amount){
        List<String> list = new ArrayList<>();
        generate(amount, "", list);
        return list;
    } // Ex 2


    private static void generate(int amount, String str, List<String> list){
        if(str.length() == 2 * amount)
            list.add(str);
        else {
            int left = 0;
            int right = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(')
                    left++;
                if(str.charAt(i) == ')')
                    right++;
            }
            if(left == right)
                generate(amount, str + "(", list);
            else if(right < left) {
                if(left < amount)
                    generate(amount, str + "(", list);
                generate(amount, str + ")", list);
            }
        }
    }


    public static List<String> binarySystem(int num){
        List<String> list = new ArrayList<>();
        String binary;
        for (int i = 0; i < Math.pow(2, num); i++){
            binary = Integer.toBinaryString(i);
            if (binary.length() < num){
                for (int j = 0; j <= (num - binary.length()); j++){
                    binary = "0" + binary;
                }
            }
            if (!binary.contains("00")){
                list.add(binary);
            }
        }
        return list;
    } // Ex 3


    public static String alphabeticRow(String str){
        if (str.length() == 1){
            return str;
        }
        String alph = "abcdefghijklmnopqrstuvwxyz";
        String maxStr = str.substring(0, 2);
        String currStr = maxStr;
        boolean incr = alph.indexOf(String.valueOf(str.charAt(1))) > alph.indexOf(String.valueOf(str.charAt(0)));

        for (int i = 2; i < str.length(); i++){
            if ((alph.indexOf(String.valueOf(str.charAt(i))) - alph.indexOf(String.valueOf(str.charAt(i-1))) == 1) && incr){
                currStr += str.charAt(i);
            } else if ((alph.indexOf(String.valueOf(str.charAt(i))) - alph.indexOf(String.valueOf(str.charAt(i-1))) == -1) && !incr) {
                currStr += str.charAt(i);
            }
            else{
                incr = !incr;
                if (currStr.length() > maxStr.length()){
                    maxStr = currStr;
                }
                currStr = String.valueOf(str.charAt(i));
            }
        }
        return currStr.length() > maxStr.length() ? currStr : maxStr;
    } // Ex 4


    public static String alphOrder(String str){
        List<List<String>> chars = new ArrayList<>();
        String copy = str;
        String currChar;
        int counter;
        int i = 0;
        boolean strEnd = false;

        while (i < copy.length()-1){
            currChar = String.valueOf(str.charAt(i));
            counter = 1;
            for (int j = i + 1; j < copy.length(); j++){
                if (currChar.equals(String.valueOf(str.charAt(j)))){
                    counter++;
                }
                else{
                    i = j - 1;
                    break;
                }
                if (j == str.length()-1){
                    strEnd = true;
                }
            }
            chars.add(List.of(currChar, String.valueOf(counter)));
            if (strEnd) break;
            i++;
        }

        int k = 0;
        int maxValue = 1;
        String ans = "";
        while (k < chars.size()){
            for (List<String> aChar : chars) {
                if (Integer.parseInt(aChar.get(1)) == maxValue) {
                    ans += aChar.get(0) + aChar.get(1);
                    k++;
                }
            }
            maxValue++;
        }

        return ans;
    } // Ex 5


    public static int convertToNum(String str){
        List<String> arr = new ArrayList<>();
        int num = 0;
        arr = List.of(str.split(" "));
        if (arr.contains("thousand")){  // Для тысяч есть всего один результат, исходя из условия
            return 1000;
        }
        if (arr.contains("hundred")){  // Если в числе есть сотни
            switch (arr.get(arr.indexOf("hundred") - 1)){ // Определяем разряд сотен
                case "one":
                    num += 1;
                    num *= 100;
                    break;
                case "two":
                    num += 2;
                    num *= 100;
                    break;
                case "three":
                    num += 3;
                    num *= 100;
                    break;
                case "four":
                    num += 4;
                    num *= 100;
                    break;
                case "five":
                    num += 5;
                    num *= 100;
                    break;
                case "six":
                    num += 6;
                    num *= 100;
                    break;
                case "seven":
                    num += 7;
                    num *= 100;
                    break;
                case "eight":
                    num += 8;
                    num *= 100;
                    break;
                case "nine":
                    num += 9;
                    num *= 100;
                    break;
            }
            if (arr.size() - 1 - arr.indexOf("hundred") == 2){  // Проверяем, сколько разрядов в числе после сотен (True -> 2 разряда)
                switch (arr.get(arr.indexOf("hundred") + 1)){  // Добавляем разряд десяток
                    case "twenty":
                        num += 20;
                        break;
                    case "thirty":
                        num += 30;
                        break;
                    case "forty":
                        num += 40;
                        break;
                    case "fifty":
                        num += 50;
                        break;
                    case "sixty":
                        num += 60;
                        break;
                    case "seventy":
                        num += 70;
                        break;
                    case "eighty":
                        num += 80;
                        break;
                    case "ninety":
                        num += 90;
                        break;
                }
                switch (arr.get(arr.indexOf("hundred") + 2)){  // Добавляем разряд единиц
                    case "one":
                        num += 1;
                        break;
                    case "two":
                        num += 2;
                        break;
                    case "three":
                        num += 3;
                        break;
                    case "four":
                        num += 4;
                        break;
                    case "five":
                        num += 5;
                        break;
                    case "six":
                        num += 6;
                        break;
                    case "seven":
                        num += 7;
                        break;
                    case "eight":
                        num += 8;
                        break;
                    case "nine":
                        num += 9;
                        break;
                }
            }
            else if (arr.size() - 1 - arr.indexOf("hundred") == 1){  // Если остаётся только один разряд, дописываем его
                switch (arr.get(arr.indexOf("hundred") + 1)){
                    case "ten":
                        num += 10;
                        break;
                    case "eleven":
                        num += 11;
                        break;
                    case "twelve":
                        num += 12;
                        break;
                    case "thirteen":
                        num += 13;
                        break;
                    case "fourteen":
                        num += 14;
                        break;
                    case "fifteen":
                        num += 15;
                        break;
                    case "sixteen":
                        num += 16;
                        break;
                    case "seventeen":
                        num += 17;
                        break;
                    case "eighteen":
                        num += 18;
                        break;
                    case "nineteen":
                        num += 19;
                        break;
                    case "twenty":
                        num += 20;
                        break;
                    case "thirty":
                        num += 30;
                        break;
                    case "forty":
                        num += 40;
                        break;
                    case "fifty":
                        num += 50;
                        break;
                    case "sixty":
                        num += 60;
                        break;
                    case "seventy":
                        num += 70;
                        break;
                    case "eighty":
                        num += 80;
                        break;
                    case "ninety":
                        num += 90;
                        break;
                    case "one":
                        num += 1;
                        break;
                    case "two":
                        num += 2;
                        break;
                    case "three":
                        num += 3;
                        break;
                    case "four":
                        num += 4;
                        break;
                    case "five":
                        num += 5;
                        break;
                    case "six":
                        num += 6;
                        break;
                    case "seven":
                        num += 7;
                        break;
                    case "eight":
                        num += 8;
                        break;
                    case "nine":
                        num += 9;
                        break;
                }
            }
        }
        else if (arr.size() == 2){  // Если сотен нет и в числе 2 разряда, записываем их
            switch (arr.get(0)){
                case "twenty":
                    num += 20;
                    break;
                case "thirty":
                    num += 30;
                    break;
                case "forty":
                    num += 40;
                    break;
                case "fifty":
                    num += 50;
                    break;
                case "sixty":
                    num += 60;
                    break;
                case "seventy":
                    num += 70;
                    break;
                case "eighty":
                    num += 80;
                    break;
                case "ninety":
                    num += 90;
                    break;
            }
            switch (arr.get(1)){
                case "one":
                    num += 1;
                    break;
                case "two":
                    num += 2;
                    break;
                case "three":
                    num += 3;
                    break;
                case "four":
                    num += 4;
                    break;
                case "five":
                    num += 5;
                    break;
                case "six":
                    num += 6;
                    break;
                case "seven":
                    num += 7;
                    break;
                case "eight":
                    num += 8;
                    break;
                case "nine":
                    num += 9;
                    break;
            }
        }
        else{  // Если нет сотен и в числе 1 разряд, записываем его
            switch (arr.get(0)) {
                case "one":
                    num += 1;
                    break;
                case "two":
                    num += 2;
                    break;
                case "three":
                    num += 3;
                    break;
                case "four":
                    num += 4;
                    break;
                case "five":
                    num += 5;
                    break;
                case "six":
                    num += 6;
                    break;
                case "seven":
                    num += 7;
                    break;
                case "eight":
                    num += 8;
                    break;
                case "nine":
                    num += 9;
                    break;
                case "ten":
                    num += 10;
                    break;
                case "eleven":
                    num += 11;
                    break;
                case "twelve":
                    num += 12;
                    break;
                case "thirteen":
                    num += 13;
                    break;
                case "fourteen":
                    num += 14;
                    break;
                case "fifteen":
                    num += 15;
                    break;
                case "sixteen":
                    num += 16;
                    break;
                case "seventeen":
                    num += 17;
                    break;
                case "eighteen":
                    num += 18;
                    break;
                case "nineteen":
                    num += 19;
                    break;
            }
        }
        return num;
    } // Ex 6


    public static String uniqueSubstring(String str){
        int maxLen = 0;
        String maxStr = "";
        String currStr = "";
        int len = 0;
        int i = 0;

        while (i < str.length()){
            if (!currStr.contains(String.valueOf(str.charAt(i)))){
                currStr += str.charAt(i);
                len++;
            }
            else{
                if (len > maxLen){
                    maxLen = len;
                    maxStr = currStr;
                }
                currStr = currStr.substring(currStr.indexOf(str.charAt(i))+1) + str.charAt(i);
                len = currStr.length();
            }
            i++;
        }
        return maxStr;
    } // Ex 7


    public static int shortestWay(int[][] matrix){
        int n = matrix.length-1;
        int i, j;
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = matrix[0][0];

        for (i = 1; i <= n; i++)
            dp[i][0] = dp[i - 1][0] + matrix[i][0];

        for (j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + matrix[0][j];

        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];

        return dp[n][n];
    } // Ex 8


    public static String numericOrder(String str){
        List<String> arr = new ArrayList<>();
        arr = List.of(str.split(" "));
        int i = 1;  // Счётчик слов
        int len = arr.size();
        String ans = "";
        String currWord;
        boolean br;  // Индикатор выхода из цикла
        while (i <= len){  // Цикл работает, пока не найдём все слова
            br = false;
            for (int j = 0; j < len; j++){  // Перебираем слова
                currWord = arr.get(j);  // Текущее слово
                for (int k = 0; k < currWord.length(); k++){  // Ищем в буквах текущего слова нужную цифру
                    if ((Character.getNumericValue(currWord.charAt(k))) == i){
                        if (k < currWord.length()-1) {  // Проверка нужна для избежания ошибки выхода за индексы
                            currWord = currWord.substring(0, k) + currWord.substring(k + 1);
                        }
                        else {
                            currWord = currWord.substring(0, k);
                        }
                        br = true;
                        break;
                    }
                }
                if (br){
                    i++;
                    ans += currWord + " ";
                    break;
                }
            }
        }
        return ans.substring(0, ans.length()-1);
    } // Ex 9


    public static int switchNums(int num1, int num2){
        List<Integer> arr = new ArrayList<>();
        String ans = String.valueOf(num2);
        while (num1 >= 1){  // Добавляем цифры числа в список
            arr.add(num1 % 10);
            num1 /= 10;
        }
        arr.sort(Comparator.reverseOrder());  // Сортируем список в порядке убывания
        for (int i : arr){
            for (int j = 0; j < ans.length(); j++){  // Заменяем цифры на большие, начиная со старшего разряда
                if (i > Character.getNumericValue(ans.charAt(j))){
                    ans = ans.replaceFirst(String.valueOf(ans.charAt(j)), String.valueOf(i));
                    break;
                }
            }
        }
        return Integer.parseInt(ans);
    } // Ex 10
}