package org.wq.basic.memory;

public class Main {

    static ThreadLocal<String> tl = new ThreadLocal<>();
    public static void main(String[] args) {

            int[] i= {0};

            for(int t=0; t<10; t++)
            {
                new Thread(new Runnable() {
                    public void run() {
                        tl.set("a");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tl.set("b");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(tl.get());
                    }
                }).start();
            }

    }
}
