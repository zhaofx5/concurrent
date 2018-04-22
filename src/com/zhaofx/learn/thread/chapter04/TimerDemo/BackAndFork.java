/** 
 * Project Name:Concurrent 
 * File Name:BackAndFork.java 
 * Package Name:com.zhaofx.learn.thread.chapter04.TimerDemo 
 * Date:2018年4月22日上午9:59:13 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.thread.chapter04.TimerDemo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ClassName:BackAndFork <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月22日 上午9:59:13 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class BackAndFork {

	private static volatile boolean sign = true;

	public static void main(String[] args) {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				if (sign)
					System.out.println("fork");
				else
					System.out.println("back");

				sign = !sign;
			}
		};
		Timer timer = new Timer("mytimer");
		timer.schedule(timerTask, 10, 1000);
	}

}
