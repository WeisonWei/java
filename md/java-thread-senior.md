# Java Thread

## 相关概念
1. Linux 内核态 用户态
2. Linux 进程&线程 切换
3. Linux 中断机制
4. CPU三级缓存
5. 内存屏障
6. 多核CPU之间可见性 
7. Java虚拟机内存结构(JVM - Java Virtual Machine)
8. Java内存模型(JMM - Java Memory Model)
8. JVM 中断机制
9. 锁的类型
10. 线程阻塞代价
11. markword



## 线程安全

> [Java线程安全](https://juejin.im/post/5d2c97bff265da1bc552954b)

## 锁🔒

### 自旋锁
需要寻找 --> 线程自旋的消耗大于线程阻塞挂起操作的消耗的平衡点

> [Java锁](https://www.cnblogs.com/linghu-java/p/8944784.html)
> [Java对象结构](https://blog.csdn.net/zqz_zqz/article/details/70246212)
https://zhuanlan.zhihu.com/p/133851347
https://cloud.tencent.com/developer/article/1465413
https://zhuanlan.zhihu.com/p/75880892
https://zhuanlan.zhihu.com/p/52196637
https://zhuanlan.zhihu.com/p/85846117
https://zhuanlan.zhihu.com/p/247579215