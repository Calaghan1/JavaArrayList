package aston;

import java.util.Comparator;
/**
 * Реализация собственной коллекции ArrayList
 */
public class ArrayList<T> {
    /**
     * Базовый конструктор с использованием стандартной длины массива
     */
    private final int DEFAULT_CAP = 100;
    private T[] arr;
    private int size;
    private int cap;

    public ArrayList() {
        arr = (T[]) new Object[DEFAULT_CAP];
        cap = DEFAULT_CAP;
    }
    /**
     * Конструктор из массива Т
     */
    public ArrayList(T[] a) {
        arr = a.clone();
        size = a.length - 1;
    }
    /**
     * Конструктор из другого обхекта ArrayList
     */
    public ArrayList(ArrayList<T> a) {
        arr = a.arr.clone();
        size = a.size;
        cap = a.cap;
    }
    /**
     * Конструктор с заданной длиной
     */
    public ArrayList(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            arr = (T[]) new Object[cap];
        }
        this.cap = cap;
    }
    /**
     * Метод добавляет элемент в коллекцию
     */
    public void add(T a) {
        if (cap - size < 10) {
            scale(cap * 2);
        }
        arr[size] = a;
        size++;
    }
    /**
     * Метод добавляет элемент в коллекцию по индексу сдвигая остальные влево
     * @param index индекс куда нужно вставить элемент
     * @param a переменная для вставки
     */
    public void add(int index, T a) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            if (cap - size < 10) {
                scale(cap * 2);
            }
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = a;
            size++;
        }
    }
    /**
     * Метод заменяет элемент коллекции
     * @param index индекс элемента >= 0 и <= size который нужно заменить
     * @param a переменная для замены
     */
    public void replace(int index, T a) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        arr[index] = a;
    }
    /**
     * Метод возвращает элемент коллекции по индексу
     * @param index индекс элемента >= 0 и <= size который нужно вернуть
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return arr[index];
    }
    /**
     * Метод удаляет элемент коллекции по индексу
     * @param index индекс элемента >= 0 и <= size который нужно удалить
     */
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
    /**
     * Метод полностью очищает коллекцию
     */
    public void removeAll() {
        arr = (T[]) new Object[DEFAULT_CAP];
        cap = DEFAULT_CAP;
        size = 0;

    }
    /**
     * Приватный метод увеличения длины массива для коллекции
     * @param newcap кол-во пустых ячеек которые добавляем к массиву
     */
    private void scale(int newcap) {
        cap = newcap;
        T[] buff = (T[]) new Object[cap];
        if (size >= 0) System.arraycopy(arr, 0, buff, 0, size);
        arr = buff;
    }
    /**
     * Геттер для переменной size
     */
    public int size() {
        return size;
    }
    public int cap() {
        return cap;
    }
    /**
     * Обертка для быстрой сортировки
     * @param comparator компоратор для сравнения различных объектов
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    private void quickSort(int left, int right, Comparator<? super T> comparator) {
        if (left < right) {
            int pivot = partition(left, right, comparator);
            quickSort(left, pivot - 1, comparator);
            quickSort(pivot + 1, right, comparator);
        }
    }

    private int partition( int left, int right,  Comparator<? super T> comparator) {
        T pivot = arr[right]; // Опорный элемент
        int i = (left - 1); // Индекс для меньших элементов

        for (int j = left; j < right; j++) {
            // Если текущий элемент меньше опорного, увеличиваем индекс i

            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                // Меняем местами элементы
                swap(i, j);
            }
        }

        // Меняем местами опорный элемент и последний меньший элемент
        swap(i + 1, right);
        return i + 1;
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
