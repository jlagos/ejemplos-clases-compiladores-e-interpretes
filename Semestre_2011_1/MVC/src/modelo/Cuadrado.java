package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cuadrado extends Figura {

	private int ancho;
	
	public Cuadrado(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
		Rectangle a=new Rectangle(p,new Dimension(getAncho(), getAncho()));
		Rectangle b=new Rectangle(posicion,new Dimension(getAncho(), getAncho()));
		xs=p.x-posicion.x;
		ys=p.y-posicion.y;
		return a.intersects(b);   
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawRect(this.getX()+getAncho()/4, this.getY()+getAncho()/4, this.getAncho()/2, this.getAncho()/2);
		}
	}	
}
