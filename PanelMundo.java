import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelMundo extends JPanel implements ActionListener{
	
	private Button casillas[][];
	private Graphics g;
	private boolean wall;
	private boolean beeper;
	private boolean wallpoint;
	private int point1X;
	private int point1Y;
	private int point2X;
	private int point2Y;
	private int NoBeep;
	private Karel karel;
	private boolean posKarel;
	
	public PanelMundo(){
		point1X=point1Y=point2X=point2Y=NoBeep=0;
		wall=beeper=wallpoint=posKarel=false;
		
		
		this.setLayout(new GridLayout(26,26));
		this.setSize(650, 650);
		
		casillas=new Button[26][26];
		boolean b=true;
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++){
				if(b&&(i%2==0)&&(j%2==0)){
					casillas[i][j]= new Button();
					casillas[i][j].setPreferredSize(getPreferredSize());
					this.add(casillas[i][j]);
				}else{
					casillas[i][j]= new Button();
					casillas[i][j].setPreferredSize(getPreferredSize());
					casillas[i][j].setOpaque(false);
					casillas[i][j].setContentAreaFilled(false);
					casillas[i][j].setBorderPainted(false);
					this.add(casillas[i][j]);
				}
				b=!b;
				casillas[i][j].addActionListener(this);
				casillas[i][j].setXY(i, j);
			}
			b=!b;
		}
		karel=new Karel(this,casillas);
	}
	
	public void setWall(){
		wall=true;
	}
	
	private void addWall(int x,int y){
		
		if(wallpoint){
			point1X=x;
			point1Y=y;
		}else{
			point2X=x;
			point2Y=y;
			if((point1X>point2X)||(point1Y>point2Y)){
				int aux=point1X;
				point1X=point2X;
				point2X=aux;
				int aux2=point1Y;
				point1Y=point2Y;
				point2Y=aux2;
			}
			wall=false;
			if((point1X==point2X)&&(point1Y!=point2Y)){
				for(int i=point1Y;i<point2Y+1;i++){
					casillas[point1X][i].setOpaque(true);
					casillas[point1X][i].setContentAreaFilled(true);
					casillas[point1X][i].setBorderPainted(true);
					casillas[point1X][i].setBackground(Color.BLACK);
					casillas[point1X][i].setButtonAsWall();
				}
			}else if((point1X!=point2X)&&(point1Y==point2Y)){
				for(int i=point1X;i<point2X+1;i++){
					casillas[i][point1Y].setOpaque(true);
					casillas[i][point1Y].setContentAreaFilled(true);
					casillas[i][point1Y].setBorderPainted(true);
					casillas[i][point1Y].setBackground(Color.BLACK);
					casillas[i][point1Y].setButtonAsWall();
				}
			}
				
		}
		
	}
	
	public void setBeeper(){
		beeper=true;
		String NumBeepers = JOptionPane.showInputDialog(null,"Ingresa el numero de zumbadores","Agregar Zumbador",JOptionPane.QUESTION_MESSAGE);
		try{
			NoBeep = Integer.parseInt(NumBeepers);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Ingresa un numero valido");
		}
	}
	
	private void addBeeper(Button boton){
		casillas[boton.getPosX()][boton.getPosY()].setBorderPainted(true);
		casillas[boton.getPosX()][boton.getPosY()].setOpaque(true);
		casillas[boton.getPosX()][boton.getPosY()].setContentAreaFilled(true);
		casillas[boton.getPosX()][boton.getPosY()].setBackground(Color.RED);
		String NoBeeps = Integer.toString(casillas[boton.getPosX()][boton.getPosY()].setButtonAsBeeper(1));
		casillas[boton.getPosX()][boton.getPosY()].setBorder(null);
		casillas[boton.getPosX()][boton.getPosY()].setText(NoBeeps);
		casillas[boton.getPosX()][boton.getPosY()].setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
		NoBeep--;
		
	}
	
	public void empezarRecorridoKarel(){
		
	}
	
	public void cambiarKarel(){
		posKarel=true;
	}
	public void actionPerformed(ActionEvent e) {
		Button boton=(Button)e.getSource();
		if((wall)&&(!beeper)&&(!posKarel)){
			try{
				if((boton.getPosX()%2==0)&&(boton.getPosY()%2==0)){
					wallpoint=!wallpoint;
					this.addWall(boton.getPosX(), boton.getPosY());
				}else{
					JOptionPane.showMessageDialog(this,"Boton zumbador");
				}
			}catch(Exception e1){
				System.out.println(e1);
			}
		}else if((beeper)&&(!wall)&&(!posKarel)){
			try{
				if((boton.getPosX()%2!=0)&&(boton.getPosY()%2!=0)&&(NoBeep>0)&&(!boton.isWall())){
					this.addBeeper(boton);
				}else{
					beeper=false;
					NoBeep=0;
				}
			}catch(Exception a){
				a.getCause();
			}
		}else if((posKarel)&&(!wall)&&(!beeper)){
			try{
				if((boton.getPosX()%2!=0)&&(boton.getPosY()%2!=0)&&(!boton.isWall())){
					karel.setPosKarel(boton.getPosX(), boton.getPosY());
					posKarel=false;
				}
			}catch(Exception o){
				o.getCause();
			}
		}
	}

}
