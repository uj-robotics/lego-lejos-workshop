package wstep;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;

public class Motory2 {

	public void addListeners() {
		Button.ENTER.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {
				/*
				 * NOTE: Not in stop!
				 */
				/* 
				 * TODO co trzeba zrobic by zatrzymywaly sie rowno?
				 */
				Motor.A.flt();
				Motor.B.flt();
			}

			@Override
			public void buttonPressed(Button b) {
				Motor.A.forward();
				Motor.B.forward();
			}
		});

		Button.ESCAPE.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {
				Motor.B.flt(true);
				Motor.A.flt(true);
			}

			@Override
			public void buttonPressed(Button b) {
				Motor.B.backward();
				Motor.A.backward();
			}
		});
		}
	
	static public void main (String[] args){
		Motory2 m2 = new Motory2();
		m2.addListeners();
		
		while (true){
			Thread.yield();
		}
	}
}
