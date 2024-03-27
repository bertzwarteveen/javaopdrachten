package org.example.h7.h8;
import  java.lang.reflect.*;
public class Main {
    public static void main(String[] args) {

        Person p = new Person("Jan", 38);
        Person q = p;
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday();
        System.out.println(p.getAge());
        System.out.println(Person.universalRights());
        System.out.println(p.toString());
        System.out.println(p.equals(q));
        System.out.println(p.hashCode());
        p.haveBirthday();
        System.out.println(p.hashCode());

        try {
                Class c = Class.forName(args[0]);
                Method m[] = c.getDeclaredMethods();
                for (int i = 0; i < m.length; i++)
                    System.out.println(m[i].toString());
        }
        catch (Throwable e) {
                System.err.println(e);
        }

    }
}
