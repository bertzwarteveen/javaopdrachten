package org.example.h7.h8;

public class Person {
    private String name;

    public Person(String name, int age) {
        this(name, age, Gender.UNKNOWN);
    }
    public Person(String name, int age, Gender gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void haveBirthday() {
        age++;
    }

    public static String universalRights() {
        return "All humans are created equal.";
    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private Gender gender;

//    @Override
//    public void finalize() throws InterruptedException {
//        Thread.sleep(100000);
//
//    }
    @Override
    public String toString() {
        return name + " (" + age + ") " + "is " + gender;
    }

    @Override
    public int hashCode() {
        return age * name.hashCode() * gender.hashCode();
    }
}
