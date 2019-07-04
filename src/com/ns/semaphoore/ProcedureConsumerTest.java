package com.ns.semaphoore;

public class ProcedureConsumerTest {
	public static void main(String[] args) {
		OddEvenSemaphoreImpl impl = new OddEvenSemaphoreImpl();
		Odd oddRunnable = new Odd(impl);
		Even evenRunnable = new Even(impl);
		Thread oddWorker = new Thread(oddRunnable, "ODD-Thread");
		Thread evenWorkerThread = new Thread(evenRunnable, "EVEN-Thread");
		oddWorker.start();
		evenWorkerThread.start();
	}
}
