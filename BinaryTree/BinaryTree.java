package thinking.tree;

import java.util.Stack;

/**
 * @Author: taoye
 * @Description: 二叉树的类
 * @Date: 13:59 2018/5/25
 */
public class BinaryTree {

    // 二叉树的根节点
    private Node root;

    // 初始化二叉树
    public BinaryTree(Integer value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    // 查找 二叉排序树，二叉查找树，二叉搜索树
    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
    }

    // 向二叉树中插入一个节点
    public String insert(int value) {
        String message = null;
        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.leftChild = null;
            root.rightChild = null;
            message = "成功在二叉树中插入一个节点";
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value == current.value) {
                    message = "已经存在相同的值了，无法继续插入";
                    break;
                } else if (value < current.value) {
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                }
            }
        }
        return message;
    }

    // 中序遍历递归操作
    public void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.println(node.value);
        inOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历非递归操作
     * 1,对与任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空
     * 2,如果左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3,重复1，2步操作，直到current为空，且栈内节点为空
     */
    public void inOrderByStack() {
        System.out.println("中序遍历非递归的实现方式：");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.rightChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.println(current.value);
                current = current.rightChild;
            }
        }
    }

    // 前序遍历
    public void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 前序遍历非递归操作
     * 1,对于任意节点current，若该节点不为空，则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作置到current为空
     * 2,若右子树为空，栈顶节点出栈，将该节点的右子树置为current
     * 3,重复1，2步操作，直到current为空且栈内节点为空
     */
    public void preOrderByStack() {
        System.out.println("二叉树前序遍历的非递归实现方式：");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                System.out.println(current.value);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.rightChild;
            }
        }
    }

    // 后序遍历
    public void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.value);
    }

    /**
     * 后序遍历非递归操作
     * 1,对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空
     * 2,若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3,重复1，2操作，直到current为空且栈内节点为空
     */
    public void postOrderByStack() {
        System.out.println("二叉树的后序遍历的非递归实现方式：");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.peek().rightChild;
                if (current == null || current == preNode) {
                    current = stack.pop();
                    System.out.println(current.value);
                    preNode = current;
                    current = null;
                }
            }
        }
    }

    // 得到最小(大)值
    public int getMinValue() {
        Node current = root;
        while (true) {
            if (current.leftChild == null) {
                return current.value;
            }
            current = current.leftChild;
        }
    }

    // 删除
    public boolean delete(int value) {

        // 需要删除的节点
        Node current = root;
        // 需要删除的节点的父节点
        Node parent = null;
        // 需要删除的节点是否为父节点的左子树
        boolean isLeftChild = true;

        while (true) {
            if (value == current.value) {
                break;
            } else if (value < current.value) {
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }
            // 找不到需要删除的节点，直接返回false
            if (current == null) {
                return false;
            }
        }

        // 1,需要删除的节点为叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            //如果该叶节点为根节点，将根节点置为null
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {  // 如果该叶节点是父节点的左子节点，将父节点的左子节点置为null
                    parent.leftChild = null;
                } else {    // 如果该叶节点是父节点的右子节点，将父节点的右子节点置为null
                    parent.rightChild = null;
                }
            }
        } else if (current.rightChild == null) {     // 2,需要删除的节点有一个子节点，且该子节点为左子树
            // 如果该节点为根节点，将根节点的左子节点变为根节点
            if (current == root) {
                root = current.leftChild;
            } else {
                // 如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    // 如果该节点是父节点的右子节点，将该节点的左子节点的右子节点
                    parent.rightChild = current.leftChild;
                }
            }
        } else if (current.leftChild == null) {      // 需要删除的节点有一个子节点，且该节点为右子节点
            // 如果该节点为根节点，将跟节点的右子节点变为根节点
            if (current == root) {
                root = current.rightChild;
            } else {
                // 如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            }
        } else {    // 3,需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            }else {
                // 如果该节点是父节点的左子节点，将该节点的后续节点变为父节点的左子节点
                if (isLeftChild){
                    parent.leftChild = successor;
                }else {
                    // 如果该节点是父节点的右子节点，将该节点的后续节点变为父节点的右子节点
                    parent.rightChild = successor;
                }
            }


        }

        current = null;
        return true;
    }

    /**
     * 得到后继节点，即删除节点的左后代
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = null;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        //如果后继节点不是删除节点的右子节点时，
        if (successor != delNode.rightChild) {
            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.leftChild = successor.rightChild;
            //并将删除节点的右子节点指向后继结点的右子节点
            successor.rightChild = delNode.rightChild;
        }
        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.leftChild = delNode.leftChild;

        return successor;
    }

    // 测试
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        bt.insert(999);
        System.out.println("==========中序遍历==========");
        bt.inOrderTraverse(bt.root);
        System.out.println("==========先序遍历==========");
        bt.preOrderTraverse(bt.root);
        System.out.println("==========后续遍历==========");
        bt.postOrderTraverse(bt.root);
        System.out.println(bt.findKey(32));
        System.out.println(bt.findKey(81));
        System.out.println("最小值:" + bt.getMinValue());
//      bt.delete(32);      //删除叶子节点
//      bt.delete(50);      //删除只有一个左子节点的节点
//      bt.delete(248);      //删除只有一个右子节点的节点
//      bt.delete(248);      //删除只有一个右子节点的节点
//      bt.delete(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
//      bt.delete(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点
        bt.delete(52);       //删除有两个子节点的节点，且删除节点为根节点
        System.out.println("==========删除之后的中序遍历结果==========");
        bt.inOrderTraverse(bt.root);
    }
}