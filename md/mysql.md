# MySQL

## MySQL - 1 - 架构
## MySQL - 2 - 字符集

## MySQL - 3 - 数据类型
## MySQL - 4 - 函数
## MySQL - 5 - 子查询
## MySQL - 6 - 分组
## MySQL - 7 - 连接

## MySQL - 8 - 引擎
## MySQL - 9 - 索引
## MySQL - 10 - 事务
## MySQL - 11 - MVCC
## MySQL - 12 - 锁

## MySQL - 13 - explain

## MySQL - 14 - binlog
## MySQL - 15 - redolog
## MySQL - 16 - undolog


## 附录

### 垂直分片

    垂直拆分（拆库）：例如拆分所有订单的数据和产品的数据，变成两个独立的库，这种方式对业务系统有极大的影响，因为数据结构本身发生了变化，SQL 和关联关系也必随之发生了改变。原来一个复杂 SQL 直接把一批订单和相关的产品都查了出来，现在这个 SQL 不能用了，得改写 SQL 和程序。先查询订单库数据，拿到这批订单对应的所有产品 id，再根据产品 id 集合去产品库查询所有的产品信息，最后再业务代码里进行组装。
    垂直拆分（拆表）：如果单表数据量过大，还可能需要对单表进行拆分。比如一个 200 列的订单主表，拆分成十几个子表：订单表、订单详情表、订单收件信息表、订单支付表、订单产品快照表等等。这个对业务系统的影响有时候可能会大到跟新作一个系统差不多。对于一个高并发的线上生产系统进行改造，就像是给心脑血管做手术，动的愈多，越核心，出现大故障的风险越高。所以，我们一般情况下，尽量少用这种办法。



### 慢查询

慢查询 MySQL 是默认关闭的，开启慢查询日志：
set global slow_query_log='ON'; 

可以设置慢查询存放的位置：
set global slow_query_log_file='/test/data/slow_query.log';
long_query_time 慢查询的阈值，默认是 10S，超过 10S 就会被记录到日志。修改：
set global long_query_time=3;

会记录所有没走索引的查询：
set global log_queries_not_using_indexes='ON';

查看慢查询日志的信息：
show variables like "%query%";

查看慢查询存放位置：
show variables like 'slow_query_log_file';


### 执行计划

explain  select 语句

explain select * from user where user_id =2

在这里插入图片描述

参数说明：

    select_type：简单查询（SIMPLE）、最外层查询（PRIMARY）、映射为子查询（SUBQUERY）、子查询（DERIVED）、联合（UNION）、使用联合的结果（UNION RESULT）
    type：ALL（全表扫描)、index（走索引）、RANGE（对索引列进行范围查找）、INDEX_MERGE（合并索引）、REF（根据索引查找一个或多个值）、EQ_REF（搜索时使用 primary key 或 unique 类型）、CONST（常量）、SYSTEM（系统）
    性能比较：all < index < range < index_merge < ref_or_null < ref < eq_ref < system/const
    rows：预计需要读取几行数据
    possible_keys：使用索引类型和名称
    key_len：索引的字节长度
    extra：见下图


[执行计划](https://www.cnblogs.com/klvchen/p/10137117.html)
[深入理解 MySQL 底层实现](https://gitbook.cn/gitchat/activity/5a07c4266a4b0d78856826ea)
[MySQL 索引与优化](https://gitbook.cn/books/5c92fd312cc79178471b68db/index.html)
[138 张图带你 MySQL 入门](https://gitbook.cn/books/5eef6f0335d2480b101d7552/index.html)
[47 张图带你 MySQL 进阶](https://gitbook.cn/gitchat/activity/5f1a8d30a50beb3089673b7a)
[MySQL 高级教程](https://gitbook.cn/gitchat/activity/5efdd8ae44dfac09f99610bb)