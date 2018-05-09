# concurrent
有关java并发代码

1:JAVA原子类
java.util.concurrent.atomic

例: AtomicInteger 实现
保证对 AtomicInteger 类型变量的增加和减少操作是原子性的，不会出现多个线程下的数据不一致问题。
private volatile int value;
volatile 修饰的 value 变量，保证了变量的可见性。

CAS算法
CAS（Compare-And-Swap）算法保证数据操作的原子性。

CAS 算法是硬件对于并发操作共享数据的支持。

CAS 包含了三个操作数：
　　内存值 V
　　预估值 A
　　更新值 B

当且仅当 V == A 时，V 将被赋值为 B，否则循环着不断进行判断 V 与 A 是否相等。


2:Thread.UncaughtExceptionHandler 用于捕捉线程运行中的未知异常

3:线程之间变量传递 ThreadLocal InheritableThreadLocal 

4:java.lang.Timer 适用于大规模的并发调度任务 定时任务应该可以很快执行完成

5:java.util.current.CountDownLatch  使用await方法让主线程等待计数器归零,使用countDown让计数器减一

6:线程池 shutdown后无法提交新的线程 , awaitTermination后续是可以继续提交任务的

7:线程池参数

     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
        ------核心线程数:即使没有任务执行也一直运行在线程池的线程数量,除非设置了核心线程的超时时间
     * @param maximumPoolSize the maximum number of threads to allow in the
     *        pool
        ------最大线程数:线程池所允许存在的最大线程数目,(当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务 , 但是新建的线程不能超过最大值)
     * @param keepAliveTime when the number of threads is greater than
     *        the core, this is the maximum time that excess idle threads
     *        will wait for new tasks before terminating.
        ------超出核心线程数量的空闲现场的存活时间
     * @param unit the time unit for the {@code keepAliveTime} argument
        ------时间单位
     * @param workQueue the queue to use for holding tasks before they are
     *        executed.  This queue will hold only the {@code Runnable}
     *        tasks submitted by the {@code execute} method.
      --------用于保存待执行线程的队列,可以为这个队列设置大小
     * @param threadFactory the factory to use when the executor
     *        creates a new thread
     ---------用来创建线程的线程工厂
     * @param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     ---------用于处理线程添加失败的异常
             - AbortPolicy 丢弃任务，抛运行时异常
             - CallerRunsPolicy 执行任务
             - DiscardPolicy 忽视，什么都不会发生
             - DiscardOldestPolicy 从队列中踢出最先进入队列（最后一个执行）的任务

8:lock 比   synchronized 操作灵活 , 提供读写锁  多个线程操作的话不会阻塞读锁 , 只会阻塞锁

9:BlockingQueue
  LinkedBlockingQueue  基于链表实现
  ArrayBlockingQueue   基于数组实现




----------------------------------------
1. synchronized实现可见性 , 原子性

synchronized除了常见的原子性，还实现了可见性。这是因为：

1) 线程解锁前，必须把共享变量的最新值刷新到主内存中去；

2) 线程加锁时，将清空工作内存中的共享变量的值，使用到共享变量时，从主内存中获取最新的共享变量值（加锁和解锁需要同一把锁）

 

2. volatile实现可见性

通过内存屏障和禁止重排序优化来实现可见性。

1) 对共享变量进行写操作后，加入一条store屏障指令，强制将共享变量的值刷新到主内存；

2) 对共享变量进行读操作前，加入一条load屏障指令，强制从主内存中将最新值刷新到工作内存；

 

4.volatile不能保证原子性

一个比较典型的例子是++运算符。

在下面的代码中，一共创建了1000个线程，预期应该是加了1000次，那么number的值应该是1000，实际上有可能并不是。

这是因为，++运算符并不是一次操作。以number++为例，可以看作是，先从主内存中取出number的值，然后将其加1，刷新工作内存，刷新主内存，这么几个步骤。

而volatile并不能保证原子性，这就意味着，有可能出现这种情况：

1)线程A获取到主内存的number的值（假设为10）到工作内存

2)此时CPU调度，A暂停，线程B开始执行，同样从主内存中获取到number为10，number++后，number为11，刷新到主内存

3)线程A继续执行number++，它的工作内存中number为10，执行完毕刷新到主内存，此时，number的值为11. 也就是说，AB两个线程同时进行了+1操作，但最终的结果，只加了1
