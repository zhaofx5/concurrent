/** 
 * Project Name:Concurrent 
 * File Name:Runable.java 
 * Package Name:com.zhaofx.learn.lambda 
 * Date:2018年4月5日下午4:25:59 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.lambda;

/**
 * ClassName:Runable <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月5日 下午4:25:59 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class Runable {
	public static void main(String[] args) {
		// 1.1使用匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		}).start();

		// 1.2使用 lambda expression
		new Thread(() -> System.out.println("Hello world !")).start();

		// 2.1使用匿名内部类
		Runnable race1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		};

		// 2.2使用 lambda expression
		Runnable race2 = () -> System.out.println("Hello world !");

		// 直接调用 run 方法(没开新线程哦!)
		race1.run();
		race2.run();
	}
}
