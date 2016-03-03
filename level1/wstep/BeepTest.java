package wstep;
import lejos.nxt.Sound;
public class BeepTest {

	
	public static void main(String[] args) throws InterruptedException{
		//Beep :)
		Sound.beep();
		Thread.sleep(500);
		Sound.playTone(500,100);
		Thread.sleep(500);
		Sound.playTone(1000,100);
	}
}
