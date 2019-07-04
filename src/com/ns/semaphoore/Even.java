package com.ns.semaphoore;

public class Even implements Runnable {
	OddEvenSemaphoreImpl impl;

	public Even(OddEvenSemaphoreImpl impl) {
		this.impl = impl;

	}

	@Override
	public void run() {
		impl.print();
	}

}
