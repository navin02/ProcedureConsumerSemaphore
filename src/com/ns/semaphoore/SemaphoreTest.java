package com.ns.semaphoore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest implements Runnable {

	private volatile static int  count = 1;

	private boolean flag;

	private static Semaphore oddSemaphore = new Semaphore(0);
	private static Semaphore evenSemaphore = new Semaphore(1);

	public SemaphoreTest(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		
		if (flag) {
			printEven();
		} else {
			printOdd();
		}
	
	}

	private void printEven() {
		while (count < 10) {
			try {
				evenSemaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "  " + count++);
				Thread.sleep(100);
				oddSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void printOdd() {
		while (count < 10) {
			try {
				oddSemaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " " + count++);
				evenSemaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread evenThread = new Thread(new SemaphoreTest(true), "EVEN-THREAD");
		Thread oddThread = new Thread(new SemaphoreTest(false), "ODD-THREAD");

		oddThread.start();
		evenThread.start();
	}
}
