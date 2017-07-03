package collection;

/**
 * Created by ipc on 2017/5/21.
 * 规定集合的一系列方法
 */
public interface MyCollection<T> {
    boolean flag = false;

    //add the element which is T
    boolean add(T t);

    //remove by index
    boolean remove(int index);

    //update the element by index to new value t
    boolean update(int index,T t);

    /**
     *
     * @param索引
     * @return 值
     */
    T findByIndex(int index);

    /**
     *
     * @param值
     * @return 索引
     */
    int findByValue(T value);
    T[] findAll();
}
