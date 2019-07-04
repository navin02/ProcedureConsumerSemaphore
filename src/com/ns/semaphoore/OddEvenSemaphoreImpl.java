package com.ns.semaphoore;

import java.util.concurrent.Semaphore;

public class OddEvenSemaphoreImpl {

	private Semaphore oddSemaphore = new Semaphore(0);

	private Semaphore evenSemaphore = new Semaphore(1);

	private int count = 1;

	public void print() {
		while (count <= 10) {
			try {
				if (count % 2 == 0) {
					oddSemaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " " + count++);
					evenSemaphore.release();
				} else {
					evenSemaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " " + count++);
					oddSemaphore.release();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
