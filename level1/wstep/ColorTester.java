package wstep;
import lejos.robotics.Color;
import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.LCD;

public class ColorTester {
	ColorSensor cs;
	
	public void drawString(String s, int x, int y){
		LCD.clear();
		LCD.drawString(s, x, y);
	}
	public void addButtonListeners(){
	
		
		Button.ENTER.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			@Override
			public void buttonPressed(Button b) {
				cs.getColor();
				cs.getRawColor();
				int color = cs.getColorID();
				if (color == Color.BLACK){
					drawString("BLACK", 0, 0);
				}
				else if (color == Color.WHITE){
					drawString("WHITE", 0, 0);
				}
				else if (color == Color.BLUE){
					drawString("BLUE", 0, 0);
				}
			}
		});
		
		Button.LEFT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				cs.calibrateHigh();
				drawString("Calibrated HIGH", 0, 0);
			}
		});
		Button.RIGHT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}
			public void buttonPressed(Button b) {
				cs.calibrateLow();
				drawString("Calibrated LOW", 0, 0);
			}
		});
		
		
	}
	
	public static void main(String[] args){
		ColorTester ct = new ColorTester();
		ct.cs = new ColorSensor (SensorPort.S1);
		ct.cs.setFloodlight(1);
		ct.addButtonListeners();
		while (true){
			Thread.yield();
		}
		
	}
}
