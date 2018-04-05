/** 
 * Project Name:Concurrent 
 * File Name:Runable.java 
 * Package Name:com.zhaofx.learn.lambda 
 * Date:2018��4��5������4:25:59 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.lambda;

/**
 * ClassName:Runable <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018��4��5�� ����4:25:59 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class Runable {
	public static void main(String[] args) {
		// 1.1ʹ�������ڲ���
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		}).start();

		// 1.2ʹ�� lambda expression
		new Thread(() -> System.out.println("Hello world !")).start();

		// 2.1ʹ�������ڲ���
		Runnable race1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		};

		// 2.2ʹ�� lambda expression
		Runnable race2 = () -> System.out.println("Hello world !");

		// ֱ�ӵ��� run ����(û�����߳�Ŷ!)
		race1.run();
		race2.run();
	}
}
