package wstep;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;
import java.lang.Thread;
public class Listnery {

	
	public void addListeners(){
		Button.LEFT.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			}
			
			@Override
			public void buttonPressed(Button b) {
				LCD.clear();
				LCD.drawString("LEFT PRESSED", 0, 0);
			}
		});
		
		Button.RIGHT.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			}
			
			@Override
			public void buttonPressed(Button b) {
				LCD.clear();
				LCD.drawString("RIGHT PRESSED", 0, 0);
			}
		});
		Button.ENTER.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			}
			
			@Override
			public void buttonPressed(Button b) {
				LCD.clear();
				LCD.drawString("ENTER PRESSED", 0, 0);
			}
		});
		Button.ESCAPE.addButtonListener(new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			}
			
			@Override
			public void buttonPressed(Button b) {
				LCD.clear();
				LCD.drawString("ESCAPE PRESSED", 0, 0);
			}
		});
		
	}

	
	
	public static void main(String[] args){
		Listnery l = new Listnery();
		l.addListeners();
		while (true){
			try {
				Thread.sleep(5000);
				LCD.clear();
				LCD.drawString("Spalem 5 sekund", 0, 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		
	}
}
