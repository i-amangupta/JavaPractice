package com.example.JavaPractice.strings;

class StringEqualityAndImmutability {

    // 1. String Pool (== vs equals)
    static class Test1 {
        static void run() {
            String a = "hello";
            String b = "hello";

            System.out.println(a == b);       // true (same pool reference)
            System.out.println(a.equals(b)); // true (value)
        }
    }

    // 2. new String() creates new object
    static class Test2 {
        static void run() {
            String a = new String("hello");
            String b = new String("hello");

            System.out.println(a == b);       // false
            System.out.println(a.equals(b)); // true
        }
    }

    // 3. Literal vs new String
    static class Test3 {
        static void run() {
            String a = "hello";
            String b = new String("hello");

            System.out.println(a == b);       // false
            System.out.println(a.equals(b)); // true
        }
    }

    // 4. intern() method
    static class Test4 {
        static void run() {
            String a = new String("hello");
            String b = a.intern();  // creates string in SCP

            System.out.println(a == b); // false
        }
    }

    // 5. Compile-time concatenation
    static class Test5 {
        static void run() {
            String a = "he" + "llo";
            String b = "hello";

            System.out.println(a == b); // true
        }
    }

    // 6. Runtime concatenation
    static class Test6 {
        static void run() {
            String a = "he";
            String b = a + "llo";
            String c = "hello";

            System.out.println(b == c); // false
        }
    }

    // 7. final keyword impact
    static class Test7 {
        static void run() {
            final String a = "he";
            String b = a + "llo";
            String c = "hello";

            System.out.println(b == c); // true
        }
    }

    // 8. equals vs ==
    static class Test8 {
        static void run() {
            String a = "abc";
            String b = new String("abc");

            System.out.println(a == b);       // false
            System.out.println(a.equals(b)); // true
        }
    }

    // 9. StringBuilder comparison
    static class Test9 {
        static void run() {
            StringBuilder sb1 = new StringBuilder("abc");
            StringBuilder sb2 = new StringBuilder("abc");

            System.out.println(sb1 == sb2);         // false
            System.out.println(sb1.equals(sb2));   // false - compares refrence
        }
    }

    // 10. StringBuilder to String
    static class Test10 {
        static void run() {
            StringBuilder sb = new StringBuilder("abc");
            String s = "abc";

            System.out.println(sb.toString().equals(s)); // true
        }
    }

    // 11. Null safe equals
    static class Test11 {
        static void run() {
            String a = null;
            String b = "abc";

            // System.out.println(a.equals(b)); // NullPointerException
            System.out.println("abc".equals(a)); // false
        }
    }

    // 12. Case sensitivity
    static class Test12 {
        static void run() {
            String a = "abc";
            String b = "ABC";

            System.out.println(a.equals(b));           // false
            System.out.println(a.equalsIgnoreCase(b)); // true
        }
    }

    public static void main(String[] args) {
        Test1.run();
        Test2.run();
        Test3.run();
        Test4.run();
        Test5.run();
        Test6.run();
        Test7.run();
        Test8.run();
        Test9.run();
        Test10.run();
        Test11.run();
        Test12.run();
    }
}
