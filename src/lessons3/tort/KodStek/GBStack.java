package lessons3.tort.KodStek;

public class GBStack {
    private int[] arr;
    private int top;
    private int capacity;

    // Конструктор для инициализации stack
    public GBStack() {
        int size = 3;
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    private void addCapacity() {
        int[] copy = new int[arr.length + arr.length/2];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        arr = copy;
        capacity = arr.length;
    }

    // Вспомогательная функция для добавления элемента `x` в stack
    public GBStack push(int x)
    {
        if (isFull()) {
            addCapacity();
        }
        arr[++top] = x;
        return this;
    }

    // Вспомогательная функция для извлечения верхнего элемента из stack
    public int pop() {
        // проверка на опустошение stack
        if (empty()) {
            throw new RuntimeException("Stack isEmpty");
        }
        peek();
        // уменьшаем размер stack на 1 и (необязательно) возвращаем извлеченный элемент
        return arr[top--];
    }

    // Вспомогательная функция для возврата верхнего элемента stack
    public int peek()
    {
        if (!empty()) {
            return arr[top];
        }
        else {
            throw new RuntimeException("Stack isEmpty");
        }
    }

    // Вспомогательная функция для возврата размера stack
    public int size() {
        return top + 1;
    }

    // Вспомогательная функция для проверки, пуст stack или нет
    public boolean empty() {
        return top == -1;               // или return size() == 0;
    }

    // Вспомогательная функция для проверки, заполнен ли stack или нет
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int item : arr) {
            builder.append(item).append(", ");
        }
        builder.delete(builder.length()-2, builder.length());
        return String.format("[%s]", builder);
    }
}