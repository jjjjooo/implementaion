package basic_technique.정렬.나이순_10814;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Person[] people = new Person[N];
        for(int i =0; i < N; i++){
            int age = sc.nextInt();
            String name = sc.next();
            people[i] = new Person(i, age, name);
        }
        Arrays.sort(people);
        for(int i = 0; i < N; i++){
            System.out.println(people[i].age + " " + people[i].name);
        }
    }

    public static class Person implements Comparable<Person>{
        int id;
        int age;
        String name;

        public Person(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age == o.age) return this.id - o.id;
            return this.age - o.age;
        }
    }
}
