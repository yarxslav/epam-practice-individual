package com.epam.task;

public class Main {
    public static void main(String[] args) {
        UnremovableList<Integer> test = new UnremovableList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        for (Integer elem : test) {
            System.out.println(elem);
        }

        System.out.println(test.contains(3));
        System.out.println(test.size());
    }
}
