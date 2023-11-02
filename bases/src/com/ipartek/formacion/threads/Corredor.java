package com.ipartek.formacion.threads;

import java.util.Random;

public class Corredor implements Runnable {
	private int posicion = 0;
	private int dorsal;

	public Corredor(int dorsal) {
		this.dorsal = dorsal;
	}

	public void run() {
		for (posicion = 0; posicion <= 10; posicion++) {
			System.out.println(dorsal + ": " + posicion);

			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(dorsal + ": HA LLEGADO A META");
	}
}
