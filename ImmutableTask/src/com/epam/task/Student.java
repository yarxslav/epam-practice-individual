package com.epam.task;

import java.util.Objects;

public final class Student {
    private final String name;
    private final int age;
    private final String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public Student setName(String name){
        return new Student(name, this.age, this.group);
    }

    public Student setAge(int age){
        return new Student(this.name, age, this.group);
    }

    public Student setGroup(String group){
        return new Student(this.name, this.age, group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && Objects.equals(getName(), student.getName()) && Objects.equals(getGroup(), student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGroup());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }
}
