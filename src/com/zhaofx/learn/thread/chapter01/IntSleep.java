/** 
 * Project Name:Concurrent 
 * File Name:IntSleep.java 
 * Package Name:com.zhaofx.learn.thread.chapter01 
 * Date:2018年4月11日下午10:41:36 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.thread.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:IntSleep <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月11日 下午10:41:36 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class IntSleep {
	public static void main(String[] args) {

		Runnable runnable = () -> {
			while (true) {
				System.out.println("hello");
				Thread thread = Thread.currentThread();
				System.out.println(thread.getName() + thread.isInterrupted());
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("InterruptedException");
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.setName("Zfxthread_");
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("-----------------------");
		}

		thread.interrupt();
		System.out.println(thread.isInterrupted() + "zzzz");
	}

}
