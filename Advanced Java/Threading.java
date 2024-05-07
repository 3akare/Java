//Multi-threading
//How to keep a variable safe from race condition use the synchronized keyword

class Counter {
    private int count = 0;

    public synchronized void increment() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}

class A extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Hey!");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Hello there!");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class X implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Y implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello there!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threading {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable x = () -> {
            for (int i = 0; i < 10; i++)
                counter.increment();
        };
        Runnable y = () -> {
            for (int i = 0; i < 10; i++)
                counter.increment();
            ;
        };

        x.run();
        y.run();

        System.out.println(counter.getCount());
    }
}
