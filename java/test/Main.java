package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        System.out.println(i);
        i.incrementAndGet();
    }

}
