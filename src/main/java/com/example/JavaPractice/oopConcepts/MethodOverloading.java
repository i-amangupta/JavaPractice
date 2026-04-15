package com.example.JavaPractice.oopConcepts;


public class MethodOverloading {

    // 1. Exact vs Widening
    static class Test1 {
        void method(int i) { System.out.println("int"); }
        void method(long l) { System.out.println("long"); }

        static void run() {
            new Test1().method(10); // int
        }
    }

    // 2. Widening vs Boxing
    static class Test2 {
        void method(long l) { System.out.println("long"); }
        void method(Integer i) { System.out.println("Integer"); }

        static void run() {
            new Test2().method(10); // long
        }
    }

    // 3. Boxing vs Varargs
    static class Test3 {
        void method(Integer i) { System.out.println("Integer"); }
        void method(int... i) { System.out.println("varargs"); }

        static void run() {
            new Test3().method(10); // Integer
        }
    }

    // 4. Widening + Boxing not allowed
    static class Test4 {
        void method(Long l) { System.out.println("Long"); }
        void method(int... i) { System.out.println("varargs"); }

        static void run() {
            new Test4().method(10); // varargs
        }
    }

    // 5. Null - most specific
    static class Test5 {
        void method(String s) { System.out.println("String"); }
        void method(Object s) { System.out.println("Object"); }

        static void run() {
            new Test5().method(null); // String
        }
    }

    // 6. Null ambiguity
    static class Test6 {
        void method(String s) {}
        void method(Integer i) {}

        static void run() {
            // new Test6().method(null); // Compilation Error
        }
    }

    // 7. Reference type matters
    static class Parent {}
    static class Child extends Parent {}

    static class Test7 {
        void method(Parent p) { System.out.println("Parent"); }
        void method(Child c) { System.out.println("Child"); }

        static void run() {
            Parent p = new Child();
            new Test7().method(p); // Parent
        }
    }

    // 8. Varargs vs Exact
    static class Test8 {
        void method(int i, int j) { System.out.println("two int"); }
        void method(int... i) { System.out.println("varargs"); }

        static void run() {
            new Test8().method(10, 20); // two int
        }
    }

    // 9. Array vs Varargs
    static class Test9 {
        void method(int[] arr) { System.out.println("array"); }
        // void method(int... arr) { System.out.println("varargs"); }
        // Results in compilation error because both methods resolves to the same signature

        static void run() {
            int[] a = {1,2,3};
            // new Test9().method(a);
        }
    }

    // 10. Object vs String
    static class Test10 {
        void method(Object o) { System.out.println("Object"); }
        void method(String s) { System.out.println("String"); }

        static void run() {
            new Test10().method("hello"); // String
        }
    }

    // 11. Mixed ambiguity
    static class Test11 {
        void method(int i, double d) {}
        void method(double d, int i) {}

        static void run() {
            // new Test11().method(10, 10); // Compilation Error
        }
    }

    // 12. Boxing vs Object
    static class Test12 {
        void method(Object o) { System.out.println("Object"); }
        void method(Integer i) { System.out.println("Integer"); }

        static void run() {
            new Test12().method(10); // Integer
        }
    }

    public static void main(String[] args) {
        Test1.run();
        Test2.run();
        Test3.run();
        Test4.run();
        Test5.run();
        Test7.run();
        Test8.run();
        Test10.run();
        Test12.run();
    }
}