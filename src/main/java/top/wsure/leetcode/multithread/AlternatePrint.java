package top.wsure.leetcode.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * FileName: AlternatePrint
 * Author:   wsure
 * Date:     2021/6/29 8:30 下午
 * Description:交替打印
 */
public class AlternatePrint {
    int i = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Thread thread1 = new Thread( () -> {
        while (i < 100){
        reentrantLock.lock();
            if(i%2 == 0){
                System.out.println("thread1: "+(i++));
            }
        reentrantLock.unlock();
        }
    });
    Thread thread2 = new Thread( () -> {
        while (i < 100){
        reentrantLock.lock();
            if(i%2 == 1){
                System.out.println("thread2: "+(i++));
            }
        reentrantLock.unlock();
        }
    });

    public static void main(String[] args) {
        AlternatePrint a = new AlternatePrint();
        a.thread1.start();
        a.thread2.start();
    }

    Runnable a = () -> {
        int a = 1;
        int b = 2;

    };

    Thread aaa = new Thread(a);

}
