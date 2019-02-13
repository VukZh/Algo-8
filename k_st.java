package kst;

public class k_st {

    int[] arr;
    int k;

    k_st() {
//        arr = a;
    }

    int select(int[] a, int x) { // вызов поиска К статистики 
        arr = a;
        k = x - 1;
        int l = 0;
        int r = arr.length - 1;
        if (x > r + 1 || x < l + 1) {
            System.out.println("выход за пределы массива"); // проверка выхода К статистики за пределы и вывод медианы медиан
            return median(arr, l, r);
        }
        return k_stat(l, r, k);
    }

//      поиск К статистики, l и r - границы поиска, k - значение статистики
    int k_stat(int l, int r, int k) {
        if (l >= r) {
            return arr[l];
        }
        int i = l;
        int j = r;
        int p = median(arr, l, r); // опорная точка разделения - медиана медиан части массива между l и r
//      Partition
        while (i < j) {
            while (arr[i] < p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if (i < j) {

                if (arr[i] == arr[j]) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
//      для вывода состояния массива по шагам
//                for (int m = 0; m < arr.length; m++) {
//                    System.out.print(" - " + arr[m]);
//                }
//                    System.out.println("");
            }
        }
//            System.out.print(" L-" + l);
//            System.out.print("    R-" + r);
//            System.out.print("    I-" + i);
//            System.out.print("    J-" + j);
//            System.out.println("");
//        

        if (k >= l && k < i) {
            return k_stat(l, i - 1, k); // рекурсионный вызов поиска для левой или правой части
        } else if (j < k && k <= r) {
            return k_stat(j + 1, r, k);
        } else {
            return arr[i]; // разбиение остановилось на K -> вывод
        }

    }

    int median(int[] a) { // медиана медиан
        int len = 0;
        int m[] = new int[5]; // подмассив на 5 элементов
        int mm[] = new int[(int) Math.ceil((double) a.length / 5)]; // размер массива медиан
        int i = 0;
        while ((len + 4) < a.length) { //подмассивы по 5 элементов
            System.arraycopy(a, len, m, 0, 5);
            insSorting(m);
            len += 5;
            mm[i] = m[2];
            i++;
        }
        if (a.length % 5 != 0) { // последний подмассив
            int[] m2 = new int[a.length % 5];
            System.arraycopy(a, len, m2, 0, a.length % 5);
            insSorting(m2);
            mm[i] = m2[(int) Math.floor((int) Math.floor((m2.length - 1) / 2))];
        }

        if (mm.length != 1) {
            median(mm); // рекурсия пока медиана не 1
        }
        return mm[0]; // медиана медиан

    }

    int median(int[] a, int Left, int Right) {// медиана медиан на части массива
        int[] temp = new int[Right - Left + 1];
        System.arraycopy(a, Left, temp, 0, (int) (Right - Left + 1));
        return median(temp);
    }

    public int[] insSorting(int a[]) { // сорировка вставкой для median
        int in, out;
        for (out = 1; out < a.length; out++) //out - разделитель
        {
            int temp = a[out]; // Скопировать элемент на разделителе
            in = out; // Начать перемещения с out
            while (in > 0 && a[in - 1] >= temp) //Ищем наименьший
            {
                a[in] = a[in - 1]; //и пока не равен сдвигаем элемент вправо
                --in; // Перейти на одну позицию влево
            }
            a[in] = temp; // Вставляем помеченный элемент
        }
        return a;
    }

}
