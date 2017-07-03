package conrrent.ConPackage;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by ipc on 2017/7/1.
 */
public class SampleLock extends AbstractQueuedSynchronizer{
    private static final long serialVersionUID =  -7316320116933187634L;

    protected boolean tryAcquire(int unused){
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    protected boolean tryRelease(int unused){
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock(){
        acquire(1);
    }

    public boolean tryLock(){
        return tryAcquire(1);
    }

    public void unlock(){
        release(1);
    }
}
