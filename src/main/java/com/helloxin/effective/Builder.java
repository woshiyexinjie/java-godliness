package com.helloxin.effective;


//如果是这样写起来 比较麻烦 d
public class Builder<T> {
    private T foo;
    private final String bar;

    private Builder(T foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public static <T> ExampleBuilder<T> builder() {
        return new ExampleBuilder<T>();
    }

    public static class ExampleBuilder<T> {
        private T foo;
        private String bar;

        private ExampleBuilder() {}

        public ExampleBuilder foo(T foo) {
            this.foo = foo;
            return this;
        }

        public ExampleBuilder bar(String bar) {
            this.bar = bar;
            return this;
        }

        @java.lang.Override
        public String toString() {
            return "ExampleBuilder(foo = " + foo + ", bar = " + bar + ")";
        }

        public Builder build() {
            return new Builder(foo, bar);
        }
    }

    public static void main(String[] args) {

        Builder.builder().foo(1).bar("test").build();


    }
}
