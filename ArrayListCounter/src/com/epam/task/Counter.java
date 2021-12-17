package com.epam.task;

import java.util.*;
import java.util.stream.Collectors;

public class Counter {

    public static String countElements(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> checked = new ArrayList<>();

        Collections.sort(list);

        for (Integer elem : list) {
            if (!checked.contains(elem)) {
                int count = 0;
                for (Integer element : list) {
                    if (elem == element) {
                        count++;
                    }
                }
                checked.add(elem);
                sb.append(elem + " - " + count + "\n");
            } else {
                continue;
            }
        }

        return sb.toString();
    }


//    public static String countElement(ArrayList<Integer> list){
//        Map<String, Long> counts = (Map<String, Long>) list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//
//        return counts.toString();
//    }
}
