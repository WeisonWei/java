package com.weison.thread.runnable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		for(;;)
		{
			System.out.println("123123213213123");
		}
		
		//hashMap();
		//hashtable();
	}

	private static void hashMap() throws InterruptedException {
		Map map = new HashMap();

		Run1 rtt1 = new Run1(map);
		Run2 rtt2 = new Run2(map);
		new Thread(rtt1, "新线程1").start();
		new Thread(rtt2, "新线程2").start();
		Thread.currentThread().sleep(1000);
		System.out.println("end>>" + map);
	}

	private static void hashtable() throws InterruptedException {
		Map map = new Hashtable();

		Run1 rtt1 = new Run1(map);
		Run2 rtt2 = new Run2(map);
		new Thread(rtt1, "新线程1").start();
		new Thread(rtt2, "新线程2").start();
		Thread.sleep(5000);
		System.out.println("end>>" + map);
	}
}
