package com.zhaofx.learn.thread.chapter02.ID.v2;

public class ID {
	private int counter; // initialized to 0 by default

	public synchronized int getID() {
		return counter++;
	}

	public static void main(String[] args) {
		ID id = new ID();
		System.out.println(id.getID());
	}
}