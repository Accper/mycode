package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: Node节点
 * @Date: 16:26 2018/5/24
 */
public class Node {

    //Node节点的数据
    public Object data;
    //Node节点的下一个节点
    public Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
