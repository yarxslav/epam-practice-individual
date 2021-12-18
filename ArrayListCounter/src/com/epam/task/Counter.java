package com.epam.task;

import java.util.*;

public class Counter {

//    public static String countDuplicates(ArrayList<Integer> list) {
//        StringBuilder sb = new StringBuilder();
//        ArrayList<Integer> checked = new ArrayList<>();
//
//        Collections.sort(list);
//
//        for (Integer elem : list) {
//            if (!checked.contains(elem)) {
//                int count = 0;
//                for (Integer element : list) {
//                    if (elem == element) {
//                        count++;
//                    }
//                }
//                checked.add(elem);
//                sb.append(elem + " - " + count + "\n");
//            } else {
//                continue;
//            }
//        }
//
//        return sb.toString();
//    }


    public static String countDuplicates(ArrayList<Integer> list){
        StringBuilder result = new StringBuilder();
        ArrayList<Integer> checked = new ArrayList<>();

        for (Integer element : list) {
            if(!checked.contains(element)) {
                result.append(element)
                        .append(" - ")
                        .append(Collections.frequency(list, element))
                        .append("\n");
                checked.add(element);
            }
        }

        return result.toString();
    }
}
