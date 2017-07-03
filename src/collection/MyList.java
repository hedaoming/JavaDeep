package collection;

/**
 * Created by ipc on 2017/5/21.
 * 作用：集合类的接口，
 *  规定某些特征：有存储顺序，可以重复
 *  1. 存储顺序：根据存入元素的顺序进行排列
 *      方法①内部维护一个队列，先进先出原则，这样就能保证有存储顺序。存在问题：队列实现类是LinkedList
 *      方法②数组，通过数组的下标来保证顺序
 *      1. 队列、栈、数组关系以及实现
 *  2. 可以重复：不用加compare判断即可实现可重复功能。
 *  3. 泛型：接口需要保证泛型吗？==》查看源码
 */
public interface MyList<T> extends MyCollection<T>{

}
