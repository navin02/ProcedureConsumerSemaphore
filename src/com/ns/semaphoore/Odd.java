package com.ns.semaphoore;

public class Odd implements Runnable {

	OddEvenSemaphoreImpl impl;

	public Odd(OddEvenSemaphoreImpl impl) {
		this.impl = impl;
	}

	@Override
	public void run() {
		impl.print();
	}

}
