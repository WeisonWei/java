package com.weison.base.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonProxy implements IPerson {
    private IPerson person;

    public PersonProxy(IPerson person) {
        this.person = person;
    }

    public void eating() {
        log.info("开始执行时间:“ + new Date()");
        person.eating();
        log.info("“执行结束时间:” + new Date()");
    }

    public void sleep() {
        log.info("开始执行时间:“ + new Date()");
        person.sleep();
        log.info("“执行结束时间:” + new Date()");
    }
}
