> https://www.zhihu.com/question/318472639/answer/652254785


其中supplyAsync用于有返回值的任务，runAsync则用于没有返回值的任务。Executor参数可以手动指定线程池，否则默认ForkJoinPool.commonPool()系统级公共线程池，
注意：这些线程都是Daemon线程，主线程结束Daemon线程不结束，只有JVM关闭时，生命周期终止。

```
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<TaskLog> getFailedTaskLogs() {

        //1.COMPLETE的任务 超过3天
        CompletableFuture<Stream<TaskLog>> cf1 = taskLogRepository.findAllByStatus(TaskLog.STATUS.COMPLETE)
                .thenApply(this::makeTaskLogFailed);

        //2.ACTIVE的体验课三个任务
        //完成第一周体验课 起始周 周四结束
        CompletableFuture<Stream<TaskLog>> cf2 = taskLogRepository.findAllByStatusAndTag(TaskLog.STATUS.ACTIVE, COMPLETE_FIRST_WEEKLY_COURSE)
                .thenApply(this::makeFirstWeeklyCourseTaskLogFailed);

        //完成第二周体验课 起始第二周 周四结束
        CompletableFuture<Stream<TaskLog>> cf3 = taskLogRepository.findAllByStatusAndTag(TaskLog.STATUS.ACTIVE, COMPLETE_SECOND_WEEKLY_COURSE)
                .thenApply(this::makeSecondWeeklyCourseTaskLogFailed);

        //购买系统课 超过15天
        CompletableFuture<Stream<TaskLog>> cf4 = taskLogRepository.findAllByStatusAndTag(TaskLog.STATUS.ACTIVE, BUY_SYSTEM_COURSE)
                .thenApply(this::makeBuyExperienceCourseTaskLogFailed);

        CompletableFuture<Stream<TaskLog>> cf5 = cf1.thenCombine(cf2, Stream::concat)
                .thenCombine(cf3, Stream::concat)
                .thenCombine(cf4, Stream::concat);

        CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5).join();

        return cf5.join().collect(Collectors.toList());
    }
```