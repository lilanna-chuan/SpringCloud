package thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Solution2
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/9 13:24
 * @Version 1.0
 */
public class Solution2 {

    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ExecutorService threadPool = Executors.newCachedThreadPool();
                    long id=Thread.currentThread().getId();
                    for(int j=0;j<5;j++){
                        threadPool.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if(id==12) {
                                        Thread.sleep(2);
                                    }else{
                                        Thread.sleep(1);
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("父线程"+id+"子线程"+Thread.currentThread().getId()+"执行完成");
                            }
                        });
                    }
                    // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
                    threadPool.shutdown();
                    try {
                        // 请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行
                        // 设置最长等待10秒
                        threadPool.awaitTermination(1000, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程"+Thread.currentThread().getId()+"执行完成");
                }
            }).start();
        }
        System.out.println("main 线程"+Thread.currentThread().getId());
    }
}
