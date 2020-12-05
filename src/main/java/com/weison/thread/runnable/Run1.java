package com.weison.thread.runnable;

import java.util.Map;

public class Run1 implements Runnable {

	private int i;
	private Map map;

	Run1(Map map) {
		this.map = map;

	}

	public void run() {
		for (i = 0; i < 30; i++) {
			map.put(i, i);
			System.out.println(Thread.currentThread().getName() + "add" + i);
		}
		System.out.println(Thread.currentThread().getName()+">>end>>"+map);
	}

}
