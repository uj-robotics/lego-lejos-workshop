package wstep;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.Motor;


public class RegulatedMotors {

	
	public void addButtonListeners(){
		Button.ENTER.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				Motor.A.rotate(360, true);
				Motor.B.rotate(360, true);
			}
		});
		Button.LEFT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				Motor.A.setAcceleration(9000);
				Motor.B.setAcceleration(9000);
				Motor.A.rotate(360, true);
				Motor.B.rotate(-360, true);
			}
		});
		Button.RIGHT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				Motor.A.setAcceleration(300);
				Motor.B.setAcceleration(300);
				int tacho = Motor.A.getTachoCount();
				Motor.A.rotate(-240, true);
				Motor.B.rotate(240, false);
				int tacho2 = Motor.A.getTachoCount();
				LCD.clear();
				LCD.drawInt(tacho, 0, 0);
				LCD.drawInt(tacho2, 0, 1);
			}
		});
		
		Button.ESCAPE.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				System.exit(0);
			}
		});
		
		
	}
	
	
	public static void main(String[] args){
		RegulatedMotors rm = new RegulatedMotors();
		rm.addButtonListeners();
		while (true){
			Thread.yield();
		}
	}
	
	
}
