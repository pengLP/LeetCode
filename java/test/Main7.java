package test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main7 {

    private Object object = new Object();

    private void A() {
        synchronized (object) {
            System.out.println("123");
        }
    }

    private void B() {
        synchronized (object) {
            System.out.println("234");
        }
    }

}
