package wstep;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Motory {
	/*
	 * 
	 * Nie ma prawdziwej wielozadaniowosci, bo wszytko jest synchronized
	 */
	class TrueListener extends Thread {
		NXTRegulatedMotor m;
		Button b;
		int wait;
		TrueListener(NXTRegulatedMotor m,Button b,int wait){
			this.m = m;
			this.b=b;
			this.wait = wait;
		}
		
		public void run() {
			while (true) {
				if (b.isDown()){
					LCD.clear();
					LCD.drawString("NACISNIETY ",0,0);
					LCD.drawString(b.toString(),0,1);
					m.forward();
				}
				else{
					m.flt();
					LCD.drawString("NIENACISNIETY ",0,0);
					LCD.drawString(b.toString(),0,1);
				}
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}

	public void addListeners() {/*
		Button.LEFT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {
				/*
				 * NOTE: Not in stop!
				Motor.A.flt();
			}

			@Override
			public void buttonPressed(Button b) {
				Motor.A.forward();
			}
		});

		Button.RIGHT.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button b) {
				Motor.B.flt();
			}

			@Override
			public void buttonPressed(Button b) {
				Motor.B.forward();
			}
		});
		*/
		TrueListener tl1 = new TrueListener(Motor.A, Button.LEFT,6000);
		TrueListener tl2 = new TrueListener(Motor.B, Button.RIGHT, 2000);
		//tl1.setDaemon(true); tl2.setDaemon(true);
	}

	public static void main(String[] args) {
		Motory m = new Motory();
		m.addListeners();
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
