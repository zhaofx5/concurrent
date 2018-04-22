package com.zhaofx.learn.thread.chapter08.ID.v2;

import java.util.concurrent.atomic.AtomicLong;

class ID {
	private static AtomicLong nextID = new AtomicLong(1);

	static long getNextID() {
		return nextID.getAndIncrement();
	}
}