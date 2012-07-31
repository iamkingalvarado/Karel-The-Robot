import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Mundo extends JFrame implements ActionListener{
	private PanelMundo panelMundo;
	private JScrollPane scroll;
	private JMenuBar barraOpciones;
	private JMenu mundo;
	private JMenuItem agregarPared,agregarZumbador,abrirMundo,guardarMundo,empezar,cambiarPosicionKarel;
	
	
	public Mundo(){
		
		super("Mundo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650,650);
		this.setLayout(new GridLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		barraOpciones = new JMenuBar();
		mundo = new JMenu("Menu");
		barraOpciones.add(mundo);
		
		empezar=new JMenuItem("Empezar");
		cambiarPosicionKarel=new JMenuItem("Cambiar la posicion de Karel");
		agregarPared = new JMenuItem("Agregar Pared");
		agregarZumbador = new JMenuItem("Agregar Zumbador");
		abrirMundo=new JMenuItem("Abrir Mundo");
		guardarMundo=new JMenuItem("Guardar Mundo");
		
		empezar.addActionListener(this);
		cambiarPosicionKarel.addActionListener(this);
		abrirMundo.addActionListener(this);
		guardarMundo.addActionListener(this);
		agregarPared.addActionListener(this);
		agregarZumbador.addActionListener(this);
		
		mundo.add(empezar);
		mundo.add(cambiarPosicionKarel);
		mundo.add(abrirMundo);
		mundo.add(guardarMundo);	
		mundo.add(agregarPared);
		mundo.add(agregarZumbador);
		
		panelMundo=new PanelMundo();
		scroll = new JScrollPane(panelMundo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(scroll);
		this.setJMenuBar(barraOpciones);
		this.setVisible(true);
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==agregarPared){
			panelMundo.setWall();
		}else if(e.getSource()==agregarZumbador){
			panelMundo.setBeeper();
		}else if(e.getSource()==empezar){
			panelMundo.empezarRecorridoKarel();
		}else if(e.getSource()==cambiarPosicionKarel){
			panelMundo.cambiarKarel();
		}
		
	}
	
	
}
