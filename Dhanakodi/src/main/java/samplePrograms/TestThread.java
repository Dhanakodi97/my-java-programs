package samplePrograms;

class SampleDemo implements Runnable { 
    private Thread t;
    private String threadName;

    SampleDemo(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        while (true)
            System.out.println(threadName);
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {
    public static void main(String args[]) {
        SampleDemo demoA = new SampleDemo("A");
        SampleDemo demoB = new SampleDemo("B");
        demoB.start();
        demoA.start();
    }
}