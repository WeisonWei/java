## java8
新特性
变化：Map 线程池 内存区域 默认垃圾收集器

## os
内核态 用户态 系统调用 shell

## 集合
- hashMap 和 concurrentHashMap 线程安全机制
- ArrayList LinkList 初始化 扩容 快速失败

## 线程
sleep() wait() join yield interrupted
线程池 参数 拒绝策略 队列长度 阻塞队列
线程池：forkjoin worksteal 
设计一个高并发处理能力线程池

## 锁
synchronized 锁升级
volatile 结合os
ReentrantLock ReentrantReadWriteLock 源码实现
aqs 队列入队出队
conuntLantch cyclicbar semphore 源码实现
分布式锁思想 redisson

## io
bio nio aio
reactor netty

## jvm
方法区 ： 常量 静态变量 类元信息
从多线程交互的角度解读程序计数器(线程私有)的作用
局部变量表 + 操作数栈(运算过程的临时空间)的压栈出栈 ： 描述 int i= 1+a; 在栈针中的运行过程
动态链接：方法区对应方法的符号链接(地址)
类加载器类别
写一个stackoverflow

## gc
工具：visualGC
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
分布式 ha
分布式锁 redis(lua) redisson
http rpc
springboot starter & dubbo spi
微服务 Eureka zookeeper
spring 事务传递 循环依赖
redis 数据一致性 缓存一致性
mysql 索引 事务隔离级别 并发控制
spring webflux reactor3
jps entity 生命周期 如何实现高效批量 新增&删除
mybatis 缓存
docker swarm stack k8s 演进历程
k8s 滚动升级

## 算法
lru
lfu
删除排序数组中的重复项
旋转数组
合并两个有序数组
环形链表
合并两个有序链表
反转链表
两两交换链表中的节点
删除排序链表中的重复元素
删除链表的倒数第N个节点
回文链表
用栈实现队列
用队列实现栈
有效的字母异位词
字母异位词分组
存在重复元素
最长和谐子序列
最长连续序列
树的遍历
二叉树的中序遍历
二叉树的前序遍历
二叉树的后序遍历
二叉树的层次遍历
N叉树的前序遍历
N叉树的后序遍历
N叉树的层次遍历
括号生成
验证二叉搜索树
二叉树的最大高度
二叉树的最小深度
翻转二叉树
二叉搜索树的最近公共祖先
二叉树的最近公共祖先
从前序与中序遍历序列构造二叉树
从中序与后序遍历序列构造二叉树
分治与回溯
在每个树行中找最大值
翻转二叉树
对称二叉树
合并二叉树
左叶子之和
二叉树中第二小的节点
二叉搜索树中第K小的元素
把二叉搜索树转换为累加树
二叉搜索树的最近公共祖先
将有序数组转换为二叉搜索树
有序链表转换二叉搜索树
二叉搜索树的最小绝对差
二叉搜索树中的众数

