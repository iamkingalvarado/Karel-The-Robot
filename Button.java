import java.awt.Dimension;

import javax.swing.JButton;


public class Button extends JButton {
	int posX,posY;
	private boolean wall=false;
	private boolean beeper=false;
	private int Beeps=0;
	
	public final Dimension getPreferredSize(){
		Dimension e;
		e = new Dimension();
		e.height=20;
		e.width=20;
		return e;
	}
	
	public void setXY(int posX,int posY){
		this.posX=posX;
		this.posY=posY;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public int setButtonAsBeeper(int i){
		beeper=true;
		Beeps+=i;
		return Beeps;
	}
	
	public boolean isBeeper(){
		return beeper;
	}
	
	public void setButtonAsWall(){
		wall=true;
	}
	
	public boolean isWall(){
		return wall;
	}
}
