package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar{

    private int n;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean isEmpty = true;


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (!isEmpty) {
                condition.await();
            }
            printFoo.run();
            isEmpty = false;
            condition.signal();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            while (isEmpty) {
                condition.await();
            }
            printBar.run();
            isEmpty = true;
            condition.signal();
        }
        lock.unlock();
    }

    //代码测试
    public static void main(String[] args) {
        FooBar fb = new FooBar(30);
        Runnable foo = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable bar = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        //用匿名内部类创建一个线程打印foo
        new Thread() {
            public void run() {
                try {
                    fb.foo(foo);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();

        //用匿名内部类创建一个线程打印bar
        new Thread() {
            public void run() {
                try {
                    fb.bar(bar);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
