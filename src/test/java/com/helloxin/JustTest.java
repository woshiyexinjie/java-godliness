package com.helloxin;

/**
 * Created by yebanxian on 2024/1/5.
 */
public class JustTest {

    volatile double l;

    public void doTest(int nLoops) {

        long then = System.currentTimeMillis();
        for (int i = 0; i < nLoops; i++) {
            l = fibImpl1(10);
        }
        long now = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (now - then) + " num=" + l);
    }

    private double fibImpl1(int n) {
        if (n < 0) throw new IllegalArgumentException("Must be > 0");
        if (n == 0)
            return 0d;
        if (n == 1)
            return 1d;
        double d = fibImpl1(n - 2) + fibImpl1(n - 1);
        if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
        return d;
    }

    public static void main(String[] args) {
        JustTest justTest = new JustTest();
        justTest.doTest(100);
    }
}
