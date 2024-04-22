public class Main {
    public static void main(String[] args) {

        ThreadLocalState.threadData.get().put("name",Thread.currentThread().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadLocalState.threadData.get().put("name",Thread.currentThread().getName());
                    Thread.sleep(5000);
                    ThreadLocalState.threadData.get().forEach((key,value) -> {
                        System.out.println(key + " -> " + value);
                    });
                    ThreadLocalState.threadData.remove();
                } catch(InterruptedException ie){

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadLocalState.threadData.get().put("name",Thread.currentThread().getName());
                    Thread.sleep(5000);
                    ThreadLocalState.threadData.get().forEach((key,value) -> {
                        System.out.println(key + " -> " + value);
                    });
                    ThreadLocalState.threadData.remove();

                } catch(InterruptedException ie){

                }
            }
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException ie){

        }
        ThreadLocalState.threadData.get().forEach((key,value) -> {
            System.out.println(key + " -> " + value);
        });
        ThreadLocalState.threadData.remove();


    }
}