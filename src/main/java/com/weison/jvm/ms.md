## java8
新特性

## os

## 集合
- hashMap 和 concurrentHashMap （OK）
- ArrayList LinkList （OK） 初始化 扩容

快速失败

## 线程
sleep() wait() join yield interrupted
线程池 （x） -
参数 拒绝策略 队列长度 阻塞队列
jstack
拆文件算法  conuntLantch
## 锁
synchronized
volatile
ReentrantLock ReentrantReadWriteLock
重进入
aqs中cas的应用aqs队列
conuntLantch cyclicbar semphore 基本OK

## jvm （基本OK）
方法区 ： 常量 静态变量 类元信息
从多线程交互的角度解读程序计数器(线程私有)的作用
局部变量表 + 操作数栈(运算过程的临时空间)的压栈出栈 ： 描述 int i= 1+a; 在栈针中的运行过程
动态链接：方法区对应方法的符号链接(地址)
类加载器类别

## gc
为什么 eden:s0:s1 8:1:1
引用计数法的弊端
可达性分析 GCRoots(Gc Root Set 树形数据结构) --> 在 (java栈&本地方法栈)栈帧 方法区 -查找-> 局部标量、静态变量 -向下查找-> 是否有引用指向
分代年龄增加过程
分代年龄存在 --> 对象头
spring中哪些类会被存在老年代
为什么要使用stw机制 --> 线程安全 ABA问题
复制 -- 标记清楚 -- 标记整理

10个垃圾收集器
分代模型 |1.8后| 分区模型                                                            |                   Epsilon
年轻代：ParNew(复制)               Serial                   Parallel Scavenge(8)    |  G1(9 STW<10ms)   ZGC(11 STW<1ms)      Shenandoah G1增强版
老年代：CMS(标记清楚 STW<100ms)     Serial Old(标记整理)      Parallel Old8()         |
垃圾收集器不断地迭代升级 ---> 堆内存的不断增大 如：80平 篮球场 足球场
CMS(ConcurrentMarkSweep) -- G1 -- ZGC
CMS:初始标记 --> 初始标记 --> 并发标记 --> 重新标记 --> 并发清理
CMS 缺点: 漏标 浮动垃圾
CMS 异常 --切换为--> SerialOld

调优思想：通过调节堆内存比例，尽量让生命周期短的对象在年轻代被MinorGC回收，尽可能少的出发FullGC
调优项：根据项目进行JVM规划和预干预 优化运行中JVM导致的卡顿现象 解决JVM运行过程中的问题(OOM等)

## 组件
redis Eureka zookeeper
Spring事务  -
事务隔离级别 -
mysql 索引-

## 算法
9. 两个无序数组合并排序
10. 链表环判断 
