package lessons1.typy;
//1.Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
//(через FileWriter).

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 9};

        try {
            // Создаем файл для записи лога
            FileWriter writer = new FileWriter("log.txt");
            BufferedWriter buffer = new BufferedWriter(writer);

            // Сортировка пузырьком
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Обмен элементов
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;

                        // Запись текущего состояния массива в лог-файл
                        buffer.write("Iteration " + (i + 1) + ", Step " + (j + 1) + ": ");
                        for (int k = 0; k < arr.length; k++) {
                            buffer.write(arr[k] + " ");
                        }
                        buffer.newLine();
                    }
                }
            }

            // Закрываем файл
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}