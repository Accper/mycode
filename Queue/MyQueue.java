package thinking.algorithm;

import java.util.UUID;

/**
 * @Author: taoye
 * @Description: 队列的基本操作
 * @Date: 10:32 2018/5/25
 */
public class MyQueue implements Queue {

    //底层使用数组来实现
    private Object[] array;

    //队头
    private int front;

    //队尾
    private int rear;

    //默认初始化，队列的大小为10
    public MyQueue() {
        array = new Object[10];
        front = 0;
        rear = 0;
    }

    //显示初始化，队列的大小为maxSize
    public MyQueue(int maxSize) {
        array = new Object[maxSize];
        front = 0;
        rear = 0;
    }

    // 清空队列
    public void clear() {
        front = rear = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //队列的长度
    public int length() {
        return rear - front;
    }

    // 向队列中插入元素
    public void offer(Object x) {
        array[rear] = x;
        rear++;
    }

    // 取出队首元素
    public Object pop() {
        return array[front++];
    }

    // 查看队首元素
    public Object peek() {
        return array[front];
    }

    //显示队列中元素
    public void display() {
        int i = front;
        while (i < rear) {
            System.out.println(array[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(20);
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println("=======初始化已完毕=======");
        myQueue.display();
        System.out.println("队列的长度为："+myQueue.length());
        System.out.println("队列是否为空："+myQueue.isEmpty());
        System.out.println("队首元素为："+myQueue.peek());
        System.out.println("========出队操作=======");
        myQueue.pop();
        myQueue.pop();
        myQueue.display();
        System.out.println("===========入队操作=========");
        myQueue.offer(10);
        myQueue.offer(12);
        myQueue.display();
    }
}
