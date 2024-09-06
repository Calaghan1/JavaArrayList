package Aston;

import static org.junit.jupiter.api.Assertions.*;

class arraylistTest {

    @org.junit.jupiter.api.Test
    void add() {
        arraylist<Integer> list = new arraylist<>();
        list.add(1);
        list.add(2);
        assertEquals(list.size(), 2);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(list.size(), 1002);
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        arraylist<Double> list = new arraylist<>();
        list.add(1.0);
        list.add(0,2.0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), 2.0);
        assertEquals(list.get(1), 1.0);
    }

    @org.junit.jupiter.api.Test
    void replace() {
        arraylist<String> list = new arraylist<>();
        list.add("1");
        assertEquals(list.get(0), "1");
        list.replace(0, "13");
        assertEquals(list.get(0), "13");

    }

    @org.junit.jupiter.api.Test
    void get() {
        arraylist<String> list = new arraylist<>();
        list.add("1");
        assertEquals(list.get(0), "1");
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(1);});
        arraylist<Integer> list2 = new arraylist<>();
        assertThrowsExactly(IllegalArgumentException.class, () -> {list2.get(0);});

    }

    @org.junit.jupiter.api.Test
    void remove() {
        arraylist<String> list = new arraylist<>();
        list.add("1");
        assertEquals(list.get(0), "1");
        list.remove(0);
        assertEquals(list.size(), 0);
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(0);});
    }

    @org.junit.jupiter.api.Test
    void removeALL() {
        arraylist<String> list = new arraylist<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(list.size(), 3);
        list.removeALL();
        assertEquals(list.size(), 0);
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(0);});
    }

    @org.junit.jupiter.api.Test
    void size() {
        arraylist<String> list = new arraylist<>();
        list.add("1");
        assertEquals(list.size(), 1);
        list.add("2");
        assertEquals(list.size(), 2);
    }
    @org.junit.jupiter.api.Test
    void sort() {
        arraylist<String> list = new arraylist<>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        list.sort(String::compareTo);
        assertEquals(list.size(), 5);
        assertEquals(list.get(0), "1");
        assertEquals(list.get(1), "2");
        assertEquals(list.get(2), "3");
        assertEquals(list.get(3), "4");
        assertEquals(list.get(4), "5");

        arraylist<Double> list2 = new arraylist<>();
        list2.add(3.0);
        list2.add(2.0);
        list2.add(1.0);
        list2.sort(Double::compareTo);
        assertEquals(list2.size(), 3);
        assertEquals(list2.get(0), 1.0);
        assertEquals(list2.get(1), 2.0);
        assertEquals(list2.get(2), 3.0);

        for (Integer i = 0; i < 1000.0; i++) {
            list2.add(1000.0 * Math.random());
        }
        list2.sort(Double::compareTo);
        for (Integer i = 1; i < 1000.0; i++) {
            assertTrue((list2.get(i-1) < list2.get(i)));
        }
    }
}