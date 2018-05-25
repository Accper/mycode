package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: 链表类
 * @Date: 16:34 2018/5/24
 */
public class LinkedList implements List {
    //头节点
    public Node head;

    //初始化链表的头节点
    public LinkedList() {
        head = new Node();
    }

    //在链表的尾部插入一个节点
    public void create(Object x) {
        Node p = new Node(x);// 实例化一个节点
        Node pNode = head;
        while (pNode.next != null) {
            pNode = pNode.next;
        }
        pNode.next = p;
    }

    //链表的长度
    public int size() {
        Node pNode = head;
        int size = 0;
        while (pNode != null) {
            pNode = pNode.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        //如果链表的长度为1就是只有一个头节点，链表即为空，否则不为空
        return size() == 1 ? true : false;
    }

    //往某个位置上面新增节点
    public void insert(int index, Object o) throws Exception {
        //index不在范围内
        if (index < 1 || index > size()) {
            return;
        }
        //需要插入到链表的节点
        Node insNode = new Node(o);
        Node pNode = head;
        while (pNode != null && index > 1) {
            pNode = pNode.next;
            index--;
        }
        insNode.next = pNode.next;
        pNode.next = insNode;
    }

    //删除链表中固定位置上面的节点
    public void delete(int index) throws Exception {
        //如果链表为空，不能删除
        if (isEmpty()) {
            return;
        }
        //index不在范围内
        if (index < 1 || index > size()) {
            return;
        }
        Node pNode = head;
        while (pNode != null && index > 1) {
            pNode = pNode.next;
            index--;
        }
        Node delNode = pNode.next;
        pNode.next = delNode.next;
    }

    //查询链表固定位置上的元素
    public Object get(int index) throws Exception {
        //index不在范围内
        if (index < 1 || index > size()) {
            return null;
        }
        int cout = 0;
        Node pNode = head;
        while (pNode != null && cout != index) {
            pNode = pNode.next;
            cout++;
        }
        return pNode.data;
    }

    //显示链表的内容
    public void display() {
        Node pNode = head.next;
        while (pNode != null) {
            System.out.println(pNode.data);
            pNode = pNode.next;
        }
    }

    //测试
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        System.out.println("==========初始化=========");
        linkedList.create(0);
        linkedList.create(1);
        linkedList.create(2);
        linkedList.display();
        System.out.println("========================");
        System.out.println("链表的长度"+linkedList.size());
        System.out.println("第1个位置上的元素："+linkedList.get(1));
        System.out.println("链表是否为空："+linkedList.isEmpty());
        System.out.println("==========删除==========");
        linkedList.delete(1);
        linkedList.display();
        System.out.println("=========插入===========");
        linkedList.insert(1,12);
        linkedList.insert(4,12);
        linkedList.display();
    }
}
