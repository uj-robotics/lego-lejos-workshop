package wstep;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
public class Sonar {
	
	
	public void addButtonListeners(){
		Button.ESCAPE.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				System.exit(0);
			}
		});
	}
	public static void main (String[] args){
		Sonar s = new Sonar();
		s.addButtonListeners();
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);
		while (true){
			int distance = us.getDistance();
			LCD.drawInt(distance, 4, 0, 0);
			Sound.playTone(distance*10, 100);
		}
		
	}
}
