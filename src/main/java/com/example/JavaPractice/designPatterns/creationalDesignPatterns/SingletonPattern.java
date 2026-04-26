package com.example.JavaPractice.designPatterns.creationalDesignPatterns;

public class SingletonPattern {
    static class Singleton {
        private static Singleton instance;

        private Singleton() {
        }

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    public static void main(String... args) {
        Singleton singletonInstance = Singleton.getInstance();
        Singleton singletonInstance1 = Singleton.getInstance();

        System.out.println(singletonInstance);
        System.out.println(singletonInstance1);
    }
}
