package com.zhaofx.learn.thread.chapter04.ExceptionThread.v1;

public class ExceptionThread {
	public static void main(String[] args) {
		Runnable r = () -> {
			int x = 1 / 0; // Line 10
		};
		Thread thd = new Thread(r);
		thd.start();
	}
}