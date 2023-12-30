// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5)); // Ex 1
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println();
        System.out.println(fitCalc(15, 1)); // Ex 2
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println();
        System.out.println(containers(3, 4, 2)); // Ex 3
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println();
        System.out.println(triangleType(5, 5, 5)); // Ex 4
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println();
        System.out.println(ternaryEvaluation(8, 4)); // Ex 5
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println();
        System.out.println(howManyItems(22, 1.4f, 2)); // Ex 6
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println();
        System.out.println(factorial(3)); // Ex 7
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println();
        System.out.println(gcd(48, 18)); // Ex 8
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println();
        System.out.println(ticketSaler(70, 1500)); // Ex 9
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println();
        System.out.println(tables(5, 2)); // Ex 10
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static float convert(int x){ // Ex 1
        return x * 3.785f;
    }

    public static int fitCalc(int minutes, int intensity){ // Ex 2
        return minutes * intensity;
    }

    public static int containers(int boxes, int bags, int barrels){ // Ex 3
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z){ // Ex 4
        if ((x+y)<=z || (x+z)<=y || (y+z)<=x){
            return "not a triangle";
        }
        if (x != y && x != z && y != z) {
            return  "different-sided";
        }
        if (x == y && y == z){
            return "isosceles";
        }
        return "equilateral";
    }

    public static int ternaryEvaluation(int a, int b){ // Ex 5
        return a > b ? a : b;
    }

    public static int howManyItems(int n, float w, float h){ // Ex 6
        return (int) ((n/2f)/(w*h));
    }

    public static int factorial(int x){ // Ex 7
        int fact = 1;
        if (x == 0) return fact;
        for (int i = 1; i <= x; i++){
            fact *= i;
        }
        return fact;
    }

    public static int gcd(int a, int b){ // Ex 8
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int ticketSaler(int amount, int price){ // Ex 9
        return (int) (amount * price * 0.28f);
    }

    public static int tables(int students, int tablesAmount){ // Ex 10
        float studentPairs = students / 2f;
        if (studentPairs != (int) studentPairs) studentPairs = (int) studentPairs + 1;
        if (studentPairs <= tablesAmount) return 0;
        return (int) (studentPairs - tablesAmount);
    }
}