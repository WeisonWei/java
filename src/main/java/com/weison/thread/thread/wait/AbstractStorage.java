package com.weison.thread.thread.wait;

/**
 * https://www.cnblogs.com/moongeek/p/7631447.html
 */
public interface AbstractStorage {

    void consume(int num);

    void produce(int num);
}
