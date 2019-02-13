package kst;

public class Select {

    public static void main(String[] args) {

//        int s1 [] = {5, 11, 7, 5, 1, 19, 99};
        RandomArray ra = new RandomArray(10000000, 10000000); // массив случайных чисел, 1-размер, 2-максимальное число
        int[] s1 = ra.getArray();
//        ra.display();
        k_st r1 = new k_st();

        long timeStartA1 = System.currentTimeMillis();
        int result = r1.select(s1, 5000000); // поиск статистики
        long timeStopA1 = System.currentTimeMillis() - timeStartA1;

        System.out.println("время выполнения поиска K статистики " + timeStopA1 + " миллисекунд");

        System.out.println("K статистика -> " + result); // вывод результата

    }
}
