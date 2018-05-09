/** 
 * Project Name:Concurrent 
 * File Name:TestMain.java 
 * Package Name:com.zhaofx.learn.thread 
 * Date:2018年4月3日下午9:45:02 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:TestMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月3日 下午9:45:02 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestMain {

	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

	private static final AtomicInteger ATOMIC_INTEGER1 = new AtomicInteger();

	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(1), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {
						System.out.println("rejectExcutionHanlder");

						// paramThreadPoolExecutor.shutdownNow();
						try {
							paramThreadPoolExecutor.awaitTermination(11, TimeUnit.SECONDS);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

		while (true) {
			Runnable runnable = () -> {
				System.out.println("test:" + ATOMIC_INTEGER.getAndIncrement());
				try {
					TimeUnit.SECONDS.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(
					"add:" + ATOMIC_INTEGER1.getAndIncrement() + "and hao many execute" + ATOMIC_INTEGER.get());
			executorService.execute(runnable);
		}

	}

}
