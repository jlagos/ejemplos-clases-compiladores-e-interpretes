package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Modelo;
import modelo.Figura;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


import controlador.Controlador;


public class Vista extends JPanel {
	static final long serialVersionUID = 0L;
	private Modelo modelo;
	public Controlador controlador;  //IMPORTANTE DEBE SER REGISTRADO O TODO FALLA
	public JPopupMenu contextual;
 
	public Vista(Dimension size, Modelo modelo){
		super();
		this.modelo=modelo;
		
		setPreferredSize(size);
		setBackground(Color.white);
		setFocusable(true);

		//Mejorable al 1000% solo por simplificacion realizado de esta forma
		MouseController mouseControl = new MouseController() {
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
			public void mouseMoved(MouseEvent event) {
				 eVmouseMoved(event);
			}
			public void mousePressed(MouseEvent event) {
			    eVmousePressed(event);	}
			public void mouseReleased(MouseEvent event) {
				eVmouseReleased(event);	}
			public void mouseDragged(MouseEvent event) {
				eVmouseDragged(event);	}
		};
		this.addMouseListener(mouseControl);
		this.addMouseMotionListener(mouseControl);
		contextual = new JPopupMenu();
	      JMenuItem opcion;
	      opcion= new JMenuItem("Cuadrado");
	      opcion.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
	            	Point p=new Point(controlador.xclick, controlador.yclick);
	            	
	                controlador.anyadirFigura(new Cuadrado(p,40));
	                repaint();
	             }
	            
	        });
	      contextual.add(opcion);
	      opcion= new JMenuItem("Circulo");
	      opcion.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
	            	Point p=new Point(evt.getXOnScreen(), evt.getYOnScreen());
	                controlador.anyadirFigura(new Circulo(p,40));
	                repaint();
	             }
	            
	        });
	      contextual.add(opcion);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		pintarTodo(g2);
	}
	
	private void pintarTodo(Graphics2D g){
		for (Figura elemento : modelo.getListado()) {
			elemento.dibujar(g);
		}
	}

	public void eVmousePressed(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmousePressed(ev);
		}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseDragged(ev);
		}
	}
	
	public void eVmouseReleased (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseReleased(ev);
		}
	}
	
	public void eVmouseMoved (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseMoved(ev);
		}
	}
	
}


/**************************************************
* SOLO para ahorrar espacio y simplificar cosas
**************************************************/
class MouseController implements MouseListener, MouseMotionListener {
	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseDragged(MouseEvent event) {}
	public void mouseMoved(MouseEvent event) {}
}
