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

7:lock 比   synchronized 操作灵活 , 提供读写锁  多个线程操作的话不会阻塞读锁 , 只会阻塞锁





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
