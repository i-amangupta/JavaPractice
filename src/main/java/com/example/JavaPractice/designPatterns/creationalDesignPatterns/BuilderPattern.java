package com.example.JavaPractice.designPatterns.creationalDesignPatterns;

public class BuilderPattern {
    static class Employee {
        private int id;
        private String name;

        private Employee(Builder builder) {
            this.id = builder.id;
            this.name = builder.name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name=" + name +
                    '}';
        }

        public static class Builder {
            private int id;
            private String name;

            public Builder id(int id) {
                this.id = id;
                return this;
            }

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Employee build() {
                return new Employee(this);
            }
        }
    }

    public static void main(String... args) {
        Employee emp = new Employee.Builder()
                .id(101)
                .name("Aman")
                .build();
        System.out.print(emp);

    }
}

