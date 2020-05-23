package java.util.concurrent.locks;

/**
 * Created by xuzhiqiang
 * on 2018/3/10
 * ClassDescription：
 *
 * A synchronizer that may be exclusively owned by a thread.
 * 一个同步器只能一个线程拥有
 *
 * This class provides a basis for creating locks and related synchronizers
 * that may entail a notion of ownership.
 * 这个类提供了创建锁和相关同步器的基础，这些同步器可能包含所有权的概念。
 *
 * The {@code AbstractOwnableSynchronizer} class itself does not manage or
 * use this information. However, subclasses and tools may use
 * appropriately maintained values to help control and monitor access
 * and provide diagnostics.
 *
 * AbstractOwnableSynchronizer类本身不管理或使用此信息。
 * 但是，子类和工具可以使用适当的维护值来帮助控制和监视访问并提供诊断。
 *
 * 地址：https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/AbstractOwnableSynchronizer.html
 */
public abstract class AbstractOwnableSynchronizer
    implements java.io.Serializable {

    /** Use serial ID even though all fields transient. */
    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * Empty constructor for use by subclasses.
     */
    protected AbstractOwnableSynchronizer() { }

    /**
     * The current owner of exclusive mode synchronization.
     */
    private transient Thread exclusiveOwnerThread;

    /**
     * Sets the thread that currently owns exclusive access.
     * A {@code null} argument indicates that no thread owns access.
     * This method does not otherwise impose any synchronization or
     * {@code volatile} field accesses.
     * @param thread the owner thread
     */
    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    /**
     * Returns the thread last set by {@code setExclusiveOwnerThread},
     * or {@code null} if never set.  This method does not otherwise
     * impose any synchronization or {@code volatile} field accesses.
     * @return the owner thread
     */
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
