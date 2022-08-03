//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”
//。
//
// 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环
//队列，我们能使用这些空间去存储新的值。
//
// 你的实现应该支持如下操作：
//
//
// MyCircularQueue(k): 构造器，设置队列长度为 k 。
// Front: 从队首获取元素。如果队列为空，返回 -1 。
// Rear: 获取队尾元素。如果队列为空，返回 -1 。
// enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
// deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
// isEmpty(): 检查循环队列是否为空。
// isFull(): 检查循环队列是否已满。
//
//
//
//
// 示例：
//
// MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1);  // 返回 true
//circularQueue.enQueue(2);  // 返回 true
//circularQueue.enQueue(3);  // 返回 true
//circularQueue.enQueue(4);  // 返回 false，队列已满
//circularQueue.Rear();  // 返回 3
//circularQueue.isFull();  // 返回 true
//circularQueue.deQueue();  // 返回 true
//circularQueue.enQueue(4);  // 返回 true
//circularQueue.Rear();  // 返回 4
//
//
//
// 提示：
//
//
// 所有的值都在 0 至 1000 的范围内；
// 操作数将在 1 至 1000 的范围内；
// 请不要使用内置的队列库。
//
//
// Related Topics 设计 队列 数组 链表 👍 362 👎 0

package top.wsure.leetcode.question;

public class Solution622 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(7);
        System.out.println(myCircularQueue.enQueue(0));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.enQueue(6));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());

    }
}
class MyCircularQueue {
    int [] queue;
    int h = 0,t = 0,size = 0;
    public MyCircularQueue(int k) {
        this.queue = new int[Math.max(k,0)];
    }

    public boolean enQueue(int value) {
        if(size == queue.length){
            return false;
        } else {
            size ++;
            if(t >= queue.length) t -= queue.length;
            queue[t] = value;
            t++;
        }
        return true;
    }

    public boolean deQueue() {
        if(size == 0){
            return false;
        } else {
            size --;
            if(h >= queue.length) h -= queue.length;
            h ++ ;
        }
        return true;
    }

    public int Front() {
        return size >0 ? queue[h >= queue.length ? h - queue.length : h ] : -1;
    }

    public int Rear() {
        return size > 0 ? queue[t - 1 < 0 ? t -1 + queue.length : t - 1 ] :  -1 ;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}

/*
> 2022/08/02 19:47:22
Success:
	Runtime:4 ms, faster than 100.00% of Java online submissions.
	Memory Usage:41.9 MB, less than 49.91% of Java online submissions.
 */