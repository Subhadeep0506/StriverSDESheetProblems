class Test {
    public static void main(String[] args) {
        Process A = new Process("A");
        Process B = new Process("B");
        B.start();
        A.start();
    }
}

class Process implements Runnable {
    private Thread t;
    private String threadName;

    public Process(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(threadName);
            try {
                t.sleep(1000);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}