package com.company;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        //1
        stringBuilder.append("Task 1: GCD - Greatest common divisor (ru-нок)");
        //2
        stringBuilder.append("Task 2: LCM least common multiple (ru-нод)");
        //3
        stringBuilder.append("Task 3: Данно:\t купюры по 10, 5, 1;\t Cумма денег <n>.\n" +
                "?=\t Расчитать сколько понадабится купюр чтобы составить сумму <n>\n");
        //4
        stringBuilder.append("Task 4: Данно:\t натуральное число <n>.\n" +
                "?=\t Разложить его на длину различных натуральных чисел, так чтобы количесвто чисел было максимально\n" +
                "Примеры:\n6 = 1+2+3;\t 8 = 1+2+5;\t 18 = 1+2+3+4+8\n");
        //5
        stringBuilder.append("Task 5: Данно: натуральное число n и m, m больше 1.\n" +
                "?=\t 1) Число фибоначи от n\t 2) Вывести остаток от деления fib(n) на число m\n");

        System.out.println(stringBuilder.toString());
}

    public static int gcd(int a, int b) {
        if (a < b) return -1;
        else {
            while (b >= 1) {
                int temp = a % b;
                a = b;
                b = temp;
            }
        }
        return a;
    }

    public static int lcm(int a, int b) {
        if (a < b) return -1;
        return (a * b) / gcd(a, b);
    }

    public static int task3(int summ) {
        int res = 0;
        int[] array = {10, 5, 1};

        for (int i = 0; i < array.length; i++) {
            while (summ >= array[i]) {
                summ -= array[i];
                res++;
            }
        }
        return res;
    }

    public static int task4(int number) {
        int result = 0;
        int temp = 0;
        for (int i = 1; i < number; i++) {
            temp += i;
            result++;
            if (temp + 1 + i > number) {
                return result;
            }
        }
        return 1;
    }

    public static int task5(int n, int m) {
        if (m >= 1) {
            int[] fib = new int[n + 1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < fib.length; i++) {
                fib[i] = fib[i - 2] + fib[i - 1];
                if (fib[i] < 0)
                    return -666;
            }
            return fib[n] % m;
        } else return m;
    }
}


