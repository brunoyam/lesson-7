import java.util.*;

public class Main {

    static void findMinAndMax1() {
        int n = 10;

        Set<Integer> numbers = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; ++i) {    // цикл дает нам сложность О(n)
            int tmp = scanner.nextInt();
            numbers.add(tmp);     // операция добавления во множество еще O(log n), суммарно получаем О(n * logn)
        }

        int min = 0;
        int max = 0;

        Iterator<Integer> it = numbers.iterator();
        boolean isFirst = true;
        while (it.hasNext()) {
            if (isFirst) {
                min = it.next();
                isFirst = false;
            } else {
                max = it.next();
            }
        }

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }

    static void findMinAndMaxFast() {
        int n = 10;

        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;     // важно не забыть первое присваивание - в случае минимума, нам изначально нужно очень большое число
        int max = Integer.MIN_VALUE;     // соответственно, нам нужно очень маленькое число
        for (int i = 0; i < n; ++i) {   // здесь только один цикл, в котором N операций, поэтому сложность O(n)
            int a = scanner.nextInt();

            if (a < min) {
                min = a;
            }

            if (a > max) {
                max = a;
            }
        }

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }


    static void twoSumSlow() {

        int n = 6;

        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; ++i) {
            int left = arr[i];

            for (int j = i + 1; j < arr.length; ++j) {
                int right = arr[j];
                if (Math.abs(left) + Math.abs(right) == 0) {
                    System.out.println(left + " " + right);
                }
            }
        }
    }

    static void twoSum() {
        int n = 6;

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Integer> used = new HashMap<>();   // будем на каждом шаге запоминать, какое число нам встретилось

        for (int i = 0; i < n; ++i) {
            int a = scanner.nextInt();  // считали каждое число
            int pair = 0 - a;  // посчитали "парное" ему
            if (used.containsKey(pair)) {   // проверили, есть ли у нас "запомненная" его пара
                System.out.println(a + " " + pair);   // если да - все супер, мы нашли ответ
                break;
            } else {
                used.put(a, i);   // если нет, то запоминаем текущее число для дальнейших проверок
            }
        }
    }

    static void characterCount() {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        HashMap<Character, Integer> used = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {    // бежим по строке
            char cur = s.charAt(i);   // смотрим на текущий символ

            if (used.containsKey(cur)) {   // если он уже у нас был
                int tmp = used.get(cur);   // смотрим, сколько раз уже встречался данный символ
                tmp++;   // увеличиваем счетчик на 1
                used.put(cur, tmp);   // и запоминаем новое значение
            } else {
                used.put(cur, 1);   // иначе, если символа не было, запоминаем, что он встретился нам один раз впервые
            }
        }

        for (Map.Entry<Character, Integer> entry: used.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static boolean validParenthesis(String s) {
        int balance = 0;   // заводим счетчик открытых скобок

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {   // если скобка открывается - увеличиваем счетчик на 1
                balance++;
            } else {
                if (s.charAt(i) == ')') {   // если она закрывается - уменьшаем счетчик на 1
                    balance--;
                    if (balance < 0) { // как только счетчик стал отрицательным - значит у нас больше закрывающих, чем открывающих, мы получили неправильную последовательность
                        return false;
                    }
                }
            }
        }

        if (balance != 0) {   // в конце нужно не забыть проверить, что баланс отрицательный
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(validParenthesis(scanner.nextLine()));
    }
}
