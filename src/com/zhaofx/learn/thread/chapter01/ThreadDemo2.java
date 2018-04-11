package com.zhaofx.learn.thread.chapter01;

public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				int count = 0;
				while (!Thread.interrupted())
					System.out.println(name + ": " + count++);
			}
		};
		Thread thdA = new Thread(r);
		Thread thdB = new Thread(r);
		thdA.start();
		thdB.start();
		while (true) {
			double n = Math.random();
			if (n >= 0.49999999 && n <= 0.50000001) {
				System.out.println("-------------------------");
				break;
			}

		}
		thdA.interrupt();
		thdB.interrupt();
	}
}