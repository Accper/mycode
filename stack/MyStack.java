package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: 栈的基本操作，用数组实现，压栈，弹栈等操作
 * @Date: 10:03 2018/5/25
 */
public class MyStack {

    //底层用数组来实现
    private Object[] array;

    //栈顶的位置
    private int top;

    //默认初始化为10
    public MyStack() {
        array = new Object[10];
        top = -1;
    }

    //显示初始化栈的大小
    public MyStack(int maxSize) {
        array = new Object[maxSize];
        top = -1;
    }

    //栈的大小
    public int size() {
        return top;
    }

    //入栈操作
    public void push(Object obj) {
        if (size() == array.length) {
            System.out.println("栈满了，无法入栈了！！！");
            return;
        }
        array[++top] = obj;
    }

    //出栈操作
    public Object pop() {
        if (size() == -1) {
            System.out.println("栈为空，无法出栈！！！");
            return null;
        }
        return array[top--];
    }

    //显示栈中的内容
    public void display() {
        if (size() == -1) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < top; i++) {
            System.out.print(array[i]+",");
        }
        System.out.print(array[top]+"]");
    }

    //查看栈顶元素
    public Object peak(){
        if (size()==-1){
            System.out.println("栈为空，没有栈顶元素");
            return null;
        }
        return array[top];
    }

    //测试
    public static void main(String[] args) {
        MyStack stack = new MyStack(20);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("=======显示栈中元素========");
        stack.display();
        System.out.println("\n========栈顶元素==========");
        System.out.println(stack.peak());
        System.out.println("==========出栈操作=========");
        stack.pop();
        stack.display();
        System.out.println("\n=======入栈操作========");
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.display();
    }
}
