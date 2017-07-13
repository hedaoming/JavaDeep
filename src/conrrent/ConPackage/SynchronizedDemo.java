package conrrent.ConPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ipc on 2017/7/6.
 */
public class SynchronizedDemo {
    public void list(){
        List list = new ArrayList();
        List newList = Collections.synchronizedList(list);
        newList.add(1);
        Collections.synchronizedMap(new HashMap());
    }
    public void blockingQueue() throws InterruptedException {
        BlockingQueue abq = new ArrayBlockingQueue(10);
        abq.put(1);
        abq.take();
        BlockingQueue lbq = new LinkedBlockingQueue();
        lbq.put(2);
        lbq.take();
    }
}
