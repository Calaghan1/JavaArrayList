package aston;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        for (Integer i = 0; i < 1000.0; i++) {
            list.add(1000.0 * Math.random());
        }
        for (Integer i = 0; i < 1000.0; i++) {
            System.out.println(list.get(i));
        }
        list.sort(Double::compareTo);
        for (Integer i = 0; i < 1000.0; i++) {
            System.out.println(list.get(i));
        }
    }
}