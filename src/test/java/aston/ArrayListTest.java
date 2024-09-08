package aston;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayListTest {
    @Test
    void add() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1002, list.size());

        ArrayList<Integer> list2 = new ArrayList<>(list);
        assertEquals(list2.size(), list.size());
        assertEquals(list2.get(0), list.get(0));
        assertEquals(list2.get(1), list.get(1));

        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ArrayList<Integer> list3 = new ArrayList<>(arr);
        assertEquals(arr[0], list3.get(0));
        assertEquals(arr[1], list3.get(1));

        ArrayList<Integer> list4 = new ArrayList<>(300);
        assertEquals(300, list4.cap());
    }

    @Test
    void testAdd() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(0,2.0);
        assertEquals(2, list.size());
        assertEquals(2.0, list.get(0));
        assertEquals(1.0, list.get(1));
    }

    @Test
    void replace() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        assertEquals("1", list.get(0));
        list.replace(0, "13");
        assertEquals("13", list.get(0));

    }

    @Test
    void get() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        assertEquals("1", list.get(0));
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(1);});
        ArrayList<Integer> list2 = new ArrayList<>();
        assertThrowsExactly(IllegalArgumentException.class, () -> {list2.get(0);});

    }

    @Test
    void remove() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        assertEquals("1", list.get(0));
        list.remove(0);
        assertEquals( 0, list.size());
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(0);});
    }

    @Test
    void removeALL() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals(3, list.size());
        list.removeAll();
        assertEquals(0, list.size());
        assertThrowsExactly(IllegalArgumentException.class, () -> {list.get(0);});
    }

    @Test
    void size() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        assertEquals( 1, list.size());
        list.add("2");
        assertEquals(2, list.size());
    }
    @Test
    void sort() {
        ArrayList<String> list = new ArrayList<>();
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        list.sort(String::compareTo);
        assertEquals(list.size(), 5);
        assertEquals("1", list.get(0) );
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
        assertEquals("5", list.get(4));

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(3.0);
        list2.add(2.0);
        list2.add(1.0);
        list2.sort(Double::compareTo);
        assertEquals(3, list2.size());
        assertEquals(1.0, list2.get(0));
        assertEquals(2.0, list2.get(1));
        assertEquals(3.0, list2.get(2));

        for (int i = 0; i < 1000; i++) {
            list2.add(1000.0 * Math.random());
        }
        list2.sort(Double::compareTo);
        for (int i = 1; i < 1000; i++) {
            assertTrue((list2.get(i-1) <= list2.get(i)));
        }
    }
}