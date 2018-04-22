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

