package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/9 10:25
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Thread> threads=job(Thread.currentThread().getId());

                    //让所有子线程执行完
                    for(Thread td:threads){
                        try {
                            td.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程"+Thread.currentThread().getId()+"执行完成");
                }
            }).start();
        }
        System.out.println("main 线程"+Thread.currentThread().getId());
    }

    public static List<Thread> job (long id){
        List<Thread> list =new ArrayList<>();
        for(int j=0;j<5;j++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    //让线程号为12 的子线程都休眠1毫秒。一试差别

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
            list.add(thread);
            thread.start();
        }
        //arraylist 是线程不安全的。所以使用Collections.synchronizedList方法确保list线程安全，不建议使用vertor,vertor性能不高，属于Java保留方法了，早期使用
        return Collections.synchronizedList(list);
    }


}
