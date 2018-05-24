package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: 线性表的实现类
 * @Date: 15:18 2018/5/24
 */
public class SequenceList implements List {

    //默认的顺序表的大小
    final int defaultSize = 10;

    //最大长度
    int maxSize;

    //当前长度
    int size;

    //对象数组
    Object[] listArray;

    //默认情况下初始化
    public SequenceList() {
        init(defaultSize);
    }

    //指定大小的情况下
    public SequenceList(int size) {
        init(size);
    }

    //顺序表的初始化方法
    private void init(int size) {
        maxSize = size;
        this.size = 0;
        listArray = new Object[size];
    }


    public int size() {
        //返回当前长度
        return size;
    }

    public boolean isEmpty() {
        //当前长度大于0不为空，否则为空
        return size > 0 ? false : true;
    }

    public void insert(int index, Object o) throws Exception {
        //如果当前长度和最大长度一致，则表满了，无法插入
        if (size == maxSize) {
            return;
        }
        //如果不在范围内，直接return结束执行
        if (index < 0 || index > size) {   //此处index > size
            return;
        }
        for (int i = size - 1; i >= index; i--) {
            listArray[i + 1] = listArray[i];
        }
        listArray[index] = o;
        size++;
    }

    public void delete(int index) throws Exception {
        //如果为空无法删除
        if (isEmpty()) {
            return;
        }
        //如果不在范围内，直接return结束执行
        if (index < 0 || index > size - 1) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            listArray[i] = listArray[i + 1];
        }
        size--;
    }

    public Object get(int index) throws Exception {
        //如果不在范围内，返回null
        if (index < 0 || index > size - 1) {
            return null;
        }
        return listArray[index];
    }

    public static void main(String[] args) {

        SequenceList list = new SequenceList(20);
        try {
            list.insert(0, 0);
            list.insert(1, 1);
            for (int i = 0; i < list.size; i++) {
                System.out.println(list.get(i));
            }
            System.out.println("========================");
            list.delete(0);
            for (int i = 0; i < list.size; i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
