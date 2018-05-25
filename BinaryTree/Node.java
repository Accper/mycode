package thinking.tree;

/**
 * @Author: taoye
 * @Description: 二叉树中的节点
 * @Date: 13:55 2018/5/25
 */
public class Node {

    // 节点的值
    public Integer value;

    // 节点的左孩子
    public Node leftChild;

    // 节点的右孩子
    public Node rightChild;

    public Node(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
