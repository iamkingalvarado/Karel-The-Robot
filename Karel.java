import java.awt.Color;


public class Karel extends Thread{
	PanelMundo p;
	Button casillas[][];
	private int x;
	private int y;
	
	public Karel(PanelMundo p,Button casillas[][]){
		this.p=p;
		x=25;
		y=1;
		this.casillas=casillas;
		casillas[x][y].setOpaque(true);
		casillas[x][y].setContentAreaFilled(true);
		casillas[x][y].setBorderPainted(true);
		casillas[x][y].setBackground(Color.GREEN);
	}
	
	
	public void run(){
		this.start();
	}
	
	public void setPosKarel(int x,int y){
		casillas[this.x][this.y].setOpaque(false);
		casillas[this.x][this.y].setContentAreaFilled(false);
		casillas[this.x][this.y].setBorderPainted(false);
		
		this.x=x;
		this.y=y;

		casillas[x][y].setOpaque(true);
		casillas[x][y].setContentAreaFilled(true);
		casillas[x][y].setBorderPainted(true);
		casillas[x][y].setBackground(Color.GREEN);
		
		p.repaint();
	}
	

}
