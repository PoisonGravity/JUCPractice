package com.example.threadpractice.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {

        User user01 = new User(12, "akk", "male");
        User user02 = new User(14, "ckokok", "male");
        User user03 = new User(13, "osdsdkk", "female");
        User user04 = new User(16, "dddd", "male");
        User user05 = new User(22, "oksddk", "female");

        List<User> users = Arrays.asList(user01, user02, user03, user04, user05);
        users.stream()
                .filter((u)->{ return u.getAge()%2 == 0;})
                .filter(u->{return u.getGender().equals("male");})
                .map((u)->{return u.getName().toUpperCase();})
                .sorted((u1,u2)->{return u2.compareTo(u1);})
                .limit(1)
                .forEach(System.out::println);

    }
}



class User {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private int age;
    private String name;
    private String gender;

    public User(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
}
