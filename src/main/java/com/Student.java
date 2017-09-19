package com;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private String name;
    private Integer age;
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return name + "'s age is " + String.valueOf(age);
    }

    @Override
    public boolean equals(Object other) {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof Student))
            return false;

        final Student stu = (Student)other;
        if(!getName().equals(stu.getName()))
            return false;
        if(!getAge().equals(stu.getAge()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 29*result + getAge().hashCode();
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set = new HashSet<Student>();
        Student s1 = new Student("ZhangSan", 14);
        Student s2 = new Student("ZhangSan", 13);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        set.add(s1);
        set.add(s2);
        System.out.println(set);
        System.out.println(s1.equals(s2));
	}

}
