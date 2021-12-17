package com.epam.task;

public class Main {

    public static void main(String [] args){
        Student st = new Student("Tyler", 21, "IA-03");
        Student st1 = new Student("Polina", 18, "VB-21");
        Student st2 = new Student("Tyler", 21, "IA-03");

        System.out.println(st.setName("John"));
        System.out.println(st.setAge(12));
        System.out.println(st);
        System.out.println(st.equals(st1));
        System.out.println(st.equals(st2));
        System.out.println(st2.equals(st));

    }
}
