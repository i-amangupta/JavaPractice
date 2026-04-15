package com.example.JavaPractice.oopConcepts;

class MethodOverriding {

    // 1. Basic Overriding (Runtime Polymorphism)
    static class Test1 {
        static class Parent {
            void show() { System.out.println("Parent"); }
        }
        static class Child extends Parent {
            @Override
            void show() { System.out.println("Child"); }
        }

        static void run() {
            Parent p = new Child();
            p.show(); // Child
        }
    }

    // 2. Static Methods (Method Hiding, NOT overriding)
    static class Test2 {
        static class Parent {
            static void show() { System.out.println("Parent"); }
        }
        static class Child extends Parent {
            static void show() { System.out.println("Child"); }
        }

        static void run() {
            Parent p = new Child();
            p.show(); // Parent
        }
    }

    // 3. Final Method (Cannot Override)
    static class Test3 {
        static class Parent {
            final void show() { }
        }
        static class Child extends Parent {
            // void show() {} // Compilation Error
        }
    }

    // 4. Private Method (Not Visible, Not Overridden)
    static class Test4 {
        static class Parent {
            private void show() { System.out.println("Parent"); }
        }
        static class Child extends Parent {
            void show() { System.out.println("Child"); }
        }

        static void run() {
            Parent p = new Child();
            // p.show(); // Not accessible
            new Test4.Child().show(); // Child
        }
    }

    // 5. Return Type Covariance
    static class Test5 {
        static class Parent {
            Number get() { return 10; }
        }
        static class Child extends Parent {
            @Override
            Integer get() { return 20; }
        }

        static void run() {
            Parent p = new Child();
            System.out.println(p.get()); // 20
        }
    }

    // 6. Exception Handling Rule
    static class Test6 {
        static class Parent {
            void show() throws Exception {}
        }
        static class Child extends Parent {
            @Override
            void show() {} // narrower (no exception)
        }
    }

    // 7. Checked Exception Violation
    static class Test7 {
        static class Parent {
            void show() {}
        }
        static class Child extends Parent {
            // void show() throws Exception {} // Compilation Error
        }
    }

    // 8. Access Modifier Rule
    static class Test8 {
        static class Parent {
            protected void show() {}
        }
        static class Child extends Parent {
            @Override
            public void show() {} // can increase visibility
        }
    }

    // 9. Cannot Reduce Visibility
    static class Test9 {
        static class Parent {
            public void show() {}
        }
        static class Child extends Parent {
            // protected void show() {} // Compilation Error
        }
    }

    // 10. Constructor (Not Overridden)
    static class Test10 {
        static class Parent {
            Parent() { System.out.println("Parent"); }
        }
        static class Child extends Parent {
            Child() { System.out.println("Child"); }
        }

        static void run() {
            new Child();
            // Parent
            // Child
        }
    }


    // 11. Method Overloading + Overriding Mix
    static class Test11 {
        static class Parent {
            void show(int i) { System.out.println("Parent int"); }
        }
        static class Child extends Parent {
            void show(int i) { System.out.println("Child int"); }
            void show(double d) { System.out.println("Child double"); }
        }

        static void run() {
            Parent p = new Child();
            p.show(10); // Child int
        }
    }

    public static void main(String[] args) {
        Test1.run();
        Test2.run();
        Test4.run();
        Test5.run();
        Test10.run();
        Test11.run();
    }
}