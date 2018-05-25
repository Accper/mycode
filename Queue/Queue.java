package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: 队列的接口
 * @Date: 10:48 2018/5/25
 */
public interface Queue {

    // 清空队列
    public void clear();

    // 判断队列是否为空
    public boolean isEmpty();

    // 队列的长度
    public int length();

    // 差人元素到对列中
    public void offer(Object x);

    // 删除队首元素
    public Object pop();

    // 取队首元素并返回
    public Object peek();

    // 显示队列中的元素
    public void display();
}
