package top.wsure.leetcode.question;

import java.util.PriorityQueue;

public class Solution295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(6);
//        medianFinder.addNum(5);
        medianFinder.addNum(1);
//        medianFinder.addNum(4);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}

class MedianFinder {

    private final PriorityQueue<Integer> lQueue = new PriorityQueue<>((a,b) ->b-a);
    private final PriorityQueue<Integer> rQueue = new PriorityQueue<>((a,b) ->a-b);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(lQueue.size() == rQueue.size()) {
            if(rQueue.size() == 0 || num <= rQueue.peek()){
                lQueue.offer(num);
            } else {
                lQueue.offer(rQueue.poll());
                rQueue.offer(num);
            }
        }
        else {
            if(lQueue.peek() <= num){
                rQueue.offer(num);
            } else {
                rQueue.offer(lQueue.poll());
                lQueue.offer(num);
            }
        }
    }

    public double findMedian() {
        if(lQueue.size() == 0 && rQueue.size() == 0) return 0;
        else if(lQueue.size() == rQueue.size()) return (double) (lQueue.peek() + rQueue.peek()) / 2.0;
        else return (double) lQueue.peek();
    }
}