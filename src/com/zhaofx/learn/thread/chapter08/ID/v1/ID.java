package com.zhaofx.learn.thread.chapter08.ID.v1;

class ID {
	private static volatile long nextID = 1;

	static synchronized long getNextID() {
		return nextID++;
	}
}