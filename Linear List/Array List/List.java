package thinking.algorithm;

/**
 * @Author: taoye
 * @Description: 线性表接口
 * @Date: 15:13 2018/5/24
 */
public interface List<T> {

    //获取线性表长度
    public int size();

    //判断线性表是否为空
    public boolean isEmpty();

    //插入元素
    public void insert(int index, T t) throws Exception;

    //删除元素
    public void delete(int index) throws Exception;

    //获取指定位置的元素
    public T get(int index) throws Exception;

}
