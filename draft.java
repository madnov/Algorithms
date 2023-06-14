
import java.util.Random;
import java.util.Arrays;
import java.util.Random;

public class draft {

    /**
     * 
     * @apiNote формируем массив из рандомных чисел
     * @apiNote сортируем при помощи функции пирамидальной сортировки
     * @apiNote выводим несортированный и сортированный массивы в терминал
     */

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Неотсортированный массив: " + Arrays.toString(arr));
        Heapsort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    /**
     * @apiNote Построение кучи и извлечение одного за другим элемента из неё
     * @param arr  массив
     */

    public static void Heapsort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    /**
     * @apiNote функция для перегруппировки поддерева с наибольшим элементом 
     * @param arr массив
     * @param n   размер массива
     * @param i   наибольший элемент
     */
    
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
