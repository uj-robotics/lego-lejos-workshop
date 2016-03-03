package wstep;

import lejos.nxt.Button;
import lejos.nxt.LCD;


public class HelloWorld {

	
	public static void main(String[] args){
		LCD.clearDisplay();
		LCD.drawString("Hello World!", 0, 0);
		
		Button.waitForAnyPress();
		
	}
	
	
}
